package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import io.opencensus.internal.StringUtils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class login extends AppCompatActivity implements View.OnClickListener {

    static String[] user_email, user_pwd, name;
    static Long[] uid;
    static Long loginid;
    static int i; //資料庫長度
    String userid;

    @BindView(R.id.login)  Button login;
    @BindViews(R.id.id) EditText id;
    @BindViews(R.id.pwd) EditText pwd;
    @BindViews(R.id.yesnull) TextView yesnull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        user_email = new String[1000];
        user_pwd = new String[1000];
        uid = new Long[1000];
        name = new String[1000];
        TextView bb = findViewById(R.id.forget);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent change = new Intent(login.this, tryy.class);
                startActivity(change);
            }

        });

        /*忘記密碼，未寫完!*/
        yesnull.setText("");
        /*下面這段在寫登入，尚未連結資料庫，因此寫死*/
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("user")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            i = 0;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Log.d("HII", i+":"+document.getId() + " => " + document.getString("petname"));
                                user_email[i] = document.getString("email");
                                user_pwd[i] = document.getString("pwd");
                                uid[i] = document.getLong("uid");
                                name[i] = document.getString("name");
                                Log.d("22", i + ":" + user_email[i]);
                                Log.d("22", i + ":" + user_pwd[i]);
                                i++;
                            }
                        } else {
                            Log.w("000", "Error getting documents.", task.getException());
                        }
                    }
                });
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                int right = 0;
                if (id.getText().toString().isEmpty() || pwd.getText().toString().isEmpty()) {
                    yesnull.setText(getResources().getString(R.string.input_tip));
                } else {
                    for (int x = 0; x <= i; x++) {
                        if (id.getText().toString().equals(user_email[x]) && pwd.getText().toString().equals(user_pwd[x])) {
                            right = 1;
                            Intent pick = new Intent(login.this, photo.class);
                            userid = id.getText().toString();
                            loginid = uid[x];
                            startActivity(pick);
                        }
                    }
                    if (right != 1) {
                        Intent pick = new Intent(login.this, tryy.class);
                        startActivity(pick);
                    }
                }


        }

    }
}


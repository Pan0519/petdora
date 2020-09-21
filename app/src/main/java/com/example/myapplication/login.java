package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText id;
    EditText pwd;
    TextView yesnull;

    static Long loginid;
    String userid;
    public List<userInfo> userInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView bb = findViewById(R.id.forget);
        bb.setOnClickListener(this);

        /*忘記密碼，未寫完!*/
        yesnull = (TextView) findViewById(R.id.yesnull);
        yesnull.setText("");
        id = (EditText) findViewById(R.id.id);
        pwd = (EditText) findViewById(R.id.pwd);
        /*下面這段在寫登入，尚未連結資料庫，因此寫死*/
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("user")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.w("000", "Error getting documents.", task.getException());
                            return;
                        }

                        for (QueryDocumentSnapshot document : task.getResult()) {
                            userInfos.add(new userInfo(document));
                        }
                    }
                });
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                if (id.getText().toString().isEmpty() || pwd.getText().toString().isEmpty()) {
                    yesnull.setText(getResources().getString(R.string.input_tip));
                    return;
                }

                Intent pick = null;
                for (userInfo info : userInfos) {
                    if (info.mail.equals(id.getText()) && info.pwd.equals(pwd.getText())) {
                        loginid = info.uid;
                        userid = info.mail;
                        pick = new Intent(login.this, photo.class);
                        break;
                    }
                }

                if (pick == null) {
                    pick = new Intent(login.this, Main2Activity.class);
                }
                startActivity(pick);
                break;

            case R.id.forget:
                Intent change = new Intent(login.this, tryy.class);
                startActivity(change);
                break;
        }
    }
}

class userInfo {
    public String mail;
    public String name;
    public String pwd;
    public Long uid;

    public userInfo(QueryDocumentSnapshot info) {
        uid = info.getLong("uid");
        mail = info.getString("email");
        pwd = info.getString("pwd");
        name = info.getString("name");
    }
}


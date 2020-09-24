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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity implements View.OnClickListener {

//    static String[] user_email, user_pwd, name;
//    static Long[] uid;

    static Long loginid;
    String userid;


    @BindView(R.id.login)
    Button login;
    @BindView(R.id.id)
    EditText id;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.yesnull)
    TextView yesnull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
//        user_email = new String[1000];
//        user_pwd = new String[1000];
//        uid = new Long[1000];
//        name = new String[1000];

        TextView bb = findViewById(R.id.forget);
        bb.setOnClickListener(this);

        /*忘記密碼，未寫完!*/
        yesnull.setText("");
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

                        UserInfoManager.getInstance().SetUserInfos(task.getResult());
                    }
                });
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
                List<userInfo> infos = UserInfoManager.getInstance().GetUserInfos();
                for (userInfo info : infos) {
                    if (info.getMail().equals(id.getText()) && info.getPwd().equals(pwd.getText())) {
                        loginid = info.getUid();
                        userid = info.getMail();
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



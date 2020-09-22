package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class fragment extends AppCompatActivity {
    TextView title, sender, address, context, date;
    String[] act_title, act_address, act_context, act_sender;
    Date[] act_date;
    Long[] postid;
    List<Long> postid_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        act_title = new String[1000];
        act_sender = new String[1000];
        postid = new Long[1000];
        act_address = new String[1000];
        act_context = new String[1000];
        act_date = new Date[1000];
        title = findViewById(R.id.title);
        sender = findViewById(R.id.sender);
        address = findViewById(R.id.address);
        context = findViewById(R.id.sender);
        date = findViewById(R.id.date);
        final login _login = new login();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("active")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i = 0;
                            long x;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Log.d("HII", i+":"+document.getId() + " => " + document.getString("petname"));
                                act_title[i] = document.getString("title");
                                postid_list.add(document.getLong("postid"));
//                                postid[i]=document.getLong("postid");
                                act_address[i] = document.getString("address");
                                act_context[i] = document.getString("detail");
                                act_date[i] = document.getDate("posttime");
                                x = document.getLong("actid");
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                String newdate = DateFormat.getInstance().format(act_date[i]);
                                //act_context[i].substring(3,8);
                                act_context[i] = act_context[i].substring(0, 15) + "....";
                                Log.d("22", i + ":" + x);
                                for (userInfo info : _login.userInfos) {
                                    if (postid[i] == info.uid) {
                                        act_sender[i] = info.name;
                                        break;
                                    }
                                }
//                                for (int z = 0; z <= com.example.myapplication.login.i; z++) {
//                                    if (postid[i] == com.example.myapplication.login.uid(z)) {
//                                        act_sender[i] = com.example.myapplication.login.name[z];
//                                    }
//                                }

                                title.setText(act_title[i]);
                                sender.setText("發佈人:" + act_sender[i]);
                                address.setText("地點:" + act_address[i]);
                                context.setText(act_context[i]);
                                date.setText(newdate);

                                // Log.d("22",i+":"+user_pwd[i]);
                                i++;
                            }
                        } else {
                            Log.w("000", "Error getting documents.", task.getException());
                        }
                    }
                });


        Button pick = findViewById(R.id.send);
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent change = new Intent(fragment.this, release.class);
                startActivity(change);
            }

        });

        Button per = findViewById(R.id.personal);
        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent change = new Intent(fragment.this, person.class);
                startActivity(change);
            }

        });


//        Button imf= findViewById(R.id.act1);
//        imf.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent change = new Intent(fragment.this, cancel.class);
//                startActivity(change);
//            }
//
//        });

        Button home = findViewById(R.id.back);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent change = new Intent(fragment.this, photo.class);
                startActivity(change);
            }

        });


    }
}

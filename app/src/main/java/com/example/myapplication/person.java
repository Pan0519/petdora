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

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class person extends AppCompatActivity {
    Button act;
    String[] act_title,act_address,act_context,act_sender;
    Date[] act_date;
    Long[] postid;
    TextView title,sender,address,context,date;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        act_title=new String[1000];
        act_sender=new String[1000];
        postid=new Long[1000];
        act_address=new String[1000];
        act_context=new String[1000];
        act_date=new Date[1000];
        act=findViewById(R.id.act);
        act.setVisibility(View.INVISIBLE);
        title=findViewById(R.id.title2);
        sender=findViewById(R.id.sender);
        address=findViewById(R.id.address);
        context=findViewById(R.id.sender);
        date=findViewById(R.id.date);
        final login _login = new login();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("active")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i=0;
                            long x;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                postid[i]=document.getLong("postid");
                                if(postid[i]==com.example.myapplication.login.loginid){
                                    act.setVisibility(View.VISIBLE);
                                    act_title[i]=document.getString("title");
                                    postid[i]=document.getLong("postid");
                                    act_address[i]=document.getString("address");
                                    act_context[i]=document.getString("detail");
                                    act_date[i]=document.getDate("posttime");
                                    x=document.getLong("actid");
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                                    String newdate = sdf.format(act_date[i]);
                                    //act_context[i].substring(3,8);
                                    act_context[i]=act_context[i].substring(0,15)+"....";
                                    Log.d("22",i+":"+ x);
//                                    for(int z=0;z<=com.example.myapplication.login.i;z++){
//                                        if(postid[i]==com.example.myapplication.login.uid[z]){
//                                            act_sender[i]=com.example.myapplication.login.name[z];
//                                        }
//                                    }

                                    userInfo userInfo = UserInfoManager.getInstance().GetUserInfoByUid(postid[i]);
                                    if(userInfo!=null){
                                        act_sender[i] = userInfo.getName();
                                    }

                                    title.setText(act_title[i]);
                                    sender.setText("發佈人:"+act_sender[i]);
                                    address.setText("地點:"+act_address[i]);
                                    context.setText(act_context[i]);
                                    date.setText(newdate);

                                }

                                i++;
                            }
                        } else {
                            Log.w("000", "Error getting documents.", task.getException());
                        }
                    }
                });
        Button bb= findViewById(R.id.back);
        bb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(person.this, fragment.class);
                startActivity(change);
            }

        });

        Button rel= findViewById(R.id.join);
        rel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(person.this, praticipate.class);
                startActivity(change);
            }

        });
    }
}

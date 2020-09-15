package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class cancel extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        Button pick= findViewById(R.id.back);
        pick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent pick=new Intent(cancel.this,fragment.class);
                startActivity(pick);
            }

        });

        Button pick1= findViewById(R.id.button);
        pick1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent pick=new Intent(cancel.this,fragment.class);
                startActivity(pick);
            }

        });
    }
}

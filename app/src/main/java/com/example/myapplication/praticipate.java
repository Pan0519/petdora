package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class praticipate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_praticipate);
        super.onCreate(savedInstanceState);
        Button per= findViewById(R.id.back);
        per.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(praticipate.this, fragment.class);
                startActivity(change);
            }

        });

        Button send= findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(praticipate.this, person.class);
                startActivity(change);
            }

        });

    }
}

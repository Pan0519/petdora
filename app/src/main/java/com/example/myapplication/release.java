package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class release extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        Button per= findViewById(R.id.back);
        per.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(release.this, fragment.class);
                startActivity(change);
            }

        });
        Button reles= findViewById(R.id.button2);
        reles.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(release.this, fragment.class);
                startActivity(change);
            }

        });

    }
}


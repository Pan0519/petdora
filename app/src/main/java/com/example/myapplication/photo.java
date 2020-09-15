package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class photo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);



        ImageButton photo= findViewById(R.id.imageButton3);
        photo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,see.class);
                startActivity(fri);
            }

        });
        ImageButton photo1= findViewById(R.id.imageButton4);
        photo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,see.class);
                startActivity(fri);
            }
        });

        ImageButton photo2= findViewById(R.id.iii);
        photo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,see.class);
                startActivity(fri);
            }

        });
        ImageButton photo3= findViewById(R.id.one);
        photo3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,see.class);
                startActivity(fri);
            }

        });
        ImageButton photo4= findViewById(R.id.ii);
        photo4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,see.class);
                startActivity(fri);
            }

        });
        ImageButton photo5= findViewById(R.id.imageButton7);
        photo5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,see.class);
                startActivity(fri);
            }

        });
        Button act= findViewById(R.id.active);
        act.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,fragment.class);
                startActivity(fri);
            }

        });
        Button fri= findViewById(R.id.best);
        fri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,MainActivity.class);
                startActivity(fri);
            }

        });
        Button per= findViewById(R.id.personal);
        per.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent fri=new Intent(photo.this,Main5Activity.class);
                startActivity(fri);
            }

        });

        ImageButton bb= findViewById(R.id.imageButton10);
        bb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(photo.this,write.class);
                startActivity(change);
            }

        });

        Button tra= findViewById(R.id.translate);
        tra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent change = new Intent(photo.this,translate.class);
                startActivity(change);
            }

        });
    }
}

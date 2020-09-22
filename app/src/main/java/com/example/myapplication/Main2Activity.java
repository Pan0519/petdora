package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int temp = 0;
        for (int i = 1; i <= 4; i++) {
            temp = getResources().getIdentifier(String.format("imgbtn_%d", i), "id", getPackageName());
            ImageButton imgBtn = (ImageButton) findViewById(temp);
            imgBtn.setOnClickListener(this);
        }
//
//        ImageButton pick = findViewById(R.id.imgbtn_1);
//        pick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent pick = new Intent(Main2Activity.this, Main3Activity.class);
//                startActivity(pick);
//            }
//
//        });
//        ImageButton pick1 = findViewById(R.id.imgbtn_3);
//        pick1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent pick1 = new Intent(Main2Activity.this, Main3Activity.class);
//                startActivity(pick1);
//            }
//
//        });
//        ImageButton pick2 = findViewById(R.id.imgbtn_4);
//        pick2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent pick2 = new Intent(Main2Activity.this, Main3Activity.class);
//                startActivity(pick2);
//            }
//
//        });
//        ImageButton pick3 = findViewById(R.id.imgbtn_2);
//        pick3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent pick3 = new Intent(Main2Activity.this, Main3Activity.class);
//                startActivity(pick3);
//            }
//
//        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, String.valueOf(v.getId()), Toast.LENGTH_SHORT).show();
    }
}

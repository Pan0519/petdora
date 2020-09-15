package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.core.FirestoreClient;

public class tryy extends AppCompatActivity {

    TextView name1;
    TextView num;
    private FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authListener;
    //DatabaseReference df;
    String email="";
    String passwd;
    String[] user_email,user_pwd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tryy);
        user_email=new String[1000];
        user_pwd=new String[1000];
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("user")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int i=0;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                               // Log.d("HII", i+":"+document.getId() + " => " + document.getString("petname"));
                                user_email[i]=document.getString("email");
                                user_pwd[i]=document.getString("pwd");
                                Log.d("22",i+":"+user_email[i]);
                                Log.d("22",i+":"+user_pwd[i]);
                                i++;

                            }
                        } else {
                            Log.w("000", "Error getting documents.", task.getException());
                        }
                    }

                });




    }

}

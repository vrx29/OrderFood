package com.vineet.orderfood;

import android.app.IntentService;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.vineet.orderfood.Common.Common;
import com.vineet.orderfood.Model.User;

public class SignIn extends AppCompatActivity {

    EditText etNumber;
    EditText etPassword;
    Button btnSignIn;
    ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etNumber = findViewById(R.id.etNumber);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        mProgressBar =(ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tableUser = database.getReference("User");

         btnSignIn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 //progress Bar
                 mProgressBar.setVisibility(View.VISIBLE);



                 tableUser.addValueEventListener(new ValueEventListener() {

                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                         if (dataSnapshot.child(etNumber.getText().toString()).exists()) {
                             //get user information
                             User user = dataSnapshot.child(etNumber.getText().toString()).getValue(User.class);
                             user.setPhone(etNumber.getText().toString());

                             if (user.getPassword().equals(etPassword.getText().toString())) {
                                 Intent homeIntent = new Intent(SignIn.this, Home.class);
                                 Common.currentUser = user;
                                 startActivity(homeIntent);

                                 Toast.makeText(SignIn.this, "Sign in Successfully !", Toast.LENGTH_SHORT).show();

                             } else {
                                 Toast.makeText(SignIn.this, "Sign in failed !!!", Toast.LENGTH_SHORT).show();
                             }
                         }else {
                             mProgressBar.setVisibility(View.GONE);
                             Toast.makeText(SignIn.this, "User Doesn't Exist in Database!", Toast.LENGTH_SHORT).show();


                         }
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 });
             }
         });
    }
}

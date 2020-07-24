package com.example.deakinconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText mFullName,mEmail,mPassword,mPhone;
    Button mLoginBtn;
    FirebaseAuth fAuth;
    TextView mRegisterClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mFullName =findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email);
        mPassword=findViewById(R.id.password);
        mPhone=findViewById(R.id.phone);
        mLoginBtn=findViewById(R.id.login_button);
        fAuth=FirebaseAuth.getInstance();
        mRegisterClick=findViewById(R.id.reg_click);


        mRegisterClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email address is missing.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("password is required.");
                    return;
                }
                if(password.length()<8){
                    mPassword.setError("please enter a valid password of 8 characters");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),dashboard.class));
                            Toast.makeText(Login.this,"You have successfully logged in",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Login.this,"could not login"+ task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                });
            }
        });





    }
}

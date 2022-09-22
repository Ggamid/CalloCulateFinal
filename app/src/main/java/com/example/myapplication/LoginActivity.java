package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText edEmail,edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public void init(){
        firebaseAuth = FirebaseAuth.getInstance();
        edEmail = findViewById(R.id.UserEmail);
        edPassword = findViewById(R.id.UserPassword);
    }
    public void reg(View view){
        startActivity(new Intent(LoginActivity.this,RegActivity.class));
    }
    public void clickSingIn(View view){
        if (!edEmail.getText().toString().equals("")  && !edPassword.getText().toString().equals("")){
            String email = edEmail.getText().toString();
            String password = edPassword.getText().toString();
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            });
        }else{
            Toast.makeText(this, "Заполните поля 'Email' и 'Password'", Toast.LENGTH_SHORT).show();
        }

        }
    }


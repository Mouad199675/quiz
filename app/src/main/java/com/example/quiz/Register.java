package com.example.quiz;
/*
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.quiz.Models.Quiz;
import com.example.quiz.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends Activity {
    EditText etName, etMail, etLogin, etPassword;
    Button BRegister;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fAuth = FirebaseAuth.getInstance();
        etName = findViewById(R.id.etName);
        etMail = findViewById(R.id.etMail);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        BRegister = findViewById(R.id.BRegister);

        /*if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(Register.this, Quiz1.class));
            finish();
        }*/

        /*BRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etMail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(etName.getText().toString())
                        || TextUtils.isEmpty(etMail.getText().toString())
                        || TextUtils.isEmpty(etLogin.getText().toString())
                        || TextUtils.isEmpty(etPassword.getText().toString())
                ) {
                    Toast.makeText(Register.this, "Error", Toast.LENGTH_LONG).show();
                } else {
                    String name = etName.getText().toString();
                    String mail = etMail.getText().toString();
                    String login = etLogin.getText().toString();

                    for (User u : Config.users) {
                        if (u.getLogin().equals(login)) {
                            Toast.makeText(Register.this, "deja existe", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                    User user = new User(name, mail, login, password);
                    Config.users.add(user);
                    Toast.makeText(Register.this, "Is Add", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);

                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) { if (task.isSuccessful()) {

                                Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this, Quiz1.class));
                            } else {
                                Toast.makeText(Register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}*/


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends Activity {
    EditText etName, etMail, etLogin, etPassword;
    Button BRegister;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fAuth = FirebaseAuth.getInstance();
        etName = findViewById(R.id.etName);
        etMail = findViewById(R.id.etMail);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);
        BRegister = findViewById(R.id.BRegister);

        BRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= etName.getText().toString().trim();
                String email = etMail.getText().toString().trim();
                String login = etLogin.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    etMail.setError("Email in Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    etPassword.setError("Password in Required.");
                    return;
                }


                // register The user in firebase
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this,Login.class));
                        }
                        else{
                            Toast.makeText(Register.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });


    }
}
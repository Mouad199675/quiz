package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.quiz.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends Activity {

    //declaration
    EditText etPassword;
    EditText etMail;
    FirebaseAuth fAuth;
    Button BLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etMail=(EditText)findViewById(R.id.etMail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        BLogin=(Button)findViewById(R.id.BLogin);
        tvRegister=(TextView)findViewById(R.id.tvRegister);
        //String login = etLogin.getText().toString().trim();

        BLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String mail = etMail.getText().toString();
                String password = etPassword.getText().toString().trim();
               //if(TextUtils.isEmpty(etLogin.getText().toString())){
                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(Login.this,"Login is empty", Toast.LENGTH_LONG).show();
                }
               //else if (TextUtils.isEmpty(etPassword.getText().toString()))
                else if (TextUtils.isEmpty(password))
                   {
                    Toast.makeText(Login.this,"Password is empty", Toast.LENGTH_LONG).show();
                }
                else{

                   //String login=etLogin.getText().toString();
                   //String password=etPassword.getText().toString();

                    for (User us : Config.users){
                        if (us.getMail().equals(mail) && us.getPassword().equals(password)){
                            Toast.makeText(Login.this,"Welcome", Toast.LENGTH_LONG).show();

                            Intent intent= new Intent(Login.this, map.class);
                            startActivity(intent);
                            return;
                        }
                        Toast.makeText(Login.this,"Not exsist", Toast.LENGTH_LONG).show();
                    }

                }

                /*if(etLogin.getText().toString().equals("raja") && etPassword.getText().toString().equals("raja")){
                    startActivity(new Intent(Login.this,Quiz1.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login or password",Toast.LENGTH_SHORT).show();
                }*/


           // fAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()

           fAuth.getInstance().signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       Toast.makeText(Login.this,"User Created",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(Login.this,map.class));
                   }
                   else{
                       Toast.makeText(Login.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                   }
               }
           });
               }
           });

        tvRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                startActivity(new Intent(Login.this,Register.class));

            }
        });
    }
}

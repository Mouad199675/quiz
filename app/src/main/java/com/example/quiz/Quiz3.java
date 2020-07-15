package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz3 extends AppCompatActivity {

    RadioGroup rg;
    Button BNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        rg=findViewById(R.id.rg_Q);
        BNext=findViewById(R.id.BNext);

        BNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(Quiz3.this,"cliquer sur un choix",Toast.LENGTH_LONG).show();
                }else{

                    int score= getIntent().getIntExtra("score",0);
                    if (rg.getCheckedRadioButtonId()==R.id.rb2){
                        score++;
                    }
                    Toast.makeText(Quiz3.this,"ton score est :"+score,Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Quiz3.this,Scoore.class);
                    startActivity(intent);
                }
            }
        });
    }
}

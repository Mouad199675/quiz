package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz2 extends AppCompatActivity {

    RadioGroup rg;
    Button BNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);


        rg=findViewById(R.id.rg_Q);
        BNext=findViewById(R.id.BNext);

        BNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(Quiz2.this,"cliquer sur un choix",Toast.LENGTH_LONG).show();
                }else{
                    int score= getIntent().getIntExtra("score",0);
                    Intent intent = new Intent(Quiz2.this,Quiz3.class);
                    if (rg.getCheckedRadioButtonId()==R.id.rb3){
                        score++;
                    }
                    intent.putExtra("score",score);
                    startActivity(intent);
                }
            }
        });
    }
}

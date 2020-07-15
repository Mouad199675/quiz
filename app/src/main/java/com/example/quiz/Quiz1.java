package com.example.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.Models.Quiz;

import java.util.ArrayList;

public class Quiz1 extends Activity {

    RadioGroup rg;
    Button BNext;
    ArrayList<Quiz>  quizArrayList=new ArrayList<>();
    ImageView img_quiz;
    TextView txt_question;
    int cpt=0;
    int SCORETRUE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        rg=findViewById(R.id.rg_Q);
        BNext=findViewById(R.id.BNext);
        img_quiz=findViewById(R.id.img_quiz);
        txt_question=findViewById(R.id.tvq1);

        if(!Config.IsStatic) {
            remplirList();
            changeImage(quizArrayList.get(cpt));
        }

        BNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg.getCheckedRadioButtonId()==-1){
                    Toast.makeText(Quiz1.this,"cliquer sur un choix",Toast.LENGTH_LONG).show();
                }else{
                    if (Config.IsStatic){
                    int score=0;
                    if (rg.getCheckedRadioButtonId()==R.id.rb1){
                        score++;
                    }
                    Intent intent = new Intent(Quiz1.this,Quiz2.class);
                    intent.putExtra("score",score);
                    startActivity(intent);
                    }
                    else{
                        RadioButton radio_check=findViewById(rg.getCheckedRadioButtonId());
                        int index= rg.indexOfChild(radio_check);

                        if (quizArrayList.get(cpt).getRepTrue()==index){
                            SCORETRUE++;
                        }
                        if(BNext.getText().toString()=="FINISH")
                        {
                            Intent intent=new Intent(Quiz1.this,Scoore.class);

                            double score=((double) SCORETRUE/(double) quizArrayList.size())*100;
                            Log.e("tp1",String.valueOf(SCORETRUE));
                            Log.e("tp2",String.valueOf(quizArrayList.size()));
                            Log.e("err",String.valueOf(score));
                            intent.putExtra("ScoreFinal",(int)score);
                            startActivity(intent);
                        }else {
                            rg.clearCheck();
                            cpt++;
                            changeImage(quizArrayList.get(cpt));
                        }
                    }
                }
            }
        });

    }
    private void remplirList(){
        Quiz q1= new Quiz(R.drawable.chat,"c'est qoui ca ?","Chat","Pingouin","Lapin","A 4",0);
        Quiz q2= new Quiz(R.drawable.cheval,"c'est qoui ca ?","Poisson","Cheval","Hamster","B 4",1);
        Quiz q3= new Quiz(R.drawable.chien,"c'est qoui ca ?","Vache","Canard","Chien","C 4",2);
        //Quiz q4= new Quiz(R.drawable.chat,"Question n 1","D 1","D 2","D 3","D 4",4);
        quizArrayList.add(q1);
        quizArrayList.add(q2);
        quizArrayList.add(q3);
        //quizArrayList.add(q4);
    }

    private void changeImage(Quiz quiz) {
        img_quiz.setImageResource(quiz.getImage());
        txt_question.setText(quiz.getQuestion());
        RadioButton radio = null;

        radio = findViewById(R.id.rb1);
        radio.setText(quiz.getQuiz1());

        radio = findViewById(R.id.rb2);
        radio.setText(quiz.getQuiz2());

        radio = findViewById(R.id.rb3);
        radio.setText(quiz.getQuiz3());

        if(cpt==quizArrayList.size()-1)
        {
            BNext.setText("FINISH");
        }



    }
}

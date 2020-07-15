package com.example.quiz.Models;

public class Quiz {

    public int image;
    public String question;
    public  String quiz1;
    public  String quiz2;
    public  String quiz3;
    public  String quiz4;
    public int repTrue;

    public Quiz(int image, String question, String quiz1, String quiz2, String quiz3, String quiz4, int repTrue) {
        this.image = image;
        this.question = question;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
        this.quiz4 = quiz4;
        this.repTrue = repTrue;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(String quiz1) {
        this.quiz1 = quiz1;
    }

    public String getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(String quiz2) {
        this.quiz2 = quiz2;
    }

    public String getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(String quiz3) {
        this.quiz3 = quiz3;
    }

    public String getQuiz4() {
        return quiz4;
    }

    public void setQuiz4(String quiz4) {
        this.quiz4 = quiz4;
    }

    public int getRepTrue() {
        return repTrue;
    }

    public void setRepTrue(int repTrue) {
        this.repTrue = repTrue;
    }
}

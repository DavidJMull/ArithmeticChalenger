package com.example.dm00967.arithmeticchallenge;

// import statements here

import java.util.Random;

public abstract class ArithmeticChallenge {
    // fields initialized here
    private long mStartTime;
    private long mEndTime;
    private int mTurnsPerLevel;
    private String mQuestionText;
    private int[] mChoices = new int[3];
    private int cChoice;
    private int cCorrect;
    private int cHighScore = 0;
    private int cProgress;
    private boolean mCorrect;

    public ArithmeticChallenge(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        // to be implemented
        mTurnsPerLevel= TURNS_PER_LEVEL;

    }

    /******************************************************
     * Abstract Classes
     ******************************************************/

    abstract int[] createChoices();
    abstract String createQuestion();

    /******************************************************
     * Getters and Setters
     ******************************************************/


    protected String getQuestionText() {
        // gets question text from methods
        return mQuestionText;
    }

    protected void setQuestionText(String QuestionText) {
        // sets question
        mQuestionText = QuestionText;
    }
    protected String getChoice(int index) {
        // gets question text from methods
        return Integer.toString(mChoices[index]);
    }

    protected void setChoices(int[] choices) {
        // set unshuffled choices here
        shuffleChoices(choices);
        mStartTime = System.currentTimeMillis();
        for(int index = 0; index < 3; index++) {
            mChoices[index] = choices[index];
        }
    }
    protected void setHighScore(int HighScore){
        // to be implemented
            cHighScore= HighScore;
    }
    protected int getHighScore(){
        // to be implemented
        return cHighScore;
    }
    protected void setScore(boolean isCorrect){
        // to be implemented
        mEndTime = System.currentTimeMillis();
        if(isCorrect) {
            cCorrect += 20-(int)((int)mEndTime-(int)mStartTime)/1000;
        }
        else {
            cCorrect--;
        }

    }
    protected int getScore(){
        // to be implemented
        return cCorrect;
    }
    protected void setProgress(){
        // to be implemented
       if (mCorrect) {
           cProgress += 100 / mTurnsPerLevel;
       }
       }
    protected int getProgress(){
        // to be implemented
        return cProgress;
    }


    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice){
        // to be implemented
        if (mChoices[choice] == cChoice){
            mCorrect = true;
            return true;
        }
        else{
            mCorrect= false;
            return false;
        }
    }


    private void shuffleChoices(int[] choices) {
        int index, ind;
        cChoice= choices[2];
        Random random = new Random();
        for (int t = choices.length; t > 0; t--) {
            for (int i = choices.length - 1; i > 0; i--) {
                index = random.nextInt(i);
                ind = choices[index];
                choices[index] = choices[i];
                choices[i] = ind;
            }
        }
    }

    }



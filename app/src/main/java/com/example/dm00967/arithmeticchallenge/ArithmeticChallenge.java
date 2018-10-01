package com.example.dm00967.arithmeticchallenge;

// import statements here

import java.util.Random;

public abstract class ArithmeticChallenge {
    // fields initialized here
    private long mStartTime;
    private String mQuestionText;
    private int[] mChoices = new int[3];
    private int cChoice;

    public ArithmeticChallenge(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        // to be implemented
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


    // other getters and setters declared and implemented here

    /******************************************************
     * Concrete Classes
     ******************************************************/

    protected boolean isCorrect(int choice){
        // to be implemented


        return true;
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



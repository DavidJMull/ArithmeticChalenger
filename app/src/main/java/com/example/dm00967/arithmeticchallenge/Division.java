package com.example.dm00967.arithmeticchallenge;

import java.util.Random;

public class Division extends ArithmeticChallenge {
    // add fields here
    private int  one,two,switch1,switch2,switch3;
    private int choices[] = new int[3];

    public Division(int TOTAL_LEVELS, int TURNS_PER_LEVEL){
        super(TOTAL_LEVELS, TURNS_PER_LEVEL);
    }

    protected String createQuestion(){
        Random rand = new Random();
        one = rand.nextInt(10) + 1;
        two = rand.nextInt(10) + 1;

        String question = (one + " x " + two);
        return question;
    }


    protected int[] createChoices(){
        Random rand = new Random();
        do{
            switch1 = rand.nextInt(5) + 1;
            switch2 = rand.nextInt(5) + 1;
            switch3 = rand.nextInt(5) + 1;
        }while(switch1==switch2 || switch1==switch3 || switch2==switch3);

        int num = rand.nextInt(3);
        choices[0]= one*two+switch1;
        choices[1]= one*two-switch2;
        choices[2]= one*two-switch3;
        choices[num]= one*two;
        return choices;
    }
}

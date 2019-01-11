/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Arrays;

/**
 *
 * @author chris
 */
public enum Value {
    ACE (11),
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    JACK (10),
    QUEEN (10),
    KING (10);
    
    private final int numVal;
    
    private Value(int aNumVal){
        this.numVal = aNumVal;
    }
    
    int getNumVal(){
        return this.numVal;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(Value.values());
    }
}
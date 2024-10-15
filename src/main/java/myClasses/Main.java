package myClasses;

import myClasses.TripletDeque.TripletDeque;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        TripletDeque<String> tQueue = new TripletDeque<>();



        for(int i = 0; i < 10; i++){
            tQueue.addLast( String.valueOf(i) );
        }

        System.out.println(tQueue.toString());

        for(int i = 0; i < 10; i++){
            System.out.println((String.valueOf(i) + "----" + tQueue.removeFirst()));
        }
















    }
}
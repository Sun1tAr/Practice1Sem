package myClasses;

import myClasses.TripletDeque.Containerable;
import myClasses.TripletDeque.TripletDeque;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        TripletDeque<String> tQueue = new TripletDeque<>();

        Containerable cQueue = (Containerable) tQueue;

        for (int i =0; i < 8; i++){
            tQueue.addFirst(i+"");
        }
        System.out.println(tQueue.toString());
        tQueue.remove("2");
        System.out.println(tQueue.toString());


















    }
}
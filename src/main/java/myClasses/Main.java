package myClasses;

import myClasses.TripletDeque.Container;
import myClasses.TripletDeque.Containerable;
import myClasses.TripletDeque.TripletDeque;

import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {


        TripletDeque<String> tQueue = new TripletDeque<>();

        for (int i =0; i < 15; i++){
            tQueue.addFirst(i+"");
        }
        System.out.println(tQueue.toString());
        tQueue.removeLastOccurrence("6");
        System.out.println(tQueue.toString());



















    }
}
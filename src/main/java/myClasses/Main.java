package myClasses;

import myClasses.TripletDeque.Container;
import myClasses.TripletDeque.Containerable;
import myClasses.TripletDeque.TripletDeque;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        TripletDeque<String> tQueue = new TripletDeque<>();
        Deque<String> ttQueue = new TripletDeque<>();



        ttQueue.addAll(tQueue);
        System.out.println(ttQueue.toString()); // консольный дебажер



//        System.out.println(ttQueue.toString()); // консольный дебажер



















    }
}
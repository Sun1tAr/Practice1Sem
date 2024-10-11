package myClasses;

import myClasses.TripletDeque.TripletDeque;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        TripletDeque<Integer> deq = new TripletDeque<>();

        System.out.println(deq.offerLast(1));
        System.out.println(deq.offerLast(2));
        System.out.println(deq.offerLast(3));
        System.out.println(deq.offerLast(4));
        System.out.println(deq.offerLast(5));
        System.out.println(deq.offerLast(6));
        System.out.println(deq.offerLast(8));
        System.out.println(deq.offerLast(9));
        System.out.println(deq.offerLast(10));
        System.out.println(deq.offerLast(21));
        System.out.println(deq.offerLast(31));
        System.out.println(deq.offerLast(41));

        try {
            String s = Arrays.toString((deq.getContainerByIndex(1)));
            System.out.println(s);
        } catch (RuntimeException e){
            e.printStackTrace();
        }







    }
}
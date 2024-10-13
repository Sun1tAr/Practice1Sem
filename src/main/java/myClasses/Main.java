package myClasses;

import myClasses.TripletDeque.TripletDeque;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        TripletDeque<Integer> deq = new TripletDeque<>();

        System.out.println(deq.offerFirst(1));
        System.out.println(deq.offerFirst(2));
        System.out.println(deq.offerFirst(3));
        System.out.println(deq.offerFirst(4));
        System.out.println(deq.offerFirst(5));

        System.out.println(deq.offerFirst(6));
        System.out.println(deq.offerFirst(8));
        System.out.println(deq.offerFirst(9));
        System.out.println(deq.offerFirst(10));
        System.out.println(deq.offerFirst(21));

        System.out.println(deq.offerFirst(31));
        System.out.println(deq.offerFirst(41));

        try {
            String s = Arrays.toString((deq.getContainerByIndex(0)));
            System.out.println(s);
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        deq.iterator().hasNext();








    }
}
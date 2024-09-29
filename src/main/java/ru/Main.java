package ru;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SteriodArray str = new SteriodArray(5);
        str.add("1111");
        str.add("1211");
        str.add("1311");
        str.add("1411");
        str.add("1511");

        System.out.println(str.toString());
        System.out.println(str.remove("1211"));
        System.out.println(str.toString());
        System.out.println(str.get(2));

        System.out.println(str.length() + " / " + str.maxLength());




    }
}
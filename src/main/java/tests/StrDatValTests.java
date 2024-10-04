package tests;

import exceptions.EmptyDataException;
import exceptions.UnknownCharacterException;
import myClasses.StringDataValidator;

public class StrDatValTests {

    public static void start(){
        StrDatValTests.scenary1();
        StrDatValTests.scenary2();
        StrDatValTests.scenary3();
        StrDatValTests.scenary4();

    }

    private static void catchExceptions(String s1, String s2){
        System.out.println("---Вход 1: \n" + s1 + "\n---Вход 2: \n" + s2 + "\n---Выход:");

        try {
            System.out.println(StringDataValidator.validate(s1, s2));
        } catch (EmptyDataException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } catch (UnknownCharacterException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("---------------------------");
    }
    private static void scenary1(){
        String s1, s2;
        s1 = "qwert";
        s2 = "qwert";
        StrDatValTests.catchExceptions(s1, s2);
    }
    private static void scenary2(){
        String s1, s2;
        s1 = "qwt";
        s2 = "qwert";
        StrDatValTests.catchExceptions(s1, s2);
    }
    private static void scenary3(){
        String s1, s2;
        s1 = "йцукен";
        s2 = "йцукен";
        StrDatValTests.catchExceptions(s1, s2);
    }
    private static void scenary4(){
        String s1, s2;
        s1 = "";
        s2 = "qwert";
        StrDatValTests.catchExceptions(s1, s2);

    }
}

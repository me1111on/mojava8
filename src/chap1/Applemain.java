package chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Applemain {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "GREEN"), new Apple(155, "BLUE"), new Apple(120, "RED"));

        List<Apple> hvyapp = filterapp(inventory, new Applefunc.AppleWPredicate());
        List<Apple> Capp = filterapp(inventory, new Applefunc.AppleCPredicate());

    }

    public static List<Apple> filterapp(List<Apple> inv, Applefunc.ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inv){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


}

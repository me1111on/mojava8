package chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Applemain {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "GREEN"), new Apple(155, "BLUE"), new Apple(120, "RED"));
        List<Apple> heavyapple = filterapp(inventory, new Applefunc.AppleWPredicate());
        List<Apple> greenappple = filterapp(inventory, new Applefunc.AppleCPredicate());

        //익명 클래스를 이용하여 구현한 필터링 로직
        List<Apple> blueapple = filterapp(inventory, new Applefunc.ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "BLUE".equals(apple.getColor());
            }
        });


    }

    //프레디케이트를 이용하여 동작 파라메터 방식으로 구현한 filter 함수
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

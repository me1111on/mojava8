package chap1;

import java.util.Arrays;
import java.util.List;

public class Applefunc {

    public interface ApplePredicate {
        boolean test (Apple apple);
    }

    public static class AppleWPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public static class AppleCPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return "GREEN".equals(apple.getColor());
        }
    }



}

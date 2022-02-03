package chap5;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class makingstream {

    public static void main(String[] args) {

        //값으로 스트림 만들기
        Stream<String> stream = Stream.of("abc","abb", "acc", "ccc", "dda");
        stream.map(String::toUpperCase).forEach(System.out::println);


        //널이 될 수 있는 객체로 스트림 만들기
        Stream<String> homevalue = Stream.ofNullable(System.getProperty("home"));
        Stream<String> envvalues = Stream.of("config", "home", "igonupsir")
                .flatMap(key->Stream.ofNullable(System.getProperty(key)));

        //배열로다가 바로 스트림 만들기
        int[] intnumbers = {2,3,4,2,1,23,231,2,0};
        int sums = Arrays.stream(intnumbers).sum();

        //한무 스트림 만들기 1
        Stream.iterate(0, n->n+2).limit(10).forEach(System.out::println);
        IntStream.iterate(0, n-> n<30, n-> n+3).forEach(System.out::println);

        //IntStream.iterate(0, n -> n+2).filter(n -> n < 30).forEach(System.out::println);
        IntStream.iterate(0, n -> n+2).takeWhile(n -> n > 30).forEach(System.out::println);

    }
}

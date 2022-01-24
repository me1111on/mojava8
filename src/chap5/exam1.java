package chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class exam1 {
    public static class Trader{
        private final String name; private final String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }

        public String toString(){
            return "Trader : " + this.name + " in " + this.city;
        }
    }

    public static class Transaction {
        private final Trader trader; private final int year; private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return trader;
        }

        public int getYear() {
            return year;
        }

        public int getValue() {
            return value;
        }

        public String toString(){
            return "{" + this.trader + " // y: " + this.year + " // val : " + this.value;
        }






    }


    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("mario", "mailan");
        Trader alan = new Trader("alan", "Cambridge");
        Trader brain = new Trader("Brain", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brain, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );



        //2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하라
        List<Transaction> upwardlist = transactionList.stream()
                .filter((t1) -> t1.getYear() == 2011)
                .sorted((t1, t2)-> t1.getValue()-t2.getValue())
                .collect(Collectors.toList());

        //거래자가 근무하는 모든 도시를 중복 없이 나열하시오
        List<String> allcites = transactionList.stream()
                .map(t1 -> t1.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());


        //케임브리지에서 근부하는 모든 거래자를 찾아서 이름순으로 정렬하라
        List<Trader> camb = transactionList.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        //모든 거래자의 이름을 알파벳순으로 정렬해서 반환
        String alltre = transactionList.stream()
                .map( t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (t1, t2) -> t1 + t2);

        //밀라노에 거래자가 있나?
        Boolean ismilt = transactionList.stream()
                .anyMatch(t -> t.getTrader().getCity() == "mailan");

        //케임브릿지에 거주하는 거래자의 모든 트랜잭션값을 출력하라
        transactionList.stream()
                .filter(t -> t.getTrader().getCity() == "Cambridge")
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //전체 트랜잭션중 최댓값은 얼마?
        Optional<Integer> maxtran = transactionList.stream()
                .map(Transaction::getValue)
                        .reduce(Integer::max);

        //전체 트랜잭션중 최소값을 언마?
        Optional<Integer> mintran = transactionList.stream()
                        .map(Transaction::getValue)
                                .reduce(Integer::min);


        System.out.println(upwardlist);

    }


}
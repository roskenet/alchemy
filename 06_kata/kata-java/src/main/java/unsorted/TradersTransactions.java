package unsorted;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class TradersTransactions {

    public static class Trader {
        private final String name;
        private final String city;

        public Trader(String n, String c) {
            this.name = n;
            this.city = c;
        }

        public String getName() {
            return this.name;
        }

        public String getCity() {
            return this.city;
        }

        public String toString() {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return this.trader;
        }

        public int getYear() {
            return this.year;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value:" + this.value + "}";
        }
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        // 1. Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("Aufgabe 1:");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparingInt(Transaction::getValue))
                .forEach(System.out::println);

        // 2. What are all the unique cities where the traders work?
        System.out.println("Aufgabe 2:");
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // 3. Find all traders from Cambridge and sort them by name.
        System.out.println("Aufgabe 3:");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // 4. Return a string of all traders’ names sorted alphabetically.
        System.out.println("Aufgabe 4:");
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // 5. Are any traders based in Milan?
        System.out.println("Aufgabe 5:");
        var hasMilanBasedTrader = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(hasMilanBasedTrader);

        // 6. Print the values of all transactions from the traders living in Cambridge.
        System.out.println("Aufgabe 6:");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(t -> t.getValue())
                .forEach(System.out::println);

        // 7. What’s the highest value of all the transactions?
        System.out.println("Aufgabe 7:");
        transactions.stream()
                .mapToInt(Transaction::getValue).max()
                .ifPresent(System.out::println);

        // 8. Find the transaction with the smallest value.
        System.out.println("Aufgabe 8:");
        transactions.stream()
                .sorted(comparingInt(Transaction::getValue))
                .limit(1)
                .forEach(System.out::println);
    }
}

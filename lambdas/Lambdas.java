import java.util.function.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambdas {
    public static void main(String[] args) {
        // 1) No parameters (using method reference)
        Runnable greet = Lambdas::printGreeting;
        greet.run();

        // 2) One parameter (using method reference)
        Function<Integer, Integer> square = Lambdas::calculateSquare;
        System.out.println("Square of 5: " + square.apply(5));

        // 3) Multiple parameters (using method reference)
        BinaryOperator<Integer> sum = Integer::sum;
        System.out.println("Sum of 3 and 4: " + sum.apply(3, 4));

        // 4) Comparison and sorting (using Comparator.comparingInt)
        List<String> words = Arrays.asList("short", "very long", "medium");
        words.sort(Comparator.comparingInt(String::length));
        System.out.println("Words sorted by length: " + words);

        // 5) Multiple statements (using streams and collectors)
        BiFunction<String, Integer, String> repeat = Lambdas::repeatString;
        System.out.println("Repeat 'Ha' 3 times: " + repeat.apply("Ha", 3));

        // 6) New example: List processing with streams
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquares = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .map(n -> n * n)
                                           .collect(Collectors.toList());
        System.out.println("Squares of even numbers: " + evenSquares);

        // 7) New example: Reduction with streams
        int sum1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of all numbers: " + sum1);
    }

    private static void printGreeting() {
        System.out.println("Lambda without parameters (using method reference)");
    }

    private static int calculateSquare(int x) {
        return x * x;
    }

    private static String repeatString(String str, int times) {
        return IntStream.range(0, times)
                        .mapToObj(i -> str)
                        .collect(Collectors.joining());
    }
}
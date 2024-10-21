import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.List;
import java.util.Arrays;

public class LambdaExpressionExamples {
    public static void main(String[] args) {
        // 1. Create a Predicate<String> that checks if a string is empty
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println("Is \"\" empty? " + isEmpty.test(""));
        System.out.println("Is \"Hello\" empty? " + isEmpty.test("Hello"));

        // 2. Create a Function<Integer, String> that converts an integer to a string
        Function<Integer, String> intToString = i -> Integer.toString(i);
        System.out.println("Integer 42 to String: " + intToString.apply(42));

        // 3. Create a Consumer<List<String>> that prints each element of the list
        Consumer<List<String>> printList = list -> list.forEach(System.out::println);
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("Printing list elements:");
        printList.accept(fruits);

        // 4. Create a Supplier<Double> that generates a random number between 0 and 1
        java.util.function.Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
    }
}
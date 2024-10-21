import java.util.function.*;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        System.out.println("Demonstrating Key Functional Interfaces in Java:");

        // 1. Function<T,R>
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Function (square): " + square.apply(5));

        // 2. Predicate<T>
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println("Predicate (isEven): " + isEven.test(4));

        // 3. Consumer<T>
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        System.out.print("Consumer (printUpperCase): ");
        printUpperCase.accept("hello");

        // 4. Supplier<T>
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Supplier (random): " + randomSupplier.get());

        // 5. UnaryOperator<T>
        UnaryOperator<Integer> increment = x -> x + 1;
        System.out.println("UnaryOperator (increment): " + increment.apply(5));

        // 6. BinaryOperator<T>
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println("BinaryOperator (sum): " + sum.apply(3, 4));

        // Custom Functional Interface
        TriFunction<Integer, Integer, Integer, Integer> volumeCalculator = 
            (length, width, height) -> length * width * height;
        System.out.println("Custom TriFunction (volumeCalculator): " + 
                           volumeCalculator.apply(2, 3, 4));

        System.out.println("\nExercise Solutions:");

        // 1. A function that squares an integer
        Function<Integer, Integer> squareFunction = x -> x * x;
        System.out.println("1. Square function: " + squareFunction.apply(7));

        // 2. A predicate that checks if a number is even
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        System.out.println("2. Is even predicate: " + isEvenPredicate.test(6));

        // 3. A consumer that prints a string in uppercase
        Consumer<String> uppercasePrinter = s -> System.out.println(s.toUpperCase());
        System.out.print("3. Uppercase printer: ");
        uppercasePrinter.accept("functional programming");

        // 4. A supplier that generates a random number
        Supplier<Double> randomNumberSupplier = Math::random;
        System.out.println("4. Random number supplier: " + randomNumberSupplier.get());

        // Additional example: Combining functional interfaces
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
               .filter(isEven)
               .map(square)
               .forEach(x -> System.out.print(x + " "));
        System.out.println("\nSum of squares of even numbers: " + 
                           numbers.stream()
                                  .filter(isEven)
                                  .map(square)
                                  .reduce(0, Integer::sum));
    }
}
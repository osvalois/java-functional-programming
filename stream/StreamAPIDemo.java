import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIDemo {
    public static void main(String[] args) {
        // Creating Streams
        System.out.println("Creating Streams:");
        
        // 1. From Collections
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date");
        Stream<String> streamFromCollection = stringList.stream();
        System.out.println("Stream from collection: " + streamFromCollection.collect(Collectors.toList()));

        // 2. From Arrays
        String[] stringArray = {"alpha", "beta", "gamma"};
        Stream<String> streamFromArray = Arrays.stream(stringArray);
        System.out.println("Stream from array: " + streamFromArray.collect(Collectors.toList()));

        // 3. Using Stream.of()
        Stream<Integer> streamOfIntegers = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream using Stream.of(): " + streamOfIntegers.collect(Collectors.toList()));

        // 4. Using Stream.generate() (limited to avoid infinite stream)
        Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
        System.out.println("Stream using Stream.generate(): " + randomStream.collect(Collectors.toList()));

        // Intermediate Operations
        System.out.println("\nIntermediate Operations:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> processedNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)  // Keep only even numbers
            .map(n -> n * n)          // Square the numbers
            .sorted()                 // Sort the results
            .distinct()               // Remove duplicates
            .peek(System.out::println) // Print each element (intermediate operation)
            .collect(Collectors.toList()); // Collect results to a list

        System.out.println("Processed numbers: " + processedNumbers);

        // Terminal Operations
        System.out.println("\nTerminal Operations:");

        // forEach
        System.out.print("ForEach: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // reduce
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum using reduce: " + sum);

        // count
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println("Count of numbers greater than 5: " + count);

        // anyMatch, allMatch, noneMatch
        boolean anyGreaterThan9 = numbers.stream().anyMatch(n -> n > 9);
        boolean allLessThan11 = numbers.stream().allMatch(n -> n < 11);
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Any greater than 9? " + anyGreaterThan9);
        System.out.println("All less than 11? " + allLessThan11);
        System.out.println("None negative? " + noneNegative);

        // findFirst
        int firstEven = numbers.stream().filter(n -> n % 2 == 0).findFirst().orElse(0);
        System.out.println("First even number: " + firstEven);

        // Advanced Concepts
        System.out.println("\nAdvanced Concepts:");

        // Parallel Streams
        long startTime = System.currentTimeMillis();
        long parallelCount = numbers.parallelStream().filter(n -> {
            try {
                Thread.sleep(10); // Simulate time-consuming operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return n % 2 == 0;
        }).count();
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel stream count of even numbers: " + parallelCount);
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        // Short-circuiting
        boolean hasEvenNumber = numbers.stream()
                                       .peek(n -> System.out.println("Processing: " + n))
                                       .anyMatch(n -> n % 2 == 0);
        System.out.println("Has even number (short-circuit): " + hasEvenNumber);

        // Exercise: Stream API Operations
        System.out.println("\nExercise: Stream API Operations");
        int exerciseSum = numbers.stream()
                                 .filter(n -> n % 2 == 0)
                                 .map(n -> n * n)
                                 .reduce(0, Integer::sum);
        System.out.println("Sum of squares of even numbers: " + exerciseSum);
    }
}
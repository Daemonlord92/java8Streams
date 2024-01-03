import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class App {
    private static final double taxRate = 0.06;

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        List<Integer> square = numbers.stream()
                        .map(x -> x*x)
                        .toList();

        Function<Integer,Integer> sq = x -> x * x;

        System.out.println(numbers);
        System.out.println(square);

        //Lambda Functions are nameless functions


        //FunctionalInterfaces
        // Predicate, Consumer, Supplier, Function

        //Predicate Functions that takes in an argument and returns a boolean based off of conditions set.
        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isEven.test(5));

        //Consumer Functions take in an argument but returns nothing

        Consumer<String> printInfo = System.out::println;

        String name = "bob";
        printInfo.accept(name);

        // Supplier Functions don't take in any Arguments but does return something

        Supplier<Double> getRandomDouble = Math::random;

        System.out.println(getRandomDouble.get());

        // Function Functions can take in one data type and return another

        Function<Integer, String> parseIntToString = String::valueOf;

        System.out.println(parseIntToString.apply(6));

        MyFunctionalInterface<String> printInformation = System.out::println;

        printInformation.print("Billy Bob Joe");
        printInformation.print(String.valueOf(56564564));

        List<String> places = new ArrayList<>();
        places.add("Philippines, Manila");
        places.add("USA, Virgina");
        places.add("USA, Alaska");
        places.add("Mexico, Alamo");
        places.add("Japan, Tokyo");
        places.add("Russia, Moscow");

        places.stream()
                .filter(p -> p.startsWith("USA"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        Printer printer = System.out::println;

        for (String place : places) {
            printer.print(place);
        }

        Printer ob = Teacher::show;

        ob.print("Matt");

        Teacher teacher = new Teacher();

        Printer o = teacher::display;
        o.print("Moscow");



        numbers.parallelStream()
                .forEach(num ->
                        System.out.println(num + " " +
                                Thread.currentThread().getName() + " " +
                                Thread.currentThread().getState()));

        numbers.stream()
                .forEach(num ->
                        System.out.println(num + " " +
                                Thread.currentThread().getName() + " " + Thread.currentThread().getState()));

        List<Integer> numList = Arrays.asList(10, 23, 34,13,17,18,234,111,245);

        numList.stream().filter(x -> x%2==0)
                .forEach(System.out::println);
        int result = numList.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(result);

        double doubleResult = numList.stream()
                .filter(x -> x > 20)
                .mapToDouble(x -> x * 0.9)
                .sum();

        System.out.println(result);

        result = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(result);


    }

    //Pure Function
    //A function that does not use a variable outside the function to change the result
    public static int add(int a, int b) {
        return a + b;
    }

    //Impure Function
    //A function that uses a variable outside the function.
    //As shown in the example calTax uses the variable taxRate which declared outside the function to make modifications.

    public static double calTax(double amount) {
        return amount * taxRate;
    }
}

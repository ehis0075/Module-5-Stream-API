package org.paumard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author ehis
 */
public class Main {

    public static void main(String[] args) {

        //ex
        IntStream stream = "hello".chars();



        //ex
        String book = "i am a book";
        Stream<String> words = Pattern.compile("[^\\p{javaLetter}]")
                                      .splitAsStream(book);

        //how to build stream
        //first build a Stream.Builder using the StringBuilder pattern
        Stream.Builder<String> builder = Stream.builder();

        //add data in the builder by chaining the add() method
        builder.add("one").add("two").add("three");
        //or by calling accept() method
        builder.accept("four");

        //then build the stream
        Stream<String> stream1 = builder.build(); //call the build() method

        //and use the Stream
        stream1.forEach(System.out::println);

        Person p1 = new Person("Alice", 18);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 18);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Francisco", 18);


        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        //persons.add(p1);

        //the map, filter, reduce using the stream api
        persons.stream()   //Stream<Person>
                .map(p -> p.getAge())   //Stream<Integer>
                .filter(age -> age > 20)   //Stream<Integer>
                .forEach(System.out::println);   //print out the age of people > 20


        // printing out the people themselves
        persons.stream()
                .filter(p -> p.getAge() > 20)
                .forEach(System.out::println);

        //intermediate and terminal calls
        persons.stream()   //Stream<Person>
                .map(p -> p.getAge())   //Stream<Integer>
                .peek(System.out::println)
                .filter(pn -> p1.getAge() > 20)   //Stream<Integer>
                .forEach(System.out::println);


        //using skip() and limit()
        //used to select part of a stream
        persons.stream()
                .skip(2) //skip first two
                .limit(3)  //limit to the next 3
                .filter(p -> p.getAge() > 20)
                .forEach(System.out::println);

        //match reduction
        boolean b =
                persons.stream()
                        .anyMatch(person -> person.getAge() > 20);

        boolean b1 =
                persons.stream()
                        .allMatch(person -> person.getAge() > 20);

        boolean b2 =
                persons.stream()
                        .noneMatch(person -> person.getAge() > 20);

        //find Reduction
//        Optional<Person> opt = persons.stream()
//                                      .findFirst(p -> p.getAge() > 20);

//        Optional<Person> opt = persons.stream()
//                                      .findAny(p -> p.getAge() > 20);

        //reduce reduction
        //first version
//        int sumOfAges =
//        persons.stream()
//                .reduce(0,(s1, s2) -> s1.getAge() + s2.getAge());

        //second version
//        int maxOfAges =
//        persons.stream()
//                .reduce(0,(z1, z2) -> Integer.max(z1.getAge() + z2.getAge()));

           //third version of reduce method: used in parallel operations
        List<Integer> ages =
        persons.stream()
                .reduce(
                        new ArrayList<Integer>(),
                        (list, p) -> { list.add(p.getAge()) ; return list ;},
                        (list1, list2) -> { list1.addAll(list2); return list1 ;}
                );

        //examples
        //building streams
        List<Integer> ints = Arrays.asList(1,2,3,4);

        System.out.println();
        Stream<Integer> stream2 =ints.stream();
        stream2.forEach(System.out::println);

        System.out.println();
        Stream<Integer> stream3 =Stream.of(1,2,3,4);
        stream3.forEach(System.out::println);


        //using the generate method
        Stream<String> streamOfStrings = Stream.generate(() -> "one");

        System.out.println();
        streamOfStrings.limit(4).forEach(System.out::println);

        //using the iterate method
        Stream<String> streamOfStrings2 = Stream.iterate("+", c -> c + "+");

        System.out.println();
        streamOfStrings2.limit(5).forEach(System.out::println);

        //using threadLocalRandom
        IntStream streamOfInts = ThreadLocalRandom.current().ints();
        System.out.println();
        streamOfInts.limit(5).forEach(System.out::println);




    }
}

package org.paumard;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                .filter(age -> age > 20)   //Stream<Integer>
                .forEach(System.out::println);

    }
}

package org.paumard;


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


    }
}

Stream api
- introduced in jdk 8
- patterns to build streams, connecting streams to our data
- First streams pattern, mapping, filtering and basic reduction steps
- how to build more complex reductions, we will use Optionals

what is a stream?
-A stream is a typed interface, a new concept in java 8
public interface Stream<T> extends BaseStream<T, Stream<T>> {

}

- we also have other streams like IntStream, LongStream and DoubleStream, these streams are built on primitive type
  of java
- a stream does not hold any data, it pulls the data it processes from a source.
- a stream does not modify the data it processes cus we want to process the data in parallel with no visibility issues.
  since we want to process the data in parallel, we are going to distribute these data among all the cores of our processors.
- the source may be unbounded, i.e a stream in itself can process as many data as we want as many data as we need.
- most of the time, the size of the source is not known at build time.


How to build streams (different stream patterns)
List<Person> people = ........;
   Stream<Person> stream = people.stream();  note that the stream() method is define in the collection api

1. an empty stream 
Stream.empty(); returns an empty stream

2. a singleton Stream
Stream.of("one"); 

3. a stream with several elements
 Stream.of("one", "two", "three");

4. a constant Stream
 Stream.generate(() -> "one");

5. a growing stream
 Stream.iterate("+", s -> s + "+");

6. a random Stream
  ThreadLocalRandom.current().ints();


intermediate and terminals calls on streams
- example are forEach() and peek() methods
- the peek used mainly for debugging not for production
- peek() is an intermediate operation while forEach() is a terminal operation

- a terminal operation triggers the processing of a stream.
- if i have no terminal operation, no data will be processed and no result will be provided

- an intermediate call does not trigger anything, having just intermediate calls no data will be processed.

Match reduction operations
- three types: anyMatch(), allMatch() and noneMatch()
- there are all terminals operations that return a boolean
also called short-circuiting terminal operations

Find Reduction operations
- two types: findFirst() and findAny()
- they might have nothing to return. they should return Optional instead of empty

Reduce Reduction steps
- there are three types of reduce reduction:
1. if no identity element is provided, then an Optional is returned.
2. associativity is assumed for the reduction function, but not enforced.
3. 
package felix.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapDemo {

    public static void main(String[] args) {

    final List<String> sentences = Arrays.asList(
            "This is the first line.",
            "The second line of this text.",
            "Third line contains some text.",
            "Last line and goodbye:",
            "End of text!");

    Stream<String> sentenceStream = sentences.stream();

    // here we have full sentences per element.

    Stream<Stream<String>> streamInStream = sentenceStream.peek( e -> {
        System.out.println(e);
    }).map(line -> Stream.of(line.split(" ")));

    // verschachtelter Stream
    // daher:

    Stream<String> words = sentenceStream.flatMap(line -> Stream.of(line.split(" ")));

    }

}

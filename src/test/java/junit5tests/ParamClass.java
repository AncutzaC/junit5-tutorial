package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamClass {
    static Stream<Arguments> sourceStream_StringDouble1() {
        return Stream.of (arguments("tomato", 2.0),
                arguments("carrot", 4.5), arguments(
                        "cabbage", 7.8));
    }
}

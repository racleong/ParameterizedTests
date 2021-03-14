import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyTest {
  private List<Integer> list;

  @BeforeAll
  void before() {
    list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
  }

  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4,5})
  void list_contains(int data) {
    assertTrue(list.contains(data));
  }

  @ParameterizedTest
  @ValueSource(strings = {"a","b","c"})
  void string_does_not_contain(String data){
    assertFalse("test".contains(data));
  }

  static Stream<Arguments> testCreateAndReturn() {
    return Stream.of(
      Arguments.arguments(6, Math.abs(-6)),
      Arguments.arguments(9.0, Math.sqrt((81))),
      Arguments.arguments(81.0, Math.pow(3,4))
    );
  }

  @ParameterizedTest
  @MethodSource("testCreateAndReturn")
  void test_math_expressions(double expected, double actual) {
    assertEquals(expected, actual);
  }

}

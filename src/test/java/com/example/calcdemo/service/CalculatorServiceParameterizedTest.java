package com.example.calcdemo.service;



import com.example.calcdemo.exception.DivByZeroException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParameterizedTest {
    private final CalcServiceImpl calculatorService = new CalcServiceImpl();
    public static Stream<Arguments> sumTestParams() {
        return Stream.of(
                Arguments.of("1","2",3),
                Arguments.of("-1","2",1)
        );
    }
    public static Stream<Arguments> subTestParams() {
        return Stream.of(
                Arguments.of("1","2",-1),
                Arguments.of("-1","2",-3)
        );
    }
    public static Stream<Arguments> multTestParams() {
        return Stream.of(
                Arguments.of("1","2",2),
                Arguments.of("-1","2",-2)
        );
    }
    public static Stream<Arguments> divTestParams() {
        return Stream.of(
                Arguments.of("1","2",0.5),
                Arguments.of("-1","2",-0.5)
        );
    }
public static Stream<Arguments> divNegativeTestParams() {
        return Stream.of(
                Arguments.of("1","0"),
                Arguments.of("-1","0")
        );
    }

    @ParameterizedTest
    @MethodSource("sumTestParams")
    public void sumTest(String a, String b, int expected) {
        Assertions.assertThat(calculatorService.sum(a,b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("subTestParams")
    public void subTest(String a, String b, int expected) {
        Assertions.assertThat(calculatorService.sub(a,b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("multTestParams")
    public void multTest(String a, String b, int expected) {
        Assertions.assertThat(calculatorService.mult(a,b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("divTestParams")
    public void divTest(String a, String b, double expected) {
        Assertions.assertThat(calculatorService.div(a,b))
                .isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("divNegativeTestParams")
    public void divNegativeTest(String a, String b) {
        Assertions.assertThatExceptionOfType(DivByZeroException.class)
                .isThrownBy(() ->calculatorService.div(a,b));
    }
}

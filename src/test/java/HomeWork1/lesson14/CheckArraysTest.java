package HomeWork1.lesson14;

import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CheckArraysTest {
    private CheckArrays checkArrays;

    @BeforeEach
    void startTest() {
        checkArrays = new CheckArrays();
        PropertyConfigurator.configure("src/main/resources/logs/config/log4j.properties");
    }


    @DisplayName("Проверка смещения c параметрами")
    @ParameterizedTest
    @MethodSource("data")
    void shiftParametrized(int[] expected, int[] curArray, int shiftSize) {
        //Assertions.assertArrayEquals(new int[]{10,2,6,8},checkArrays.shiftTwo(new int[]{6,8,10,2},2));
        Assertions.assertArrayEquals(expected, checkArrays.shiftTwo(curArray, shiftSize));
    }

    static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(new int[]{4, 1, 2, 3}, new int[]{1, 2, 3, 4,}, 1),
                Arguments.arguments(new int[]{3, 4, 1, 2}, new int[]{1, 2, 3, 4,}, 2),
                Arguments.arguments(new int[]{2, 3, 2, 1}, new int[]{1, 2, 3, 4,}, 3),
                Arguments.arguments(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4,}, 5),
                Arguments.arguments(new int[]{4, 3, 2, 1}, new int[]{1, 2, 3, 4,}, 1)
        );
    }

    @DisplayName("Проверка точки баланса на TRUE")
    @ParameterizedTest
    @MethodSource("dataBalanceTrue")
    void balanceTestTrue(int[] arr) throws IOException {
        Assertions.assertTrue(checkArrays.checkBalance(arr));
    }
    static Stream<Arguments> dataBalanceTrue() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3, 2, 2}),
                Arguments.arguments(new int[]{1, 3, 3, 2}),
                Arguments.arguments(new int[]{10, 4, 5, 1}),
                Arguments.arguments(new int[]{1, 3, -2, -2}),
                Arguments.arguments(new int[]{1, 3, -2, -2}),
                Arguments.arguments(new int[]{-10, -2, -5,-7}),
                Arguments.arguments(new int[]{-10, 5, 5, 0}),
                Arguments.arguments(new int[]{10, 2, 5, 17}));
    }


    @DisplayName("Проверка точки баланса на FALSE")
    @ParameterizedTest
    @MethodSource("dataBalanceFalse")
    void balanceTestFalse(int[] arr) throws IOException {
        Assertions.assertTrue(checkArrays.checkBalance(arr));
    }
    static Stream<Arguments> dataBalanceFalse() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3, 2, 2}),
                Arguments.arguments(new int[]{1, 3, 3, 2}),
                Arguments.arguments(new int[]{10, 4, 5, 1}),
                Arguments.arguments(new int[]{1, 3, -2, -2}),
                Arguments.arguments(new int[]{1, 3, -2, -2}),
                Arguments.arguments(new int[]{-10, -2, -5,-7}),
                Arguments.arguments(new int[]{-10, 5, 5, 0}),
                Arguments.arguments(new int[]{10, 2, 5, 17}));
    }



}
package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("test one plus two returns three")
    void testOnePlusTwoReturnsThree() {
        int result = calculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Test empty string returns 0")
    void testEmptyStringReturnsZero() {
        int result = calculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test ()
    @DisplayName("Test bad string throws exception")
    void testBadStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("a"));
    }

    @Test
    @DisplayName("Test 6 total with newline returns 6")
    void test6TotalWithNewlineReturns6() {
        int result = calculator.add("1,2\n3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Test with delimiter set to ;")
    void testWithDelimiterSetTo() {
        int result = calculator.add("//[;]\n1;2\n3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Test negative throws exception")
    void testNegativeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("-1,2\n-3"));
    }
    @Test
    @DisplayName("Test 1001 counts as 0")
    void test1001CountsAsZero () {
        int result = calculator.add("1001,2\n3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Test asda works as delimiter")
    void testAsdaWorksAsDelimiter(){
        int result = calculator.add("//asda\n1asda2\n3");
        assertThat(result).isEqualTo(6);
    }
    @Test
    @DisplayName("Testing da brackets")
    void testingDaBrackets(){
        int result = calculator.add("//[asda][sws]\n1asda2sws3");
        assertThat(result).isEqualTo(6);
    }

}

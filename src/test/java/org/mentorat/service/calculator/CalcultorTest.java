package org.mentorat.service.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mentorat.service.UserAdapter;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class CalcultorTest {

    private Calculator calculator;

    private UserAdapter mockedAdapter;

    public static Stream<Arguments> OperandWithEquivalent() {
        return Stream.of(
                arguments(Calculator.Operand.ADDITION, "+"),
                arguments(Calculator.Operand.SUBSTRACTION, "-"),
                arguments(Calculator.Operand.DIVISION, "/"),
                arguments(Calculator.Operand.MULTIPLICATION, "*"),
                arguments(Calculator.Operand.MODULO, "%"),
                arguments(null, null),
                arguments(null, "")


        );

    }

    public static Stream<Arguments> CalcOperations() {
        return Stream.of(
                arguments(5, "+", 5, 10.0),
                arguments(10, "-", 5, 5.0),
                arguments(10, "/", 2, 5.0),
                arguments(2, "x", 5, 10.0),
                arguments(10, "%", 2, 0.0)
        );
    }

    @BeforeEach
    void setup() {
        mockedAdapter = mock(UserAdapter.class);
        calculator = new Calculator(mockedAdapter);
    }

    @Test
    @DisplayName("Affciher une aide")
    void displayHelp_whenCall_ShouldDisplaySomething() {
        calculator.displayHelp();
        verify(mockedAdapter, atLeastOnce()).display(anyString());
    }
    @Test
    @DisplayName("Affciher l'operation")
    void displayOperation_whenCall_ShouldDisplaySomething() {
        calculator.displayOperation(0,0, Calculator.Operand.ADDITION);
        verify(mockedAdapter, atLeastOnce()).display(anyString());
    }

    @ParameterizedTest(name = "Valeur entrée -> {0}")
    @ValueSource(strings = {"-5", "5", "0"})
    @NullAndEmptySource
    @DisplayName("Ask a number should always return a number ")
    void askANumber_whenCalledWithInteger_ShouldReturnThisValue(
            String valueIn
    ) {
        //ARRANGE
        final int defaultValue = 5;
        if (valueIn != null && !valueIn.isEmpty())
            when(mockedAdapter.askSomething()).thenReturn(valueIn);
        else {
            AtomicBoolean firstCall = new AtomicBoolean(true);
            when(mockedAdapter.askSomething()).thenAnswer(invocationOnMock -> {
                if (firstCall.getAndSet(false)) {
                    return valueIn;
                } else {
                    return defaultValue;
                }
            });
        }
        //ACT
        int userValue = calculator.askANumber();
        //ASSERT
        verify(mockedAdapter, atLeastOnce()).display(anyString());
        if (valueIn != null && !valueIn.isEmpty()) {
            assertThat(userValue)
                    .isEqualTo(Integer.parseInt(valueIn));
            verify(mockedAdapter, times(1)).display(anyString());
            verify(mockedAdapter, times(1)).askSomething();
        } else {
            assertThat(userValue)
                    .isEqualTo(defaultValue);
            verify(mockedAdapter, times(1)).display(anyString());
            verify(mockedAdapter, atLeast(2)).askSomething();
        }


    }

    @ParameterizedTest(name = "Valeur entrée -> one of {1} expected => {0}")
    @MethodSource("OperandWithEquivalent")
    @DisplayName("Ask a correct operand should always return a number ")
    void askAskOperand_whenCalledWithInteger_ShouldReturnThisValue(
            Calculator.Operand operand,
            String value
    ) {
        //ARRANGE
        when(mockedAdapter.askSomething()).thenReturn(value);
        //ACT
        var operandReturned = calculator.askOperand();
        //ASSERT
        verify(mockedAdapter, atLeastOnce()).display(anyString());
        if (value != null && !value.isEmpty()) {
            assertThat(operandReturned).isEqualTo(operand);
        } else
            verify(mockedAdapter, atLeast(2)).askSomething();
    }

    @ParameterizedTest(name = " {0} {1} {2} = {3}")
    @MethodSource("CalcOperations")
    @DisplayName("Effectué un calcul")
    void calc_WhenCalledWIthDifferentOperandAndValue_ShouldReturnTheExpectedResult(
            int firstNumber,
            String operator,
            int secondNumber,
            double total
    ) {
        //ARRANGE
        var operand = switch (operator) {
            case "+" -> Calculator.Operand.ADDITION;
            case "-" -> Calculator.Operand.SUBSTRACTION;
            case "x" -> Calculator.Operand.MULTIPLICATION;
            case "/" -> Calculator.Operand.DIVISION;
            case "%" -> Calculator.Operand.MODULO;
        };
        //ACT
        var calc = calculator.calc(firstNumber, secondNumber, operand);
        //ASSERT
        assertThat(calc).isEqualTo(total);
    }


}

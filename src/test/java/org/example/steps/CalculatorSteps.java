package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CalculatorSteps {
    private final List<Integer> numbers = new ArrayList<>();
    private int result;

    @Given("the calculator is cleared")
    public void the_calculator_is_cleared() {
        numbers.clear();
        result = 0;
    }

    @Given("I have entered {int} into the calculator")
    public void i_have_entered_into_the_calculator(int number) {
        numbers.add(number);
    }

    @When("I press add")
    public void i_press_add() {
        result = numbers.stream().mapToInt(Integer::intValue).sum();
    }

    @When("I press multiply")
    public void i_press_multiply() {
        result = numbers.stream().reduce(1, (left, right) -> left * right);
    }

    @Given("the following numbers:")
    public void the_following_numbers(DataTable table) {
        numbers.clear();
        numbers.addAll(table.asList(Integer.class));
    }

    @When("I total them")
    public void i_total_them() {
        result = numbers.stream().mapToInt(Integer::intValue).sum();
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        Assert.assertEquals(expected, result);
    }
}

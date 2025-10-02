Feature: Basic calculator operations
  As a curious tester
  I want to experiment with Cucumber step definitions
  So that I can learn how to describe executable specifications

  Scenario: Add two numbers
    Given the calculator is cleared
    And I have entered 5 into the calculator
    And I have entered 7 into the calculator
    When I press add
    Then the result should be 12

  Scenario Outline: Multiply two numbers
    Given the calculator is cleared
    And I have entered <first> into the calculator
    And I have entered <second> into the calculator
    When I press multiply
    Then the result should be <product>

    Examples:
      | first | second | product |
      | 2     | 3      | 6       |
      | 7     | 8      | 56      |

  Scenario: Add a list of numbers
    Given the following numbers:
      | 4  |
      | 8  |
      | 15 |
      | 16 |
    When I total them
    Then the result should be 43

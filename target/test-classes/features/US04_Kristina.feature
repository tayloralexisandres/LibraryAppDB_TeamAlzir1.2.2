@US04
Feature: As a data consumer, I want UI and DB book information are match.


  @ui @db
  Scenario: verify book information with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page
    When the users searches for "Cydeo School" book
    And the user clicks edit book button
    Then book information must match the Database
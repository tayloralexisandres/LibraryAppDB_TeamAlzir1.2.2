@us03
Feature: As a data consumer, I want UI and DB book categories are match.
@B28G4-174 @ui@db
  Scenario: verify book categories with DB
    Given the "librarian" on the home page
    When the user Navigates to "Books" page
    And the user clicks book categories
    Then verify book categories must match book_categories table from db
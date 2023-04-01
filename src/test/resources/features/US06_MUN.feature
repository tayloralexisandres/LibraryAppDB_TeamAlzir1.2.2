@us06
Feature: Books module
  As a librarian, I should be able to add new book into library

  @ui @db
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page
    When the librarian click to add book
    And the librarian enter book name "<BookName>"
    When the librarian enter ISBN "<ISBN>"
    And the librarian enter year "<Year>"
    When the librarian enter author "<Author>"
    And the librarian choose the book category "<BookCategory>"
    And the librarian click to save changes
    Then verify "The book has been created" message is displayed
    And verify "<BookName>" information must match with DB
    Examples:
      | BookName              | ISBN     | Year | Author       | BookCategory         |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey  | Short Story          |
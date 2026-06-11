Feature: Todo Feature
  Scenario: Todo Task Addition
    Given User is at the todo page
    When User adds new todo page
    Then Todo should be added correctly
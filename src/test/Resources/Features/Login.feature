Feature: Login Scenario

  Background: User is on Login Page

    @valid
    Scenario: User Should Able To Login Successfully Login With Valid Credentials

      When User Enters Valid Username And Password
      And User Clicks On Login Button
      Then User Login Successfully

    @invalid
    Scenario Outline: User Should Be Not Able To Login Successfully  With Invalid Credentials

      When User Enters Invalid "<userName>" And "<password>"
      And User Clicks On Login Button
      Then User see the "<errorMessage>"

      Examples:
        | userName | password | errorMessage             |
        | Admin    | Test123  | Invalid credentials      |
        | Test     | Admin123 | Invalid credentials      |
        | Admin    |          | Password cannot be empty |
        |          | Admin123 | Username cannot be empty |
        | Test     |          | Password cannot be empty |
        |          | Test123  | Username cannot be empty |
        |          |          | Username cannot be empty |
        | Test     | Test123  | Invalid credentials      |


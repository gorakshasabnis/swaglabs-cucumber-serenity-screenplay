Feature: Login

  Rule: Only a valid customer should be able to access the product catalog

      Scenario: Standard customer logs in with valid credentials
        Given Goraksha is on the Swag Labs login page
        When he provides valid credentials
        Then Goraksha should be welcomed with a Swag Labs product catalog

      Scenario: Customer logs in with locked credentials
        Given Tony is on the Swag Labs login page
        When he provides locked credentials
        Then Tony should be presented with a message as "Sorry, this user has been locked out."

      Scenario Outline: Customer attempts to login with invalid credentials
        Given Peter is on the Swag Labs login page
        When he provides invalid credentials
          | <Username> | <Password> |
        Then Peter should be presented with a message as "<Error Message>"
        Examples:
          | Username      |  Password           | Error Message                                               |
          | standard_user | incorrect_password  | Username and password do not match any user in this service |
          | wrong_user    | secret_sauce        | Username and password do not match any user in this service |
          |               | secret_sauce        | Username is required                                        |
          | standard_user |                     | Password is required                                        |
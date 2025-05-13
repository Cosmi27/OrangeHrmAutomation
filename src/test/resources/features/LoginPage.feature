Feature: Login page authentication
  Scenario Outline: Login page
    Given user is into login page
    When user insert valid <username> and valid <password>
    Then user can access the site
    Examples:
      | username | password |
      | Admin    | admin123 |


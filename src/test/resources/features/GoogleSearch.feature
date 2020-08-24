Feature: Google Homepage Search

 
 Scenario: User can search “Patrick Rothfuss - The Books” with “Google Search”
    Given The user goes to page "https://www.google.com"
    When The user types "The name of the wind" into the search field
    And The user clicks on the google search button
    And The user clicks on "The Books - Patrick Rothfuss" link
    Then The user should see "Patrick Rothfuss - The Books" page
    
 
 Scenario: User can not search “Patrick Rothfuss - The Books” with “Google Search”
    Given The user goes to page "https://www.google.com"
    When The user types "The name of the wind" into the search field
    And The user clicks on the google search button
    And The user clicks on the first result link
    Then The user should not see "Patrick Rothfuss - The Books" page
    
   
 Scenario: User can search “Patrick Rothfuss - The Books” by using the suggestions
    Given The user goes to page "https://www.google.com"
    When The user types "The name of the w" into the search field
    And The user clicks on the first suggestion in the list
    And The user clicks on "The Books - Patrick Rothfuss" link
    Then The user should see "Patrick Rothfuss - The Books" page
    
 
 Scenario: User can not search “Patrick Rothfuss - The Books” by using the suggestions
    Given The user goes to page "https://www.google.com"
    When The user types "The name of the w" into the search field
    And The user clicks on the first suggestion in the list
    And The user clicks on the first result link
    Then The user should not see "Patrick Rothfuss - The Books" page
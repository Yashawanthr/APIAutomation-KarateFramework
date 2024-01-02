Feature: To test the "POST" end point of the application
  Use to Create a users/Data in the application

  Background: Setup the Base path
    Given url 'https://reqres.in'
    And print "Setup the Base path"

  Scenario: To Create a users in the application
    And path '/api/users'
    * def body = read("JsonRequest.json")
    And request body
    When method post # Send the post request
    Then status 201 # the status code response should be 201
    And print response
    And match response.name == "TestAPIUser02"
    And match response.job == "Trainee"

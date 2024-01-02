Feature: To test the "PUT" end point of the application
  To test different get end point with different data formate supported by the application

  Background: Setup the Base path
    Given url 'https://reqres.in'
    And print "Setup the Base path"

  Scenario: To update the Userdata in the application
    And path '/api/users/2'
    When method get # Send the get request
    Then status 200 # the status code response should be 200
    And print response
    * def actualResponse = read("JsonResponse.json")
    And match response == actualResponse
    And print "File ==> ", actualResponse
    And match response.data.email == "#present"
    * def emailId = response.data.email
    And print emailId
    And match response.data.id == "#present"
    * def userId = response.data.id
    And print userId
    And path '/api/users/' + userId
    When method put # Send the Put request
    Then status 200 # the status code response should be 200
    And print response

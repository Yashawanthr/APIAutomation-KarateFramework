Feature: To test the "GET" end point of the application
  To test different get end point with different data formate supported by the application

  Background: Setup the Base path
    Given url 'https://reqres.in'
    And print "Setup the Base path"

  Scenario: To get all the data from application in JSON format
    And path '/api/users?page=1'
    When method get # Send the get request
    Then status 200 # the status code response should be 200
    And print response
    And match response contains deep {"page":1}
    And match response contains deep {"data":[{"name":"fuchsia rose"}]}
    And match response.data[3].name == 'aqua sky'
    And match response.data[3].name == '#present'
    And match response.data[3].name == '#notnull'
    * def actualResponse = read("JsonResponse.json")
    And match response == actualResponse
    And print "File ==> ", actualResponse

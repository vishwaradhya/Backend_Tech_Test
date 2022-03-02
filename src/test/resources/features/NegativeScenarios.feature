@negative @BackendTests
Feature: This is to test negative sceanrios 

 
    Scenario Outline: Verify behaviour when user sends wrong URL
    	Given user get list user with user id "<id>" which is not exists
    	Then user verifies the status code for list user as 404

			Examples:
			|id|
			|101|
    
    
 Scenario: Verify behaviour for wrong http method
 		Given social network server is up and running
    And user calls for PUT method instead of POST for posting comments  with following data
    	|userId	|id		|title								|body								|
 		|		1		|101	|		make post title		|		make post body	|
    Then user verifies the status code for make post as 404
   
    
    
      


  
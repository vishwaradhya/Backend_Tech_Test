@negative
Feature: This is to test negative sceanrios 

  @test
    Scenario Outline: Verify behaviour when user sends wrong URL
    	Given user get list user with user id "<id>" which is not exists
    	Then user verifies the status code for list user as 404

			Examples:
			|id|
			|101|
    
    
 Scenario: Verify behaviour for wrong http method
    Given user calls for PUT method instead of POST for posting comments 
    And user verifies the status code for make comment as 404
   
    
    
      


  
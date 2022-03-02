@jp
Feature:  Backend Testing Make posts
  
  Background:
  Given social network server is up and running

  @makePosts
  Scenario: Verify user is able to Make Posts request to server and validate the response 
 		Given user makes posts with following details to server
 		|userId	|id		|title								|body								|
 		|		1		|101	|		make post title		|		make post body	|
 		And user verifies the status code as 201
 		Then user verifes the following details from the response for sucessfull post in the server
 		|userId	|id		|title								|body								|
 		|		1		|101	|		make post title		|		make post body	|
 
 
 
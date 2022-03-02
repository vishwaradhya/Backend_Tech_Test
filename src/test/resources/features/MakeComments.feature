@jp
Feature:  Backend Testing for Make Comments feature
  
  Background:
  Given social network server is up and running


 
   @comment
  Scenario: Verify user is able to Comment on posts request to server and validate the response 
 		Given user makes comment posts with following details to server
 		|postId	|id		|name									|email	|body								|
 		|		10		|101	|		make comment name	|a@a.com|		make comment body	|
 		And user verifies the status code for make post as 201
 		Then user verifes the following details from the comment posts for sucessfull post in the server
 	 	|postId	|id		|name									|email	|body								|
 		|		10		|101	|		make comment name	|a@a.com|	make comment body	|
 		
 		
@jp
Feature:  Backend Testing Make posts
  
  Background:
  Given social network server is up and running

 	  @listUsers
  Scenario Outline: Verify user is able to List of users request to server and validate the response 
 		Given user list users for user id "<id>"
 		And user verifies the status code as 200
 		Then user verifes the following details for user id "<id>"
 		|name					|username	|email							|address-street	|address-suite|address-city	|address-zipcode|address-geo-lat|address-geo-lng|phone								|website			|company-name		|company-catchPhrase										|company-bs|
 		|Leanne Graham|Bret			|Sincere@april.biz	|Kulas Light		|Apt. 556			|Gwenborough	|92998-3874			|-37.3159				|81.1496				|1-770-736-8031 x56442|hildegard.org|Romaguera-Crona|Multi-layered client-server neural-net	|harness real-time e-markets|
 		
 	
 	Examples: 
 	|id|
 	|1|	
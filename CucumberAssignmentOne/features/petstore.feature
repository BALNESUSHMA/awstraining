#Author: Sushma Balne(20365236)
#Sample Feature Definition Template

Feature: Test Registration and login Page petstore.octoperf.com
  
@registration
  Scenario: Create new user for petstore.octoperf.com
  	Given User Launch chrome browser and open url
  	When User on homepage and follows sign In
  	When User click on RegisterNow
  	And Fill user details in registration form
  	|userid|xyz|
  	|password|abc@234|
  	|fisrtname|sss|
  	|lastname|nsjvn|
		|email|ghdjfk@gmail.com|
		|phone|893088|
		|address|afgdg,gsfh,|
		|city|xyz|
		|state|abcd|
		|zip|7868996|
		|country|Jermany|
		And User click on Save Account Information
		Then Reloaded to login url 
		And Close browser
		
#		@login
#		Scenario: Login into petstore.octoperf.com
#		Given User Launch chrome browser and open url
  #	When User on homepage and follows sign In
#		And Login with valid username and password
#		|userid|xyz|
#		|password|abc@123|
#		When User click on login button
#		Then Check for welcome message to user
#		And Close browser
#		
		
		
		
 

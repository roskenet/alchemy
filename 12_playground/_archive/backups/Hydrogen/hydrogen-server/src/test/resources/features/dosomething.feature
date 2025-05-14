Feature: Do something
	This feature file is to ensure, that some magic happens.

Scenario: Check if something happens
Given The hydrogen-server is running
When I perform GET on the endpoint
Then I get a 200

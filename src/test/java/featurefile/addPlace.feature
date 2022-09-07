@tag
Feature: Validating Place API's

@AddplaceAPI @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
Given Add place payload "<name>" "<Accuracy>" "<Phonenumber>"
When User calls "AddplaceAPI" with "POST" http request
Then "statuscode" in response body is "200"
Then Verify "<name>" using "GetplaceAPI"

Examples:
		|name  |Accuracy |Phonenumber|
		|lokesh|60			 |3847834823 |
#		|hello |50			 |cvfgfgfvdf |

@DeletePlaceAPI @Regression
Scenario: Verification of API deletion
Given API deletion
When User calls "DeleteplaceAPI" with "POST" http request
Then "statuscode" in response body is "200"
Then "status" in response body is "OK"







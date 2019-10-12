Feature: I want to add seller personal data

	Scenario: Add seller personal data
        Given I see vehicle summary screen
         When I move to seller data section
          And I tap edit button
          And I see "Edit screen"
          And I enter valid name
          And I enter valid lastname
          And I enter valid address
          And I enter valid phone number
          And I enter valid email adress
          And I Press save button
          Then I see summary screen with entered seller personal data
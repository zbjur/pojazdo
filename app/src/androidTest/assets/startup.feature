Feature: Login screen to authenticate users

	Scenario: Main screen shown
        Given I see an empty search form
         When I introduce an valid vin
          And I introduce an valid registration number
          And I introduce an valid first registration date
          And I press the search
          Then Vehicle summary information is displayed


Feature: Show vehicle information

	Scenario: Show vehicle vehicle details
        Given I see an empty search form
         When I introduce an valid vin
          And I introduce an valid registration number
          And I introduce an valid first registration date
          And I press the search
          Then I see vehicle rating



    var demoApp = angular.module('inputDropdownDemo', ['inputDropdown']);

    demoApp.controller('InputDropdownController', [
      '$scope',
      '$q',
      function($scope, $q) {
        var self = this;
        
        self.stringMessage = '';
        self.objectMessage = '';
        
        self.countryString = null; // Holds the selected in demoFormStrings, set with attribute 'selected-item'
        self.countryObject = null; // Holds the selected in demoFormObjects, set with attribute 'selected-item'

        // Pass strings to the dropdown for simple usage
        self.defaultDropdownStrings = [
          'China',
          'Sweden',
          'United Kingdom',
          'United States'
        ];

        // Use objects in the dropdown list if more data than just a string is needed.
        // Every object needs to have a property 'readableName', this is what will be displayed in the dropdown.
        self.defaultDropdownObjects = [{
          readableName: 'China',
          countryCode: 'CH',
          id: 0,
          toString: function() {
            return '{readableName: ' + this.readableName + ', countryCode: ' + this.countryCode + ', id: ' + this.id + '}';
          }
        }, {
          readableName: 'Sweden',
          countryCode: 'SE',
          id: 1,
          toString: function() {
            return '{readableName: ' + this.readableName + ', countryCode: ' + this.countryCode + ', id: ' + this.id + '}';
          }
        }, {
          readableName: 'United Kingdom',
          countryCode: 'UK',
          id: 2,
          toString: function() {
            return '{readableName: ' + this.readableName + ', countryCode: ' + this.countryCode + ', id: ' + this.id + '}';
          }
        }, {
          readableName: 'United States',
          countryCode: 'US',
          id: 3,
          toString: function() {
            return '{readableName: ' + this.readableName + ', countryCode: ' + this.countryCode + ', id: ' + this.id + '}';
          }
        }];


        // Filter method is passed with attribute 'filter-list-method="method(userInput)"'.
        // Called on the onchange event from the input field. Should return a promise resolving with an array of items to show in the dropdown.
        // If no filter method is passed to the the directive, the default dropdown will show constantly.
        self.filterStringList = function(userInput) {
          var filter = $q.defer();
          var normalisedInput = userInput.toLowerCase();

          var filteredArray = self.defaultDropdownStrings.filter(function(country) {
            return country.toLowerCase().indexOf(normalisedInput) === 0;
          });

          filter.resolve(filteredArray);
          return filter.promise;
        };

        self.filterObjectList = function(userInput) {
          var filter = $q.defer();
          var normalisedInput = userInput.toLowerCase();

          var filteredArray = self.defaultDropdownObjects.filter(function(country) {
            var matchCountryName = country.readableName.toLowerCase().indexOf(normalisedInput) === 0;
            var matchCountryCode = country.countryCode.toLowerCase().indexOf(normalisedInput) === 0;
            return matchCountryName || matchCountryCode;
          });

          filter.resolve(filteredArray);
          return filter.promise;
        };


        // Called when user selected an item from dropdown. Passed with attribute 'item-selected-method="method(item)"'.
        self.itemStringSelected = function(item) {
          console.log('Handle item string selected in controller:', item);
          self.stringMessage = 'String item selected: ' + item;
        };

        self.itemObjectSelected = function(item) {
          console.log('Handle item object selected in controller:', item);
          self.objectMessage = 'Object item selected: ' + item;
        };


        self.submitFormStrings = function() {
          if ($scope.demoFormStrings.$valid) {
            console.log('Submit form STRINGS with country:', self.countryString);
            self.stringMessage = 'Submit form STRINGS with country: ' + self.countryString;
          }
        };

        self.submitFormObjects = function() {
          if ($scope.demoFormObjects.$valid) {
            console.log('Submit form OBJECTS with country:', self.countryObject);
            self.objectMessage = 'Submit form OBJECT with country: ' + self.countryObject;
          }
        };

      }
    ]);
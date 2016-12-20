angular.module('inputDropdownDemo', ['inputDropdown', 'adherent.services'])
	.controller('InputDropdownController', ['$scope','$q', 'mediaDropDown',
      function($scope, $q, mediaDropDown) {
        var self = this;
        
        self.stringMessage = '';
        self.objectMessage = '';
        
        self.titleObject = null; // Holds the selected in demoFormObjects, set with attribute 'selected-item'

        // Pass strings to the dropdown for simple usage
//        self.defaultDropdownStrings = [
//          'China',
//          'Sweden',
//          'United Kingdom',
//          'United States'
//        ];

        // Use objects in the dropdown list if more data than just a string is needed.
        // Every object needs to have a property 'readableName', this is what will be displayed in the dropdown.
		  this.test = [];
		  this.titre = "";
		  var url = 'http://192.168.1.93:8090/resource/media.recherche';
		  mediaDropDown.getMediaList(url, this, this.test).then (function() {
			  console.log("yolo", self.test)   
		  });
		  

        // Filter method is passed with attribute 'filter-list-method="method(userInput)"'.
        // Called on the onchange event from the input field. Should return a promise resolving with an array of items to show in the dropdown.
        // If no filter method is passed to the the directive, the default dropdown will show constantly.

		  self.filterObjectList = function(userInput) {
			  var filter = $q.defer();
	          var normalisedInput = userInput.toLowerCase();
	          
	          
	  		  this.test = [];
	  		  this.titre = userInput;
			  var url = 'http://192.168.1.93:8090/resource/media.recherche';
			  mediaDropDown.getMediaList(url, this, this.test).then (function() {
			          var filteredArray = self.test.filter(function(media) {
				          var matchMediaName = media.readableName.toLowerCase().indexOf(normalisedInput) !== -1;
				            return matchMediaName;
				      });
			          filter.resolve(filteredArray);
			  });
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
          self.titre = item.titre;
        };

      }
    ]);
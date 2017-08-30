/*					INFORMATION : to add google maps widget
 * 
 * TO USE GOOGLE MAPS INCLUDE <script src = "https://maps.googleapis.com/maps/api/js"></script>
 * and this script "google_maps.js"
 * Make <div  id = "map" style = "width:300px; height:300px;"></div>
 * Make <input id="submit" type="button" value="Find address"> put css if you want
 * Make <input type="text" id="pos" value="none" ></input> put css if you want 
 * run script initMap() at the end of the body <script type="text/javascript">initMap();</script>
 * OR you need to call initMap() in another way!! */

var map;
var currentMarker;

var geocoder = new google.maps.Geocoder;
	var infowindow = new google.maps.InfoWindow;

function initMap() {
	var haightAshbury = {lat: 37.9833333, lng: 23.7333333};

    map = new google.maps.Map(document.getElementById('map'), {
          zoom: 12,
          center: haightAshbury,
          mapTypeId: 'terrain'
        });

        // This event listener will call addMarker() when the map is clicked.
    map.addListener('click', function(event) {
        currentMarker.setMap(null);	
        addMarker(event.latLng);
     	});
        // Adds a marker at the center of the map.
        addMarker(haightAshbury);
	
    document.getElementById('submit').addEventListener('click', function() {
    	geocodeAddress(geocoder, map);
        });
      }

      // Adds a marker to the map and push to the array.
      function addMarker(location) {
        var marker = new google.maps.Marker({
          position: location,
          map: map
        });
        currentMarker = marker;
	geocodeLatLng(geocoder	, infowindow);
      }

function geocodeLatLng(geocoder, infowindow) {
	
	var input = currentMarker.position.toString();
	input = input.split('(').join('') //remove character '(' from String input
	input = input.split(')').join('')//for some reason marker's possition has (lat,lon)
    var latlngStr = input.toString().split(',', 2);
	//alert(latlngStr[0]+","+latlngStr[1]);
    var latlng = {lat: parseFloat(latlngStr[0]), lng: parseFloat(latlngStr[1])};
    geocoder.geocode({'location': latlng}, function(results, status) {
    	if (status === 'OK') {
            if (results[0]) {
              map.setZoom(15);
              
              infowindow.setContent(results[0].formatted_address);
		document.getElementById('pos').value = results[0].formatted_address
              infowindow.open(map, currentMarker);
            } else {
              window.alert('No results found');
            }
          } else {
            window.alert('Geocoder failed due to: ' + status);
          }
        });
      }

function geocodeAddress(geocoder, resultsMap) {
        var address = document.getElementById('pos').value;
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            	map.setZoom(15);
        currentMarker.setMap(null);	
		addMarker(results[0].geometry.location);
		document.getElementById('pos').value = results[0].geometry.location;
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }

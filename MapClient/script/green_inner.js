function initMap()
{
	var map = new google.maps.Map(document.getElementById('map'),
  	{
    center: {lat: -37.80869, lng: 144.99459},
    //center: {lat:42, lng:260},
    zoom: 12
    }
  	);

  var layer = new google.maps.FusionTablesLayer({
  		query:{
  			select:'geometry',
  			from:'1LYYTIi9-aDZEVQx4D_isBdQupn7Nr9VULjtolrB2'
  		},
  		styles:
  		[
  			{
  				polygonOptions:{
  				fillColor: '#79FF79',
        	fillOpacity: 0.3
  				}
  			}
  			
  		]
  	});

  	layer.setMap(map);

    setInterval(function(){ 
       var c = getRawCollectionAsArray();
       var coordinates = getTweetsLocation(c);
    for (var co in coordinates)
    {
      var lat = coordinates[co].latitude;
      var lng = coordinates[co].longitude;
      var location = {"lat":lat, "lng":lng};
      var marker = new google.maps.Marker({
          position:location,
          map: map
          //icon: 'pictures/tweet.png'
      });

    }
    //alert("hi");

    }, 4000);
    
   
}

function getTweetsLocation(c)
{
  
  //var collection = getRawCollectionAsArray();
  var topic = filterTopic(c,"Topic_Fitness");
  var coordinate = compactResultArray(topic);

  return coordinate;
}
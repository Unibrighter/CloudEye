var map;
function initMap()
{
	map = new google.maps.Map(document.getElementById('map'),
  	{
    center: {lat: -37.80869, lng: 144.99459},
    //center: {lat:42, lng:260},
    zoom: 9
    }
  	);

  	var layer = new google.maps.FusionTablesLayer({
  		query:{
  			select:'geometry',
  			from:'1-xKcxM3xvWVVk451rjoXraRkPdr7xI17vGBHjzqB'
  		},
  		styles:
  		[
  			{
  				polygonOptions:{
  				fillColor: '#FFD2D2',
        		fillOpacity: 0.3
  				}
  			}
  			
  		],
      suppressInfoWindows: true
  	});
    layer.setMap(map);

    var coordinates_pos = getTweetsLocation(1);
    var coordinates_neg = getTweetsLocation(-1);
    var coordinates_obj = getTweetsLocation(0);
    
    var img_pos = "pictures/tweet_pos.png";
    var img_neg = "pictures/tweet_neg.png";
    var img_obj = "pictures/tweet.png";
    
    setMarker(coordinates_pos, img_pos);
    setMarker(coordinates_neg, img_neg);
    //setMarker(coordinates_obj, img_obj);
    
}

function getTweetsLocation(senti)
{
   var topic = filterTopic(collection,"Topic_Politic");
   var sentiment = filterSentiment(topic,senti);
   var coordinate = compactResultArray(sentiment);
   return coordinate;
  
}

function setMarker(coordinates,img)
{
  for (var co in coordinates)
    {
      var lat = coordinates[co].latitude;
      var lng = coordinates[co].longitude;
      var location = {"lat":lat, "lng":lng};
      var marker = new google.maps.Marker({
          position:location,
          map: map,
          icon: img
      });

    }
}

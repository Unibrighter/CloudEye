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

    var coordinates_asian = getTweetsLocation("Topic_Food_Asian");
    var coordinates_chinese = getTweetsLocation("Topic_Food_CHINESE");
    var coordinates_italy = getTweetsLocation("Topic_Food_ITALY");
    var coordinates_oz = getTweetsLocation("Topic_Food_OZ");
    var coordinates_french = getTweetsLocation("Topic_Food_FRENCH");

    var img_asian ="pictures/tweet_o.png";
    var img_chinese ="pictures/tweet_p.png";
    var img_italy ="pictures/tweet_y.png";
    var img_oz ="pictures/tweet_bg.png";
    var img_french ="pictures/tweet.png";

    setMarker(coordinates_asian,img_asian);
    setMarker(coordinates_chinese,img_chinese);
    setMarker(coordinates_italy,img_italy);
    setMarker(coordinates_oz,img_oz);
    setMarker(coordinates_french,img_french);

}

function getTweetsLocation(topic)
{
   var topic = filterTopic(collection,topic);
   //var sentiment = filterSentiment(topic,senti);
   var coordinate = compactResultArray(topic);
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
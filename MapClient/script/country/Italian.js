var map;
function initMap()
{
	map = new google.maps.Map(document.getElementById('map'),
  	{
    center: {lat: -37.80869, lng: 144.99459},
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
  				fillColor: '#E6CAFF',
        		fillOpacity: 0
  				}
  			},
  			{
  				where: 'Italian >50',
    			polygonOptions: 
    			{
        			fillColor:'#CA8EFF',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'Italian >100',
    			polygonOptions: 
    			{
        			fillColor:'#9F35FF',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'Italian >130',
    			polygonOptions: 
    			{
        			fillColor:'#5B00AE',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'Italian >170',
    			polygonOptions: 
    			{
        			fillColor:'#28004D',
        			fillOpacity: 0.7
        		}
  			}
  			
  		],
      suppressInfoWindows: true
  	});
    layer.setMap(map);

    var coordinates = getTweetsLocation();
    setMarker(coordinates,"pictures/tweet.png");
}

function getTweetsLocation(senti)
{
   var topic = filterTopic(collection,"Topic_Politic");
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
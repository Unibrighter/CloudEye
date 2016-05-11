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
        		fillOpacity: 0
  				}
  			},
  			{
  				where: 'Indian >800',
    			polygonOptions: 
    			{
        			fillColor:'#FF5151',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'Indian >1000',
    			polygonOptions: 
    			{
        			fillColor:'#EA0000',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'Indian >2000',
    			polygonOptions: 
    			{
        			fillColor:'#750000',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'Indian >4000',
    			polygonOptions: 
    			{
        			fillColor:'#2F0000',
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
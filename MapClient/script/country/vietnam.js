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
  				  fillColor: '#DEFFAC',
        		fillOpacity: 0
  				}
  			},
  			{
  				where: 'vietnam >300',
    			polygonOptions: 
    			{
        			fillColor:'#C2FF68',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'vietnam >1000',
    			polygonOptions: 
    			{
        			fillColor:'#9AFF02',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'vietnam >3000',
    			polygonOptions: 
    			{
        			fillColor:'#73BF00',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'vietnam >7000',
    			polygonOptions: 
    			{
        			fillColor:'#467500',
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
var map;

var citymap = {
  c1: {
    center: {lat: -38.105385902838094, lng: 145.41229248046875},
    radius: 41842.84
  },
  c2: {
    center: {lat: -37.49338360812416, lng: 145.2447509765625},
    radius: 35405.48
  },
  c3: {
    center: {lat: -37.652295930239426, lng: 144.4427490234375},
    radius: 41201.90
  },
  c4: {
    center: {lat: -37.80869897600677, lng: 144.964599609375},
    radius: 9656.04
  }
};

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
  				fillColor: '#FFFF6F',
        	fillOpacity: 0
  				}
  			},
  			{
  				where: 'income >1000',
    			polygonOptions: 
    			{
        			fillColor:'#FFFF37',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'income >2000',
    			polygonOptions: 
    			{
        			fillColor:'#EAC100',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'income >3000',
    			polygonOptions: 
    			{
        			fillColor:'#FFAF60',
        			fillOpacity: 0.7
        		}
  			},
  			{
  				where: 'income >10000',
    			polygonOptions: 
    			{
        			fillColor:'#FF8040',
        			fillOpacity: 0.7
        		}
  			}
  			
  		],
      suppressInfoWindows: true
     
      
  	});

  	layer.setMap(map);

    var coordinates = getTweetsLocation(0);
    var img = "pictures/tweet.png";
    setMarker(coordinates, img);

    //drawCircle();
    

}

function getTweetsLocation(senti)
{
   var topic = filterTopic(collection,"Topic_Crime");
  // var sentiment = filterSentiment(topic,senti);
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

function drawCircle()
{
  var circles = new Array();
  for (var city in citymap)
  {
    var cityCircle = new google.maps.Circle({
      strokeColor: '#0080FF',
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: '#C4E1FF',
      fillOpacity: 0.35,
      map: map,
      center:citymap[city].center,
      radius:citymap[city].radius
    });
    circles.push(cityCircle);

    var info = new google.maps.InfoWindow({
      content:citymap[city].center,

    });


    // cityCircle.addListener('mouseover',function(){
    //   alert(city);
    //   info.open(map, cityCircle);
    // });

    // cityCircle.addListener('mouseout',function(){
    //   info.close();
    // });

  }
  // for (var i =0; i< circles.length; i++)
  // {
  //   var info = new google.maps.InfoWindow({
  //     content:"aaaaaaa",
  //     position: citymap[city].center
  //   });

  //   circles[i].addListener('mouseover',function(){
  //     info.open(map, circles[i]);
  //   });
  // }
}
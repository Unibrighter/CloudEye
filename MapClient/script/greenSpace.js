function initMap()
{
	var map = new google.maps.Map(document.getElementById('map'),
  	{
    center: {lat: -37.80869, lng: 144.99459},
    //center: {lat:42, lng:260},
    zoom: 11
    }
  	);

  var layer = new google.maps.FusionTablesLayer({
  		query:{
  			select:'geometry',
  			from:'1BSarEBQhpK-oOjBQsPumDFx1yebrn77WxS8WDrDN'
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

  getTweets;
}

function getTweets()
{
  var collection = getRawCollectionAsArray();
}
function initMap()
{
	var map = new google.maps.Map(document.getElementById('map'),
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
}
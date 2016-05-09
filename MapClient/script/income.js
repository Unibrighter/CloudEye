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
  			
  		]
  	});

  	layer.setMap(map);

}
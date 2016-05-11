function initMap()
{
	var map = new google.maps.Map(document.getElementById('map'),
  	{
    center: {lat: -37.80869, lng: 144.99459},
    //center: {lat:42, lng:260},
    zoom: 11
    }
  	);


// var result_json= XXXX_API("115.89.146.111:5984/XXXXX");
// 根据result_json 解析并显示
	
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
}


function initMap() 
{
  var map = new google.maps.Map(document.getElementById('map'),
  	{
    //center: {lat: -25, lng: 133},
    center: {lat:42, lng:260},
    zoom: 4
    }
  	);
  
  var layer = new google.maps.FusionTablesLayer({
    query: {
      select: 'geometry',
      from: '1PiUzn-8y1RX-4zmA4orxUP1wWXct-mmIBeYA96rS'
    },
    styles: 
    [
    {
      polygonOptions: {
        fillColor: '#79FF79',
        fillOpacity: 0.3
      }
    },
    {
    	where: 'Population > 300000',
    	polygonOptions: 
    	{
        fillColor:'#d3a4ff' ,
        }

    },
    {
    	where: 'Population > 1000000',
    	polygonOptions: 
    	{
        fillColor: '#02F78E',
        }

    },
    {
    	where: 'Population > 2000000',
    	polygonOptions: 
    	{
        fillColor: '#00CACA',
        }

    },
    {
    	where: 'Population > 3000000',
    	polygonOptions: 
    	{
        fillColor: '#ff7575',
        }

    },
    {
    	where: 'Population > 4000000',
    	polygonOptions: 
    	{
        fillColor: '#0066CC',
        }

    },
    {
    	where: 'Population > 4500000',
    	polygonOptions: 
    	{
        fillColor: '#9F35FF',
        }

    }

    ]
  });

  layer.setMap(map);
}
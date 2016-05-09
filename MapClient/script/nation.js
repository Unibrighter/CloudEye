var region ={
  		c1: {
    		nation: "Italian",
    		center: {lat: -37.79829, lng: 144.97498},
    		radius: 2500
  		},
  		c2: {
    		nation: "Italian",
    		center: {lat: -37.67529, lng: 145.01481},
    		radius: 3000
  		},
  		c3: {
    		nation: "Italian",
    		center: {lat: -37.70337, lng: 144.92953},
    		radius: 4000
  		},
  		c4: {
  			nation: "Vianan",
    		center: {lat: -37.79862, lng: 144.90042},
    		radius: 3300
  		},
  		c5: {
  			nation: "Vianan",
    		center: {lat: -37.57935, lng: 144.73115},
    		radius: 1000
  		},
  		c6: {
  			nation: "Vianan",
    		center: {lat: -37.94878, lng: 145.15301},
    		radius: 1000
  		},
  		c7: {
  			nation: "Chinese",
    		center: {lat: -37.75904, lng: 144.99910},
    		radius: 1000
  		},
  		c8: {
  			nation: "Chinese",
    		center: {lat: -37.78514, lng: 145.12547},
    		radius: 1000
  		},
  		c9: {
  			nation: "Chinese",
    		center: {lat: -37.88269, lng: 145.16537},
    		radius: 1000
  		},
  		c10: {
  			nation: "Chinese",
    		center: {lat: -37.78514, lng: 145.12410},
    		radius: 1000
  		},
  		c11: {
  			nation: "India",
    		center: {lat: -37.90086, lng: 144.65881},
    		radius: 1000
  		},
  		c12: {
  			nation: "India",
    		center: {lat: -37.75904, lng: 144.99804},
    		radius: 1000
  		}

  	}

function initMap()
{
	var map = new google.maps.Map(document.getElementById('map'),
  	{
    center: {lat: -37.80869, lng: 144.99459},
    //center: {lat:42, lng:260},
    zoom: 9
    }
  	);

	var fillColorList = ["#FF9D6F","#FFFF6F","#CCFF80","#ACD6FF"];
	var strokeColorList = ["#D94600","#E1E100","#82D900","#0080FF"];
  	
  	var fill;
  	var stroke;
  	for(var r in region)
    {
      //alert("hi");
      if(region[r].nation == "Italian")
      {
      	//red
      	fill = fillColorList[0];
      	stroke = strokeColorList[0];

      }else if(region[r].nation == "Chinese")
      {
      	fill = fillColorList[1];
      	stroke = strokeColorList[1];

      }else if(region[r].nation == "India")
      {
      	fill = fillColorList[2];
      	stroke = strokeColorList[2];

      }else if(region[r].nation == "Vianan")
      {
      	//blue
      	fill = fillColorList[3];
      	stroke = strokeColorList[3];

      }

      var cityCircle = new google.maps.Circle({

   			strokeColor: stroke,
    		strokeOpacity: 0.8,
    		strokeWeight: 2,
    		fillColor: fill,
   			fillOpacity: 0.35,
    		map: map,
    		center:region[r].center,
    		radius:region[r].radius

		});
      
    }

  	
}
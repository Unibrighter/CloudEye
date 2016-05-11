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
function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: -37.8554, lng: 145.1123},
    zoom: 9
  });

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
  }

  
}
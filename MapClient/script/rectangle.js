var map;
var rect = {
  r1 :{
    box: {north:-37.7218 ,south:-38.5181 ,east:145.7850, west:145.0435}
  },
  r2 :{
    box: {north:-37.2161 ,south:-37.7316 ,east:145.6175, west:144.8857}
  },
   r3 :{
    box: {north:-37.1504 ,south:-38.0200 ,east:144.8857, west:144.3238}
  },
   r4 :{
    box: {north:-37.7316  ,south:-37.8932 ,east:145.0435, west:144.8857}
  }
};

function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: -37.8554, lng: 145.1123},
    zoom: 9
  });

   for(var rec in rect)
  {
      var rectangle = new google.maps.Rectangle({
      strokeColor: '#2894FF',
      strokeOpacity: 0.8,
      strokeWeight: 2,
      fillColor: '#D2E9FF',
      fillOpacity: 0.35,
      map: map,
      bounds: rect[rec].box

    });
  }

  
}
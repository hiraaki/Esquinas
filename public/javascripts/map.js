/**
 * Created by mhi on 05/06/17.
 */
var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 14,
        center: {lat: -24.9554503, lng: -53.4552361},
        mapTypeControl: true,
        mapTypeId: google.maps.MapTypeId.SATELLITE
    });
    load(12321);
}

var markers=[];
/*
* Location->obj={lat:double,lng:double}
* */
function newMarker(location,rua1,rua2,id) {
    var marker = new google.maps.Marker({
        position: location,
        map: map
    });
    if(rua1!=null||rua2!=null){
        marker.set("title",rua1+"|"+rua2);
    }
    if(id!=null){
        marker.set("id",id);
    }
}

function load(env) {
    var json={"Bairro":env};
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        async: false,
        data: JSON.stringify(json),
        contentType: "application/json; charset=utf-8",
        url: '/upload',
        success: function (json) {
            /*
            * Json tipo Esquina{id,rua1,rua2,bairro,longitude,latitude}
            * */
            //var obj=JSON.parse(json);
            //obj=json;
            //console.log(obj);
            console.log(json);
            for(var i=0;i<json.length;i++) {
                obj=json[i];
                //console.log(obj);
                local = {
                    lat: obj.latitude,
                    lng: obj.longitude,
                }
                newMarker(local,obj.rua1,obj.rua2,obj.id);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Erro");
        }
    });
}

/*function bairrosList() {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        async: false,
        data: JSON.stringify(json),
        contentType: "application/json; charset=utf-8",
        url: '/bairros',
        success: function (json) {
            /*
            * Json tipo Esquina{id,rua1,rua2,bairro,longitude,latitude}
            * */
            //var obj=JSON.parse(json);
            //obj=json;
            //console.log(obj);
            //console.log(json);
            /*for(var i=0;i<json.length;i++) {
                obj=json[i];
                console.log(obj);

            }

        },
        error: function (jqXHR, textStatus, errorThrown) {
            window.alert("Erro");
        }
    });
}*/

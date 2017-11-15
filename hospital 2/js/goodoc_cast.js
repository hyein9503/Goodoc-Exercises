//굿닥 캐스트 버튼 눌렀을 때 마우스오버(마우스 올렸을 때)이벤트

function mouse_location (event) {

        var oX = event.offsetX;
        //현재 오브젝트 기준(ex: 현재 버튼)
        var cX = event.clientX;// 현재 문서기준
        var sX = event.screenX;//현재 스크린(모니터 기준)

        var oY = event.offsetY;
        var cY = event.clientY;
        var sY = event.screenY;


        var location1 = "현재 오브젝트(버튼) 기준 위치: X :" + oX + ", Y : " + oY;
        var location2 = "현재 문서 기준 위치: X :" + cX + ", Y : " + cY;
        var location3 = "현재 스크린 기준 위치: X:" + sX + ",Y: " + sY;

        alert(location1+"\n"+ location2+"\n"+location3);

    //document.getElementById("demo").innerHTML = coords1 + "<br>" + coords2+"<br>"+coords3;
}
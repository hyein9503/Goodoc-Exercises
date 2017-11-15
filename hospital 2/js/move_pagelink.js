/**
 * Created by hyeeeeeiny on 2017. 11. 14..
 */
//각 페이지 변수로 선언

var page1="https://www.goodoc.co.kr"; //내 주변 병원찾기 버튼 클릭시 이동페이지
var page2="https://www.goodoc.co.kr/pharmacies";//내 주변 약국찾기 버튼 클릭시 이동페이지
var page3="https://www.goodoc.co.kr/themes?category_id=225&list_open=1&selected=0"; //상황별 병원찾 클릭시 이동페이지

function pagelink1() { // 내 주변 병원찾기

    window.open(page1); //링크이동

}

function pagelink2(){// 내 주변 약국찾기
    window.open(page2);

}

function pagelink3(){ // 상황별 병원 찾기
    window.open(page3);

}
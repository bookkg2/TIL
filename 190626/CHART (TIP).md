

### CHART 만들 때 주의 사항

### (server 두 군데서 html가져올 경우)



- 웹 regulation - 현재 브라우저는 내가 접속하고 있는 현재 서버외에는 아무 서버에도 접속할 수 없다. - Cross....오류

  - 해결방법 : 1) HTML5에서 서로 신뢰한다는 체크를 해준다. 

    ​                      (보안을 푸는것은 X)

    ​                   2) <https://cors.io/?> 앞에 이것을 붙여줘서 해결한다.

    (Ex : <https://cors.io/?http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastSpaceData>)
# metar-reader
METAR (Java Spring Boot) parser to human more readable format.

You must have: Maven. If You have, You probably don't need any additional instructions.
If not:
- install maven: https://maven.apache.org
- it's worth to read: https://spring.io/guides/gs/rest-service/
- THEN GOTO metar-reader/ main dir (that is, where is the pom.xml file), and type in command line:
>mvn spring-boot:run

And then: 
http://localhost:8080/decode?message="yourdatagram"
will decode METAR datagram and return back readable JSON.

For eg.: http://localhost:8080/decode?message=%22METAR%20EPDE%20081530Z%2009010KT%204500%20BR%20SCT008%20OVC011%2004/03%20Q1024%20RMK%20040%20091%208/4=%22

Is decoded to nice and tasty:

{"datagram":{"type":"METAR","time":{"day":8,"hr":15,"min":30,"unix":1510155000},"weather":{"occurence":"not reported"},"wind":{"vrb":false,"direction":90,"speed":10,"gust":0},"temp":{"air":4.0,"dew":3.0},"airport":{"fullName":null,"icao":null,"iata":"EPDE","lat":0.0,"lon":0.0,"amsl":0},"pressure":{"qnh":1024}},"ver":0.1025,"systemInfo":{"name":"sys"}}

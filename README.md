# metar-reader
METAR (Java Spring Boot) parser to human more readable format.

You must have: Maven. If You have, You probably don't need any additional instructions.
If not:
- install maven: https://maven.apache.org
- it's worth to read: https://spring.io/guides/gs/rest-service/
- THEN GOTO metar-reader/ main dir (that is, where is the pom.xml file), and type in command line:
?mvn spring-bot:run

And then: 
http://localhost:8080/decode?message="yourdatagram"
will decode METAR datagram and return back readable JSON.
Will, in some future :D

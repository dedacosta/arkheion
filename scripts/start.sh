 mvn -pl :arkheion-webapp-discovery spring-boot:run &
 sleep 3
 mvn -pl :arkheion-webapp-backend spring-boot:run &
 mvn -pl :arkheion-webapp-gateway spring-boot:run &

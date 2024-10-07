 mvn -pl :arkheion-webapp-discovery spring-boot:run &
 sleep 2
 mvn -pl :arkheion-webapp-gateway spring-boot:run &
 mvn -pl :arkheion-webapp-backend spring-boot:run &


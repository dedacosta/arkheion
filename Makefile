all:
	@#


.PHONY : run stop send

run:
	@mvn -pl :arkheion-webapp-discovery spring-boot:run &
	@sleep 2
	@mvn -pl :arkheion-webapp-backend spring-boot:run &
	@mvn -pl :arkheion-webapp-gateway spring-boot:run &

stop:
	@kill `cat arkheion-webapp/arkheion-webapp-backend/application.pid`
	@kill `cat arkheion-webapp/arkheion-webapp-gateway/application.pid`
	@kill `cat arkheion-webapp/arkheion-webapp-discovery/application.pid`

send:
	@curl -X POST http://localhost:3000/backend/api/v1/xml/book \
       -H 'Content-Type: application/json' \
       -d '{"title":"Lovely", "authors": "Frank Roman"}'
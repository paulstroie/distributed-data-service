# distributed-data-service

Jdk 1.8
Maven 4
Docker

mvn clean install

docker build --build-arg PORT=9094 --build-arg JAR_FILE=distributed-data-service-1.0.jar -t distributed-data-service:1.0 -f docker/Dockerfile .

docker network create -d bridge --scope=swarm network-data-share

docker stack deploy -c docker/docker-compose.yml micro

http://localhost:9094/api/v1/health

http://localhost:9094/swagger-ui.html#/

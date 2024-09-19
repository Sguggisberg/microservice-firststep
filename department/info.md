# run second instance of department

java -jar .\department-0.0.1-SNAPSHOT.jar


# Docker

## Build
docker build -t springio/gs-spring-boot-docker .

## Run
docker run -p 8082:8082 springio/gs-spring-boot-docker 

## Commands

is running:     docker ps
show logs:      docker logs -f {docker id}
stoppen         docker stop {docker id}

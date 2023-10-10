# Docker Java Springboot Todoo app

This Java Springboot Todoo app is built using Spring Data JPA, H2 Database and a dash of Thymeleaf. The best part is you can also deploy opentelemetry for this in less time than it takes to build the container (no foolin!).

To read the full blog writeup, check out the blog 

### pre-requisites

- [Sign up for a Lumigo account](https://lumigo.io/signup)
- [Docker installed](https://www.docker.com/get-started/)
- [Maven installed](https://maven.apache.org/install.html)
- Java 18

### Run locally 

CLI into the root directory and then run `mvn spring-boot:run`

Open a browser and then run [localhost:8080](http://localhost:8080)

### Run in a container

Run `mvn install` in the project root. 

With docker running, then run `docker build -t todoo .`

Once its finished start the app with `docker run -d -p 8080:8080 --name todoo todoo`

### Run in a container with [Lumigo](https://lumigo.io/signup) 1-click OpenTelemetry

If the container is already running first stop it with `docker stop todoo`.

Next head over to your [Lumigo](https://lumigo.io/signup) login and retrieve your [Lumigo Tracer Token](https://docs.lumigo.io/docs/lumigo-tokens). 

Then download the latest [Lumigo Java Distro](https://github.com/lumigo-io/opentelemetry-java-distro) from the releases area, and put it into the project root. Open the `Dockerfile` and uncomment lines `11` and `14`.

Rebuild the container again using `docker build -t todoo .`

Lastly, Run the container and set the `LUMIGO_TRACER_TOKEN` env var with the token from above, at the same time we will also set the `OTEL_SERVICE_NAME` env var which will appear on the traces in your Lumigo instance. 

The docker run should look something like this 

```
docker run -d -p 8080:8080 --name todoo \
-e LUMIGO_TRACER_TOKEN={token} \
-e OTEL_SERVICE_NAME=Todoo \
todoo
```

### Cleaning up 

To stop the running container run `docker stop todoo`, then run `docker rm todoo` to remove it. 

Don't forget to also clean up images and container using `docker prune` from time to time too, they add up really quick sometimes.  


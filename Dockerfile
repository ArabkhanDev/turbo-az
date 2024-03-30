FROM alpine:latest
RUN apk add --no-cache openjdk17
RUN apk add --no-cache tzdata
COPY build/libs/turbo-az-1.0.4bd504c.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/turbo-az-1.0.4bd504c.jar"]

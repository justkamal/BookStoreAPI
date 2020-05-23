FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/justkamal/BookStoreAPI.git (1)
FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/BookStoreAPI /app (2)
RUN mvn install (3)

FROM openjdk:8-jre-alpine
EXPOSE 8080
WORKDIR /app
COPY --from=1 /app/target/bookstore-app-docker.jar /app (4)
CMD ["java -jar bookstore-app-docker"] (5)

FROM mysql:8.0.20 as builder
RUN ["sed", "-i", "s/exec \"$@\"/echo \"not running $@\"/", "/usr/local/bin/docker-entrypoint.sh"]
ENV MYSQL_ROOT_PASSWORD='#Root123'
COPY script.sql /docker-entrypoint-initdb.d/
RUN ["/usr/local/bin/docker-entrypoint.sh", "mysqld", "--datadir", "/initialized-db"]
FROM mysql:8.0.20
COPY --from=builder /initialized-db /var/lib/mysql

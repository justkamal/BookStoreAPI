FROM openjdk:8
FROM mysql:8.0.20
EXPOSE 8080
ADD target/bookstore-app-docker.jar bookstore-app-docker.jar
ENTRYPOINT ["java", "-jar", "bookstore-app-docker.jar"]

FROM mysql:8.0.20 as builder
RUN ["sed", "-i", "s/exec \"$@\"/echo \"not running $@\"/", "/usr/local/bin/docker-entrypoint.sh"]
ENV MYSQL_ROOT_PASSWORD='#Root123'
COPY script.sql /docker-entrypoint-initdb.d/
RUN ["/usr/local/bin/docker-entrypoint.sh", "mysqld", "--datadir", "/initialized-db"]
FROM mysql:8.0.20
COPY --from=builder /initialized-db /var/lib/mysql

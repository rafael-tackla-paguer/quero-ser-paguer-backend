FROM tomcat:9.0
COPY target/backend-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/backend.jar
RUN sh -c "touch /usr/local/tomcat/webapps/backend.jar"
ENTRYPOINT ["sh", "-c","java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/backend.jar" ]
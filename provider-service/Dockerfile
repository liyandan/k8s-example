FROM wangcaitao/openjdk:8u191-jre-alpine

LABEL author="wangcaitao"
LABEL version="1.0.0"

ARG jarFile

COPY ${jarFile} application.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xms128m","-Xmx128m","-XX:+HeapDumpOnOutOfMemoryError","-jar","/application.jar"]

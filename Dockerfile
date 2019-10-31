FROM registry.cn-hangzhou.aliyuncs.com/hk-java/java:8-jre-cron

MAINTAINER fighting_yang

COPY /target/springboot-0.0.1.SNAPSHOT.jar /opt/hk/

WORKDIR /opt/hk

ENV TZ=Asia/Shanghai

EXPOSE 8080

CMD unzip -o -d /opt/hk/ /opt/hk/springboot-0.0.1.SNAPSHOT.jar && java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom  -cp . org.springframework.boot.loader.JarLauncher
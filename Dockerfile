# JDK17
FROM openjdk:17

# 환경 변수 설정
ENV SPRING_APPLICATION_NAME=team01 \
    SERVER_PORT=8080 \
    SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver \
    SPRING_DATASOURCE_URL="jdbc:mysql://database-uggthon.c7qi28ak2iln.eu-north-1.rds.amazonaws.com:3306/uggthon?serverTimezone=UTC&characterEncoding=UTF-8" \
    SPRING_DATASOURCE_USERNAME=admin \
    SPRING_DATASOURCE_PASSWORD=uggthon12 \
    SPRING_JPA_HIBERNATE_DDL_AUTO=update

# 인자 설정, jar 파일 복제
COPY build/libs/*.jar app.jar

# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]
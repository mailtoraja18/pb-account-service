FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/mailtoraja18/piggy-bank.git

FROM maven:3.5.4-jdk-11
WORKDIR /app
COPY --from=0 /app/piggy-bank /app
RUN mvn install -Dmaven.test.skip=true

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=1 /app/account-service/target/account-service-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar" ,"-Dspring.profiles.active=k8","/app/account-service-0.0.1-SNAPSHOT.jar"]
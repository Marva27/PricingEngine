FROM openjdk:11
ADD target/PricingEngine-0.0.1-SNAPSHOT.jar PricingEngine.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/PricingEngine.jar"]
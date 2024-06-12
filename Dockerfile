From eclipse-temurin:17
COPY target/payroll.jar payroll.jar
CMD ["java","-jar","payroll.jar"]
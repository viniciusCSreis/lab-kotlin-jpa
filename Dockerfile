FROM viniciuscsreis/lab-kotlin-jpa-spring-1.5.3
COPY . .
RUN mvn clean install -DskipTests
ENTRYPOINT java -jar target/demo-0.0.1-SNAPSHOT.jar
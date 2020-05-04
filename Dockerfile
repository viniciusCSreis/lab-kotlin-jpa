FROM viniciuscsreis/lab-kotlin-jpa-spring-2.1.6
COPY . .
RUN mvn clean install -DskipTests
ENTRYPOINT java -jar target/demo-0.0.1-SNAPSHOT.jar
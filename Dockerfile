FROM selenium/standalone-chrome

COPY target/ebay-1.0-SNAPSHOT-jar-with-dependencies.jar ebay-1.0-SNAPSHOT-jar-with-dependencies.jar

ENTRYPOINT ["java", "-jar", "ebay-1.0-SNAPSHOT-jar-with-dependencies.jar"]

CMD ["testng.xml"]
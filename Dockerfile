FROM ${BASE_IMAGE_NAME}
COPY target/urlshortner.jar /app/urlshortner.jar
EXPOSE 8080
CMD java -jar /app/urlshortner.jar
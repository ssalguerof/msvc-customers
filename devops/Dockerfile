FROM openjdk:8-jre-alpine

# Create app directory
RUN mkdir -p /opt/logs
WORKDIR /opt

ADD *.jar /opt/

ENTRYPOINT ["sh", "-c"]
CMD ["exec java -Duser.timezone=America/Lima \
        -jar *.jar"]
        
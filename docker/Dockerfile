FROM davidcaste/alpine-java-unlimited-jce
MAINTAINER MyLifeDigital Development
WORKDIR /effective-consents-connector
COPY effective-consents-connector.jar /effective-consents-connector
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /effective-consents-connector/effective-consents-connector.jar

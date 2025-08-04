# Homepage

A Java Spring homepage hosted with Apache Tomcat and templated with Thymeleaf.

![Screenshot of the homepage](example.png)

## Running
To run this for development purposes, launch a webserver on port 4028 (or configured otherwise) with maven.
```
source scripts/prepare-env.sh
mvn spring-boot:run
```

## First time installation
Install using maven, take a note of where the jar file is installed to.
```
mvn clean install 

...

>[INFO] Installing /home/daniel/Repos/homepage/pom.xml to /home/daniel/.m2/repository/com/daniel/homepage/2.0/homepage-2.0.pom
>[INFO] Installing /home/daniel/Repos/homepage/target/homepage-2.0.jar to /home/daniel/.m2/repository/com/daniel/homepage/2.0/homepage-2.0.jar
>[INFO] ------------------------------------------------------------------------
>[INFO] BUILD SUCCESS
>[INFO] ------------------------------------------------------------------------
>[INFO] Total time:  8.392 s
>[INFO] Finished at: 2025-08-04T15:28:58+01:00
>[INFO] ------------------------------------------------------------------------
```

Link as a systemD service. This will run the installed jar file every time the computer starts up.
```
su root
source scripts/prepare-env.sh
source scripts/install-as-service.sh /PATH/TO/JAR/FILE
```
The webpage should now be installed and consistently accessible.

## Reinstallation
When updating with a new version of the code, the binary only needs to be updated and the service restarted.
```
mvn clean install
systemctl restart springhomepage.service
```

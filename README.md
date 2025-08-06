# Homepage

A Java Spring homepage hosted with Apache Tomcat and templated with Thymeleaf.

![Screenshot of the homepage](example.png)

## Running
To run this for development purposes, launch a webserver on port 4028 (or configured otherwise) with maven.
```
source scripts/prepare-env.sh
mvn spring-boot:run
```

## Configuration
The servelet is completely configurable at [src/main/resources/*.properties](src/main/resources/application.properties). Shortcuts can be added/removed, weather adjectives can be changed, definitions of e.g. 'hot' or 'very hot' can be changed, and the wallpapers can be easily swapped out.
```
spring.application.name=Browser Homepage
server.address=localhost
server.port=4028

weather.refresh_cron=0 */20 * * * *
weather.http_timeout_s=10
weather.base_url=https://api.openweathermap.org/data/2.5/weather
weather.latitude=${LAT}
weather.longitude=${LON}
weather.units=metric
weather.api_key=${API_KEY}
weather.icon_prefix=https://openweathermap.org/img/wn/
weather.icon_suffix=@4x.png
weather.freezing_temp=0
weather.high_temp=26
weather.very_high_temp=32
weather.high_humidity=85
weather.high_windspeed=7

wallpaper.snow=snow.webp
wallpaper.thunder=thunderstorm.webp
wallpaper.rain=rain.gif
[...]

shortcut.images=gmail.png,github.png,[...]
shortcut.urls=mail.google.com/mail,github.com/carlossss111,[...]
shortcut.alts=GMail,Github,[...]
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

## Future Direction
After adding weather info, I'd like to use webgl to add shaders e.g. to create a rain effect

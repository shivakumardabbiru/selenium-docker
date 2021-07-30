From openjdk:8u191-jre-alpine3.8
# as the alpine doesn't have curl and jq by default, add the same using the below RUN command.
RUN apk add curl jq

#WORKING DIRCTORY FOR IMAGE FILE
WORKDIR /usr/share/udemy

#Add .jar files and lib files into the working dir
ADD target/selenium-docker.jar              selenium-docker.jar
ADD target/selenium-docker-tests.jar        selenium-docker-tests.jar
ADD target/libs                             libs

# Add any other dependencies like test data excel files, fixture files ,csv, json files etc
#Add suite files
        
ADD bookflight.xml                          bookflight.xml
ADD searchtesting.xml                       searchtesting.xml

#ADD the healthcheck file 
ADD  healthcheck.sh                         healthcheck.sh

#Sometime when copying windows sh file to linux, some char might not work properly. hence convert the file from windows to unix format
RUN dos2unix healthcheck.sh


#Runtime values as environment variables
#BROWSER
#HUB_HOST
#TESTSUITE FILE

# call the health check file to check the hub status and the java -cp command in health check will run the jars.
ENTRYPOINT sh healthcheck.sh
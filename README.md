# Locationfinder
#All the Source code is available in the master branch

Created simple webapp to return location data using Java and Spark

Maven dependencies
Java Spark:

Spark framework is a rapid development web framework inspired by the Sinatra framework for Ruby and is built around Java 8 Lambda Expression philosophy, making it less verbose than most applications written in other Java frameworks.

It's a good choice if you want to have a Node.js like experience when developing a web API or microservices in Java. With Spark, you can have a REST API ready to serve JSON in less than ten lines of code.

        <dependency>
			<groupId>com.sparkjava</groupId>
			<artifactId>spark-core</artifactId>
			<version>2.5.4</version>
		</dependency>
    
Gson Library:
At various places in the example, we will be using Gson library for JSON operations. To include Gson in the project, include this dependency in your pom.xml:
    
         <dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.0</version>
	</dependency>
Spark-Job-Server-Client:

Spark-Job-Server-Client is a open-source program of com.bluebreezecf under Apache License v2. It aims to make the java applications use the spark more easily.This is taken as reference from https://github.com/bluebreezecf/SparkJobServerClient

       <dependency>
             <groupId>com.bluebreezecf</groupId>
             <artifactId>spark-job-server-client</artifactId>
             <version>1.0.0</version>
        </dependency>
	
Swagger Dependencies: In order to display Swagger/OpenApI specification to the end points created in the backend Swagger dependencies are added to the project referred from https://github.com/manusant/spark-swagger and https://swagger.io/tools/swagger-codegen/ to generate javascript SDK for frontend application to access API	
		<dependency>
			<groupId>com.beerboy.ss</groupId>
			<artifactId>spark-swagger</artifactId>
			<version>1.0.0.48</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.swagger.codegen.v3</groupId>
			<artifactId>swagger-codegen-maven-plugin</artifactId>
			<version>3.0.23</version>
		</dependency>
        
Build Code: 

maven clean and install to download all the dependencies into the project

        
GEO Location Services:

IP Geolocation API Java SDK.Downloaded the latest JAR file for IP Geolocation API Java SDK to use free service such as https://ipgeolocation.io/.

https://ipgeolocation.io/downloads/ip-geolocation-api-java-1.0.12.jar.

Java Classes

GeoLocationData: Contains all the location data fields such as CountryName,Currency,StatusCode,Message.

SparkRestserviceTest:Contains all the route information and req param feilds to access the services through API key Provided by https://app.ipgeolocation.io/.This class return Json response in the browser.(localhost:4567:geolocate/<ipaddress>)

SparkJobClientTest: Contains the client code .

Routes:
get("/your-route-path/", (request, response) -> {
    // your callback code
});


The JSON Response Structure:
{
    status: <STATUS>
    message: <TEXT-MESSAGE>
    data: <JSON-OBJECT>
}

Output:

·   API successfully returns a JSON result of IP geolocation data

·  The IP address in the URI is validated as a valid IPv4 or IPv6 address

·  Invalid addresses and backend queries fail gracefully with appropriate 400 and 500-type errors.

·  The project is written in Java and SparkJava

·  Client code has been added in the /client folder

   












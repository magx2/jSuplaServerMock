***

<div align="center">

[![Build Status](https://travis-ci.org/magx2/jSuplaServerMock.svg?branch=master)](https://travis-ci.org/magx2/jSuplaServerMock)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Download](https://api.bintray.com/packages/big-boy/bigboy/jSuplaServerMock/images/download.svg) ](https://bintray.com/big-boy/bigboy/jSuplaServerMock/_latestVersion)

This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.

</div>

***

# Swagger Generated Server

jSupla Mock Server allows you to start server that is compatible with Supla Cloud. By default it has mock all possible devices.  

# Run Server

Download latest version from [![Download](https://api.bintray.com/packages/big-boy/bigboy/jSuplaServerMock/images/download.svg) ](https://bintray.com/big-boy/bigboy/jSuplaServerMock/_latestVersion) and then run

```$bash
java -jar jsupla-mock-server-<VERSION>.jar

```

After about 30 seconds server should be started. To test it you can send test request to `http://localhost:9090/api/2.3.0/server-info`

```bash
curl -X GET "http://localhost:9090/api/v2.3.0/server-info" -H  "accept: application/json"
```

As a response you should get something like this (not formatted):

```json
{
  "address": "http://localhost:9090/api/v2.3.0",
  "time": null,
  "timezone": null,
  "authenticated": null,
  "username": null,
  "cloudVersion": "2.3.0",
  "apiVersion": "2.3.0",
  "supportedApiVersions": [
	"2.3.0"
  ]
} 
```

For more api calls you can check [Supla Swagger Hub](https://app.swaggerhub.com/apis/supla/supla-cloud-api/2.3.0#/Server/getServerInfo)

## Authorization

Most of calls need to be authorized with oAuth token. The default token is `MzFhYTNiZTAwODg5M2E0NDE3OGUwNWE5ZjYzZWQ2YzllZGFiYWRmNDQwNDBlNmZhZGEzN2I3NTJiOWM2ZWEyZg`. You can change it in `/src/main/resources/application.yml` or during startup via Spring Boot properties (`--jsupla.token=your_token`).

_Note 1: Tokens generated from Supla Cloud are made from 2 parts that are separated with dot. First part is plain OAuth token. Second part is server URL encoded in Base64. In this implementation you don't need to pass anything as server URL, but if you will pass it, it will be trimmed._    

_Note 2: If you want to use token that will point you to `http://localhost:9090` you can use this token `MzFhYTNiZTAwODg5M2E0NDE3OGUwNWE5ZjYzZWQ2YzllZGFiYWRmNDQwNDBlNmZhZGEzN2I3NTJiOWM2ZWEyZg.aHR0cDovL2xvY2FsaG9zdDo5MDkw`_

# Gradle & Maven

To embed Supla server in you Gradle/Maven application you first need to add `big-boy` bintray repository: 

```groovy
repositories { 
	maven { 
		url "https://dl.bintray.com/big-boy/bigboy" 
	} 
}
```

```xml
<repositories>
	<repository>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
		<id>bintray-big-boy-bigboy</id>
		<name>bintray</name>
		<url>https://dl.bintray.com/big-boy/bigboy</url>
	</repository>
</repositories>
```

After this just add dependency:

```groovy
compile 'pl.grzeslowski.jsuplaservermock:jsupla-mock-server:VERSION'
```

```xml
<dependency>
  <groupId>pl.grzeslowski.jsuplaservermock</groupId>
  <artifactId>jsupla-mock-server</artifactId>
  <version>VERSION</version>
  <type>pom</type>
</dependency>
```

The latest version you can find here [![Download](https://api.bintray.com/packages/big-boy/bigboy/jSuplaServerMock/images/download.svg) ](https://bintray.com/big-boy/bigboy/jSuplaServerMock/_latestVersion)

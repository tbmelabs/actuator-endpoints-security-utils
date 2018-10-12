# Actuator-Endpoints-Security-Utils

Utilities to secure actuator endpoints.

[![Build Status](https://travis-ci.org/tbmelabs/actuator-endpoints-security-utils.svg?branch=master)](https://travis-ci.org/tbmelabs/actuator-endpoints-security-utils)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=actuator-endpoints-security-utils&metric=alert_status)](https://sonarcloud.io/dashboard?id=actuator-endpoints-security-utils)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](https://github.com/tbmelabs/actuator-endpoints-security-utils/tree/master#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

Make sure to install the following software before starting:

* [Java Development Kit 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* [Maven](https://maven.apache.org/download.cgi)

And your IDE should support [Lombok](https://projectlombok.org/).

### Installing

Make sure your IDE supports Lombok. Apart from this, this project does not need any special installation steps.

## Running the tests

Execute unit-tests by running `mvn test`. They are managed by the [maven-surefire-plugin](https://maven.apache.org/surefire/maven-surefire-plugin/).
Integration-tests start with `mvn verify` using the [maven-failsafe-plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/).

## Deployment

This project is deployed using maven. Run `mvn clean install` to install the artifact into your local repository.

## Built With

* [Maven](https://maven.apache.org/) - A software project management and comprehension tool.

## Contributing

Please read [CONTRIBUTING.md](https://github.com/tbmelabs/actuator-endpoints-security-utils/blob/master/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/tbmelabs/actuator-endpoints-security-utils/tags). 

## Authors

* **Timon Borter** - *Initial work* - [bbortt](https://github.com/bbortt)

See also the list of [contributors](https://github.com/tbmelabs/actuator-endpoints-security-utils/contributors) who participated in this project.

## License

This project is published under the terms of MIT License. For more information see the [license file](https://github.com/tbmelabs/actuator-endpoints-security-utils/blob/development/LICENSE).

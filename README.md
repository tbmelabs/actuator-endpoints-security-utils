# Actuator-Endpoints-Security-Utils

Utilities to secure actuator endpoints.

[![Build Status](https://travis-ci.org/tbmelabs/actuator-endpoints-security-utils.svg?branch=master)](https://travis-ci.org/tbmelabs/actuator-endpoints-security-utils)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/d9eae98d8d1d4915b8f56ab8e7ce8d7b)](https://www.codacy.com/app/bbortt_2/actuator-endpoints-security-utils?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=tbmelabs/actuator-endpoints-security-utils&amp;utm_campaign=Badge_Grade)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](https://github.com/tbmelabs/actuator-endpoints-security-utils/tree/master#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

Make sure to install the following software before starting:

* [Java Development Kit 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html): [This guide](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) leads you through the installation.
* [Maven](https://maven.apache.org/download.cgi): Have a look at [this page](https://maven.apache.org/install.html) for any help while installing.
* [Project Lombok](https://projectlombok.org/): Take a look on [this pages](https://projectlombok.org/setup/eclipse) for installation guides.

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

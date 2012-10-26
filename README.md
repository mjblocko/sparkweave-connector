Mule SparkWeave Connector
=========================

Sparkweave is an on-premise or privately hosted collaboration platform for secure mobile file access and sharing, group file collaboration, large file transfer and secure messaging. This connector allows access to SparkWeave File Sharing API.

Installation
------------

The connector can either be installed for all applications running within the Mule instance or can be setup to be used
for a single application.

*All Applications*

Download the connector from the link above and place the resulting jar file in
/lib/user directory of the Mule installation folder.

*Single Application*

To make the connector available only to single application then place it in the
lib directory of the application otherwise if using Maven to compile and deploy
your application the following can be done:

Add the connector's maven repo to your pom.xml:

    <repositories>
        <repository>
            <id>muleforge-releases</id>
            <name>MuleForge Snapshot Repository</name>
            <url>https://repository.muleforge.org/release/</url>
            <layout>default</layout>
        </repsitory>
    </repositories>

Add the connector as a dependency to your project. This can be done by adding
the following under the dependencies element in the pom.xml file of the
application:

    <dependency>
        <groupId>org.mule.modules</groupId>
        <artifactId>mule-module-facebook</artifactId>
        <version>2.0-SNAPSHOT</version>
    </dependency>

Configuration
-------------

You can configure the connector as follows:

    <facebook:config server="value" user="value" password="value" useHttps="value"/>

Here is detailed list of all the configuration attributes:

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|server| Name of SparkWeave Server.|no||
|user| User email address.|no|
|pasword|The application secret|no|
|useHttps| true is server is only using https(default is false)|yes|





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































Search
------

Search over all public objects in the social graph
<p/>


    
    <facebook:search q="muelsoft" obj="photo"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|q|The search string|no||
|obj|Supports these types of objects: All public posts (post), people (user), pages (page), events (event), groups (group), check-ins (checkin)|yes|post|



Get Album
---------

A photo album
<p/>


    
    <facebook:get-album album="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|album|Represents the ID of the album object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Album Photos
----------------

The photos contained in this album
<p/>


    
    <facebook:get-album-photos album="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|album|Represents the ID of the album object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Album Comments
------------------

The comments made on this album
<p/>


    
    <facebook:get-album-comments album="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|album|Represents the ID of the album object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Event
---------

Specifies information about an event, including the location, event name, and which invitees plan
to attend.
<p/>


    
    <facebook:get-event eventId="123456789" metadata="O"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Event Wall
--------------

This event's wall
<p/>


    
    <facebook:get-event-wall eventId="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Event No Reply
------------------

All of the users who have been not yet responded to their invitation to this event
<p/>


    
    <facebook:get-event-no-reply eventId="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Event Maybe
---------------

All of the users who have been responded "Maybe" to their invitation to this event
<p/>


    
    <facebook:get-event-maybe eventId="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Event Invited
-----------------

All of the users who have been invited to this event
<p/>


    
    <facebook:get-event-invited eventId="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Event Attending
-------------------

All of the users who are attending this event
<p/>


    
    <facebook:get-event-attending eventId="123456789"/>
    

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Event Declined
------------------

All of the users who declined their invitation to this event

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Event Picture
-----------------

The event's profile picture

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the ID of the event object.|no||
|type|One of square (50x50), small (50 pixels wide, variable height), and large (about 200 pixels wide, variable height)|yes|small|



Get Group
---------

A Facebook group

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|group|Represents the ID of the group object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Group Wall
--------------

This group's wall

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|group|Represents the ID of the group object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Group Members
-----------------

All of the users who are members of this group

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|group|Represents the ID of the group object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Group Picture
-----------------

The profile picture of this group

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|group|Represents the ID of the group object.|no||
|type|One of square (50x50), small (50 pixels wide, variable height), and large (about 200 pixels wide, variable height)|yes|small|



Get Link
--------

A link shared on a user's wall

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|link|Represents the ID of the link object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Link Comments
-----------------

All of the comments on this link

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|link|Represents the ID of the link object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Note
--------

A Facebook note

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|note|Represents the ID of the note object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Note Comments
-----------------

All of the comments on this note

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|note|Represents the ID of the note object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Note Likes
--------------

People who like the note

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|note|Represents the ID of the note object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page
--------

A

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Page Wall
-------------

The page's wall

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Picture
----------------

The page's profile picture

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|type|One of square (50x50), small (50 pixels wide, variable height), and large (about 200 pixels wide, variable height)|yes|small|



Get Page Tagged
---------------

The photos, videos, and posts in which this page has been tagged

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Links
--------------

The page's posted links

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Photos
---------------

The photos this page has uploaded

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Groups
---------------

The groups this page is a member of

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Albums
---------------

The photo albums this page has created

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Statuses
-----------------

The page's status updates

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Videos
---------------

The videos this page has created

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Notes
--------------

The page's notes

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Posts
--------------

The page's own posts

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Events
---------------

The events this page is attending

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Page Checkins
-----------------

Checkins made by the friends of the current session user

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|page|Represents the ID of the page object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Photo
---------

An individual photo

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|photo|Represents the ID of the photo object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Photo Comments
------------------

All of the comments on this photo

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|photo|Represents the ID of the photo object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Photo Likes
---------------

People who like the photo

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|photo|Represents the ID of the photo object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Post
--------

An individual entry in a profile's feed

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|post|Represents the ID of the post object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Post Comments
-----------------

All of the comments on this post

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|post|Represents the ID of the post object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Status
----------

A status message on a user's wall

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|status|Represents the ID of the status object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Status Comments
-------------------

All of the comments on this message

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|status|Represents the ID of the status object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User
--------

A user profile.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get User Search
---------------

Search an individual user's News Feed, restricted to that user's friends

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|
|q|The text for which to search.|yes|facebook|



Get User Home
-------------

The user's News Feed. Requires the read_stream permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Wall
-------------

The user's wall. Requires the read_stream permission to see non-public posts.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Tagged
---------------

The photos, videos, and posts in which this user has been tagged. Requires the user_photo_tags,
user_video_tags, friend_photo_tags, or friend_video_tags permissions

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Posts
--------------

The user's own posts. Requires the read_stream permission to see non-public posts.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Picture
----------------

The user's profile picture

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|type|One of square (50x50), small (50 pixels wide, variable height), and large (about 200 pixels wide, variable height)|yes|small|



Get User Friends
----------------

The user's friends

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Activities
-------------------

The activities listed on the user's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Checkins
-----------------

The music listed on the user's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Interests
------------------

The interests listed on the user's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Music
--------------

The music listed on the user's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Books
--------------

The books listed on the user's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Movies
---------------

The movies listed on the user's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Television
-------------------

The television listed on the user's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Likes
--------------

All the pages this user has liked. Requires the user_likes or friend_likes permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Photos
---------------

The photos this user is tagged in. Requires the user_photos or friend_photos permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Albums
---------------

The photo albums this user has created. Requires the user_photos or friend_photos permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Videos
---------------

The videos this user has been tagged in. Requires the user_videos or friend_videos permission.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Groups
---------------

The groups this user is a member of. Requires the user_groups or friend_groups permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Statuses
-----------------

The user's status updates. Requires the read_stream permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Links
--------------

The user's posted links. Requires the read_stream permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Notes
--------------

The user's notes. Requires the read_stream permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Events
---------------

The events this user is attending. Requires the user_events or friend_events permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Inbox
--------------

The threads in this user's inbox. Requires the read_mailbox permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Outbox
---------------

The messages in this user's outbox. Requires the read_mailbox permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Updates
----------------

The updates in this user's inbox. Requires the read_mailbox permission

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get User Accounts
-----------------

The Facebook pages owned by the current user

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|user|Represents the ID of the user object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Video
---------

An individual video

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|video|Represents the ID of the video object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Video Comments
------------------

All of the comments on this video

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|video|Represents the ID of the video object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Publish Message
---------------

Write to the given profile's feed/wall.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|profile_id||no||
|msg|The message|no||
|picture|If available, a link to the picture included with this post|yes||
|link|The link attached to this post|yes||
|caption|The caption of the link (appears beneath the link name)|yes||
|name|The name of the link|yes||
|description|A description of the link (appears beneath the link caption)|yes||



Publish Comment
---------------

Comment on the given post

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|postId|Represents the ID of the post object.|no||
|msg|comment on the given post|no||



Like
----

Write to the given profile's feed/wall.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|postId|Represents the ID of the post object.|no||



Publish Note
------------

Write a note on the given profile.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|profile_id||no||
|msg|The message|no||
|subject||no||



Publish Link
------------

Write a note on the given profile.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|profile_id||no||
|msg|The message|no||
|link||no||



Publish Event
-------------

Post an event in the given profile.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|profile_id||no||



Attend Event
------------

Attend the given event.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId||no||



Tentative Event
---------------

Maybe attend the given event.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the id of the event object|no||



Decline Event
-------------

Decline the given event.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|eventId|Represents the id of the event object|no||



Publish Album
-------------

Create an album.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|profile_id||no||
|msg|The message|no||
|name||no||



Publish Photo
-------------

Upload a photo to an album.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|albumId||no||
|caption|Caption of the photo|no||
|photo|File containing the photo|no||



Delete Object
-------------

Delete an object in the graph.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|objectId|The ID of the object to be deleted|no||



Dislike
-------

Remove a 'like' from a post.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|postId|The ID of the post to be disliked|no||



Get Checkin
-----------

A check-in that was made through Facebook Places.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|checkin|Represents the ID of the checkin object.|no||
|metadata|The Graph API supports introspection of objects, which enables you to see all of the connections an object has without knowing its type ahead of time.|yes|0|



Get Application
---------------

An application's profile

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||



Get Application Wall
--------------------

The application's wall.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Posts
---------------------

The application's own posts.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Picture
-----------------------

The application's logo

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|type|One of square (50x50), small (50 pixels wide, variable height), and large (about 200 pixels wide, variable height)|yes|small|



Get Application Tagged
----------------------

The photos, videos, and posts in which this application has been tagged.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Links
---------------------

The application's posted links.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Photos
----------------------

The photos this application is tagged in.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Albums
----------------------

The photo albums this application has created.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Statuses
------------------------

The application's status updates.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Videos
----------------------

The videos this application has created

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Notes
---------------------

The application's notes.

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Events
----------------------

The events this page is managing

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|



Get Application Insights
------------------------

Usage metrics for this application

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|application|Represents the ID of the application object.|no||
|since|A unix timestamp or any date accepted by strtotime|yes|last week|
|until|A unix timestamp or any date accepted by strtotime|yes|yesterday|
|limit|Limit the number of items returned.|yes|3|
|offset|An offset to the response. Useful for paging.|yes|2|





























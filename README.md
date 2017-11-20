# SampleJAXRSApplication
A sample JAX-RS project

# Details

I created this application to have a simple walk-through of the more common elements of the JavaEE spec.  It's primarily written against Wildfly, but it should work against any modern JavaEE application server.

Additionally, the whole thing builds fine with Gradle.  Seriously, try it out.

# So what's it *do*?

Not much.  It has two REST endpoints:

* rest/sayHello: a GET method that will return the first item in the database.  You cannot call this immediately.
* rest/postHello?message={your string}: You need to call this first.  It's a POST request (use Advanced Rest Client or something to make this happen).

This is supposed to be a toy and/or a jumping off point.  

# What was that about a database?

I'm using an in-memory SQLite3 database.  I presume nothing about your system.  If you wish, you can create a database file yourself.  It just needs to look like this:

**TABLE** greeting

|id|greeting|  
|--|--|  
|int|String|

And then you can populate it with whatever you want.  Just make sure that there's a row with an ID of 1.  You can repoint the app to use your file in the dependency.xml file.  Just change the java.jdbc.persistence.url property to your SQLite3 file's location.

At some point in the future, I might add a sample message driven bean just to get a bit more exposure in this app and make it do a bit of everything.

# Why didn't you unit test your DAOs?

Honestly, because I don't want to encourage users to use Powermock.

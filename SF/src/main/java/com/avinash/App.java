package com.avinash;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

//in this module lets create a basic servlet using the java
//Servlet is responsible for accepting the requests from client and sends data back to the client from server
//in this project we require two dependencies 1. jakarta servlet 2. tomcat-apache server
//in java we are not having servlet by default, so we are using jakarta servlet
//tomcat server runs in the local host 8080
//we will run our servlet in apache-tomcat server
//lets create a server class



public class App{
    public static void main(String[] ars) throws LifecycleException {

        System.out.println("Hello World...!");

        //Creating tomcat object
        Tomcat tomcat = new Tomcat();

        //by default tomcat will run in the port 8080
        //if you want to change the port, you can use the setPort() method on the tomcat object
        //now lets set the port to 1234
        tomcat.setPort(1234);

        //creating context object
        //we should perform addContext() method, which return the Context object
        //addContext() method accepts two parameters, 1. path 2. docBase
        //in this case we will keep them default and null
        //contextPath: This is the URL path at which the web application will be accessible.
        // For example, if you set contextPath to "/myapp", the application will be accessible at http://localhost:port/myapp.
        // If you set it to an empty string "", the application will be the root application and accessible at the root of the server (http://localhost:port/).
        //docBase: This is the path to the base directory of the web application (also known as the document base).
        // It typically contains the WEB-INF directory, JSP files, static resources like HTML, CSS, and JavaScript files, etc.
        // If this parameter is null, it means that you are not specifying a document base directory, which is common when you are configuring the context programmatically and not relying on a pre-existing directory structure.
        Context context = tomcat.addContext("",null);


        //inorder to send requests from the client we need to map the urls with the servlet
        //like if we visit a specific url, then the linked servlet should deal with the sent request
        //so in order to map the urls we need a context object

        //we need to apply addServlet() on the tomcat object
        //addServlet() is a static method, so we can directly apply on class "Tomcat"
        //addServlet() method accepts three parameters, 1. context object, 2.servlet name(our wish), 3. Servlet object
        Tomcat.addServlet(context,"hello servlet",new HelloServlet());

        //now we need to map the url with servlet
        //we will do that by addServletMappingDecoded() method bby applying on context object
        //addServletMappingDecoded() accepts two parameters 1. url(we will define), 2. Servlet name(it should be same as we defined above)
        context.addServletMappingDecoded("/","hello servlet");

        //we should define all the above-mentioned methods in the sequence
        //we should define all them before we start the server

        //let's start the server
        tomcat.start();

        //if we performs the start() method, server will start but it will immediately  terminates
        //then we cant send requests from client side
        //in order to make the server wait we need to use getServer().await() methods on tomcat object
        //lets do that
        tomcat.getServer().await();

        //in this file we can only configure nad map the server
        //in order to process the requests and send response we should do in sevlet file
    }
}
package com.avinash;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//for creating a servlet, we should extend the HttpServlet class
//inside our servlet class we should override the service() method, it takes two parameters
//1. HttpServletRequest object 2. HttpServletResponse object
//the data sent by the client will be stored in the request object
//the data sent by the servlet will be in the response object


public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In service...!");

        //sending response to the request
        //in order to write something on screen we need to get "PrintWriter" object
        //to get "PrintWriter" object, we should apply getWriter() method on response object
        //after we need to apply println() method
        //we can specify what type of content we are sending

        //setContent()
        res.setContentType("text/html");

        //getting PrintWriter object
        PrintWriter out=res.getWriter();

        //printing to screen
        out.println("<h2><b>Hello World</h2></b>");
    }
}
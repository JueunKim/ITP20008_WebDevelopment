package shopping;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/** Shows all the parameters sent to the servlet via either
 *  GET or POST. Specially marks parameters that have
 *  no values or multiple values.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class Purchase extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();
  
    HttpSession session = request.getSession();
    String id =(String)session.getAttribute("userName");
    String pwd =(String)session.getAttribute("password");
    String fname =(String)session.getAttribute("firstName");
    String lname =(String)session.getAttribute("lastName");
    String creditcard =(String)session.getAttribute("cardType");
    String cardnum =(String)session.getAttribute("cardNum");
    String book =(String)session.getAttribute("book");
    ArrayList previousItems = (ArrayList)session.getAttribute("previousItems");

    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    String title = " summarizes the items ordered.";
  
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=CENTER>" + title + "</H1>\n");
    out.println("User Name:" + id +"<br>");
    out.println("Pass Word:"+pwd+"<br>");
    out.println("First Name: " + fname+"<br>");
    out.println("Last Name:" + lname+"<br>");
    out.println("Credit Card:" + creditcard+"<br>");
    out.println("Card Number: " + cardnum+"<br>");
    out.println("Book Category: " + book+"<br>");
      for(int i=0; i<previousItems.size(); i++) {
          out.println("Book Ordered: " + (String)previousItems.get(i)+"<br>");
        }
    out.println("</BODY></HTML>");
  }



  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}

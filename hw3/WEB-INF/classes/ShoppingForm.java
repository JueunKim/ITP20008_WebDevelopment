package shopping;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingForm extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
      
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out   = response.getWriter();
    String actionURL  ="/servlet/shopping.ShoppingServlet";
    String userName  =CookieUtilities.getCookieValue(request, "userName", "abc");
    String password   = CookieUtilities.getCookieValue(request, "password", "123");
    String title = "Please Login";


    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
      out.println(docType +
       "<HTML>\n" +
       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
       "<CENTER>\n" +
       "<H1>" + title + "</H1>\n" +
       "<FORM ACTION=\"" + actionURL + "\">\n" +
       "User Name:\n" +
       "  <INPUT TYPE=\"TEXT\" NAME=\"userName\" " +
                 "VALUE=\"" + userName + "\"><BR>\n" +
       "Password:\n" +
       "  <INPUT TYPE=\"TEXT\" NAME=\"password\" " +
                        "VALUE=\"" + password + "\"><BR>\n" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"SUBMIT\">\n" +
       "</FORM></CENTER></BODY></HTML>");
  }
}

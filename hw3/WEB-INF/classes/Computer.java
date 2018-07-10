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

public class Computer extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
     String actionURL = "/servlet/shopping.Purchase";


        out.println(docType +
       "<HTML>\n" +
       "<HEAD><TITLE> Documentary Books </TITLE></HEAD>\n" +
       "<CENTER><BODY BGCOLOR=\"#FDF5E6\">Computer Books<br> \n" +
       "<INPUT TYPE=\"radio\" NAME=\"book\" VALUE=\"Database\" FORM=\"FORM_a\">Database Basic <br>" +
       "<INPUT TYPE=\"radio\" NAME=\"book\" VALUE=\"web\" FORM=\"FORM_a\">web development<br>" +
       "<INPUT TYPE=\"radio\" NAME=\"book\" VALUE=\"compiler\" FORM=\"FORM_a\">compiler principal<br>" +
       "<FORM NAME=\"Purchase\" ID=\"FORM_d\" ACTION= " + actionURL + "></FORM>\n" +
       //세션줘서 계속 구매할수있도록 하는 거 continue 버튼
       "<FORM NAME=\"Continue\" ID=\"FORM_a\" ACTION= \"/servlet/shopping.ShoppingServlet?userName=abc&password=123 \"></FORM>\n" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Continue\" FORM=\"FORM_a\">" +              
       "<a href= \"/servlet/shopping.ShoppingCookie\"><INPUT TYPE=\"BUTTON\" VALUE=\"Exit\"></a><BR>" +
       "<a href= \"/servlet/shopping.Purchase \"><INPUT TYPE=\"BUTTON\" VALUE=\"purchase\"></a>" +
       "</CENTER></BODY></HTML>");

  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}

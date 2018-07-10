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

public class ShoppingCookie extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String address = request.getParameter("address");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String cardType = request.getParameter("cardType");
    String cardNum = request.getParameter("cardNum");
    String book = request.getParameter("book");
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    String title = "The Contents of Cookies ";

    // String userName  =CookieUtilities.getCookieValue(request, "userName", "");
    lastName = CookieUtilities.getCookieValue(request, "cookielast", lastName);
    HttpSession session = request.getSession();
    ArrayList previousItems = (ArrayList)session.getAttribute("previousItems");

    Cookie caddress = new LongLivedCookie("Shippingddress",address);
    response.addCookie(caddress);
    Cookie ctype = new LongLivedCookie("CreditCard", cardType);
    response.addCookie(ctype);
    Cookie cnum = new LongLivedCookie("CreditCardNum", cardNum);
    response.addCookie(cnum);
    Cookie cookiefirst = new LongLivedCookie("First-Name", firstName);
    response.addCookie(cookiefirst);
    Cookie cookielast = new LongLivedCookie("Last-Name", lastName);
    response.addCookie(cookielast);
    
    session.setAttribute("cardType",cardType);
    session.setAttribute("cardNum",cardNum);
    session.setAttribute("firstName",firstName);
    session.setAttribute("lastName",lastName);
    session.setAttribute("book",book);

    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "  <TH>Cookie Name\n" +
                "  <TH>Cookie Value");

    Cookie[] cookies = request.getCookies();
    if (cookies == null) {
      out.println("<TR><TH COLSPAN=2>No cookies");
    } else {
      Cookie cookie;
      for(int i=0; i<cookies.length; i++) {
        cookie = cookies[i];
        if(!cookie.getValue().equals("") && !cookie.getName().equals("JSESSIONID")){
        out.println("<TR>\n" +
                    "  <TD>Cookie-" + cookie.getName() + "\n" +
                    "  <TD>Cookie-Value-" + cookie.getValue());}
                }
    }
    out.println("</TABLE></BODY></HTML>");

  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}

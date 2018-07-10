package shopping;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Continue extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
   
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String newItem = request.getParameter("book");
    String title = "Items Purchased";
    HttpSession session = request.getSession();
    ArrayList previousItems = (ArrayList)session.getAttribute("previousItems");
    if(newItem == null){
      out.println("Please select Item");
    }

    if (previousItems == null) {
      previousItems = new ArrayList();
      session.setAttribute("previousItems", previousItems);
    }

    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>" + title + "</H1>");
    synchronized(previousItems) {
      if ((newItem != null) &&
          (!newItem.trim().equals(""))) {
        previousItems.add(newItem);
      }
      if (previousItems.size() == 0) {
        out.println("<I>No items</I>");
      } else {
        out.println("<UL>");
        for(int i=0; i<previousItems.size(); i++) {
          out.println("<LI>" + (String)previousItems.get(i));
        }
        out.println("</UL>");
      }
    }
    out.println("</BODY></HTML>");
  }
}

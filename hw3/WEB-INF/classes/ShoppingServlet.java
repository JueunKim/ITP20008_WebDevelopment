package shopping;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ShoppingServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html");
    HttpSession session = request.getSession();
    PrintWriter out   = response.getWriter();
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String newItem = request.getParameter("book");
    String formAddress ="/servlet/shopping.ShoppingForm";
    String actionURL = "/servlet/shopping.ShoppingCookie";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    
    Cookie c4 = new LongLivedCookie("Documentary", newItem);
    response.addCookie(c4);
    
    session.setAttribute("userName",userName);
    session.setAttribute("password",password);
    session.setAttribute("book",newItem);
    ArrayList previousItems = (ArrayList)session.getAttribute("previousItems");
    

    if(newItem != null){
    if (previousItems == null) {
      previousItems = new ArrayList();
      session.setAttribute("previousItems", previousItems);
    }
     synchronized(previousItems) {
      if ((newItem != null) &&(!newItem.trim().equals(""))) {
        previousItems.add(newItem);
      }
      if (previousItems.size() == 0) {
        out.println("<No items>");
      } 
      else { }
    }      

        out.println(docType +
       "<HTML>\n" +
       "<HEAD><TITLE> Order </TITLE></HEAD>\n" +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
       "<FORM ID=\"FORM_A\" ACTION= " + actionURL + "></FORM>\n" +
       "<FORM ID=\"FORM_B\" ACTION= \"/servlet/shopping.Documentary\" NAME=\"documentary\" ></FORM>\n" +
       "<FORM ID=\"FORM_C\" ACTION= \"/servlet/shopping.Computer\" NAME=\"computer\"></FORM>\n" +
       "<FORM ID=\"FORM_D\" ACTION= \"/servlet/shopping.Travel\" NAME=\"travel\"></FORM>\n" +
  //     "<INPUT TYPE=\"hidden\" name=\"book\" VALUE="+ newItem +"FORM=\"FORM_A\">"+
       "Your address:\n" +
       "<INPUT TYPE=\"TEXT\" NAME=\"address\" VALUE=\"Handong Global University\" FORM=\"FORM_A\"><BR>\n" +
       "Frist Name:\n" +
       "<INPUT TYPE=\"TEXT\" NAME=\"firstName\" FORM=\"FORM_A\"><BR>\n" +
       "Last Name:\n" +
       "<INPUT TYPE=\"TEXT\" NAME=\"lastName\" FORM=\"FORM_A\"><BR><BR>\n" +
       "Credit Card : <BR><INPUT TYPE=\"RADIO\" NAME=\"cardType\" VALUE=\"VISA\" FORM=\"FORM_A\">VISA<BR>\n" +
       "<INPUT TYPE=\"RADIO\" NAME=\"cardType\" VALUE=\"MasterCard\" FORM=\"FORM_A\">MasterCard<BR>\n" +
       "<INPUT TYPE=\"RADIO\" NAME=\"cardType\" VALUE=\"BCcard\" FORM=\"FORM_A\">BCcard<BR><BR>\n" +
       "Credit Card Number : <br>" +
       "<INPUT TYPE=\"PASSWORD\" NAME=\"cardNum\" FORM=\"FORM_A\"><BR>"+
       "Choose Book Category <BR><BR>" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Documentary\" NAME=\"Documentary\" FORM=\"FORM_B\">" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Computer\" NAME=\"Computer\" FORM=\"FORM_C\">" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Travel\" NAME=\"Travel\" FORM=\"FORM_D\"> <BR><BR>" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Exit\" FORM=\"FORM_A\">" +
       "</CENTER></BODY></HTML>");


  }else{
    if(userName.equals("abc")&&password.equals("123")){
      
      out.println(docType +
       "<HTML>\n" +
       "<HEAD><TITLE> Order </TITLE></HEAD>\n" +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
       "<FORM ID=\"FORM_A\" ACTION= " + actionURL + "></FORM>\n" +
       "<FORM ID=\"FORM_B\" ACTION= \"/servlet/shopping.Documentary\" NAME=\"documentary\" ></FORM>\n" +
       "<FORM ID=\"FORM_C\" ACTION= \"/servlet/shopping.Computer\" NAME=\"computer\"></FORM>\n" +
       "<FORM ID=\"FORM_D\" ACTION= \"/servlet/shopping.Travel\" NAME=\"travel\"></FORM>\n" +
       "Your address:\n" +
       "<INPUT TYPE=\"TEXT\" NAME=\"address\" VALUE=\"Handong Global University\" FORM=\"FORM_A\"><BR>\n" +
       "Frist Name:\n" +
       "<INPUT TYPE=\"TEXT\" NAME=\"firstName\" FORM=\"FORM_A\"><BR>\n" +
       "Last Name:\n" +
       "<INPUT TYPE=\"TEXT\" NAME=\"lastName\" FORM=\"FORM_A\"><BR><BR>\n" +
       "Credit Card : <BR><INPUT TYPE=\"RADIO\" NAME=\"cardType\" VALUE=\"VISA\" FORM=\"FORM_A\">VISA<BR>\n" +
       "<INPUT TYPE=\"RADIO\" NAME=\"cardType\" VALUE=\"MasterCard\" FORM=\"FORM_A\">MasterCard<BR>\n" +
       "<INPUT TYPE=\"RADIO\" NAME=\"cardType\" VALUE=\"BCcard\" FORM=\"FORM_A\">BCcard<BR><BR>\n" +
       "Credit Card Number : <br>" +
       "<INPUT TYPE=\"PASSWORD\" NAME=\"cardNum\" FORM=\"FORM_A\"><BR>"+
       "Choose Book Category <BR><BR>" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Documentary\" NAME=\"Documentary\" FORM=\"FORM_B\">" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Computer\" NAME=\"Computer\" FORM=\"FORM_C\">" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Travel\" NAME=\"Travel\" FORM=\"FORM_D\"> <BR><BR>" +
       "<INPUT TYPE=\"SUBMIT\" VALUE=\"Exit\" FORM=\"FORM_A\">" +
       "</CENTER></BODY></HTML>");
    }
     else{

      out.println(docType +
       "<HTML>\n" +
       "<HEAD><TITLE> error </TITLE></HEAD>\n" +
       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
       "<CENTER>\n" +
       "<H1> Wrong Password or Username Try again </H1>\n" +
       "<FORM ACTION=\"" + formAddress + "\">\n" +
       "<INPUT TYPE=\"BUTTON\" VALUE=\"RETURN\" onclick=\"location.href='http://localhost:8080/servlet/shopping.ShoppingForm'\">\n" +
       "</FORM></CENTER></BODY></HTML>");
  }

}}

}

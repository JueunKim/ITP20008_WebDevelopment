<%@ page contentType="text/html;charset=KSC5601" import="java.sql.*" %>
<HTML>
<HEAD><TITLE>Rent-Car Inventory System</TITLE></HEAD>


<BODY>
<CENTER>
	<H3>Inclusion of an Item</H3>

<% 
	
	String rNo=request.getParameter("NO");
	String rName=request.getParameter("NAME");
	String rLocation=request.getParameter("LOCATION");
	String rQuantity=request.getParameter("QUANTITY");
	
	String DB_URL = "jdbc:mysql://localhost/test";
	String DB_USER = "root";
	String DB_PASSWORD= "21000172";

	Connection conn;
	Statement stmt;

	String query = "INSERT INTO rentcar VALUES('"+rNo+"','"+rName+"','"+rLocation+"','"+rQuantity+"','"+0+"')";

	try {
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
		stmt.executeUpdate(query);
		
		out.println("<P>");
		out.println("The following item has been included.");
		out.println("<P>");

		stmt.close();
		conn.close();
	} catch(Exception e){e.printStackTrace();}
%>

<jsp:useBean id="entry" class="RentInventory.RentBean"/>
<jsp:setProperty name ="entry" property="itemNum" param="NO"/>
<jsp:setProperty name ="entry" property="itemName" param="NAME"/>
<jsp:setProperty name ="entry" property="location" param="LOCATION"/>
<jsp:setProperty name ="entry" property="quantity" param="QUANTITY"/>

<TABLE width=500>
<TR BGCOLOR="#BE81F7">
				<TH><FONT COLOR=WHITE >Item #</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Name</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Location</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Quantity</FONT></TH>
</TR>

<TR ALIGN="CENTER">
  <TD WIDTH="100" HEIGHT="80"><jsp:getProperty name="entry" property="itemNum" />
  <TD WIDTH="100" HEIGHT="80"><jsp:getProperty name="entry" property="itemName" />
  <TD WIDTH="100" HEIGHT="80"><jsp:getProperty name="entry" property="location" />
  <TD WIDTH="100" HEIGHT="80"><jsp:getProperty name="entry" property="quantity" />
</TABLE>       

<FORM >
  <input type="button" value="Go&nbsp;to&nbsp;main&nbsp;page." onclick="location.href='MainControl.jsp' ">
</FORM>     
</CENTER>
</BODY>
</HTML>
<%@ page contentType="text/html;charset=KSC5601" import="java.sql.*"%>

<HTML>
<HEAD><TITLE>Rent-Car Inventory System</TITLE></HEAD>
<BODY>

<CENTER>
<H2>Deletion of Inventory Items</H2>
<P>
<HR>
<TABLE width=500>
	<TR BGCOLOR="#BE81F7">
		<TH><FONT COLOR=WHITE >Item #</FONT></TH>
		<TH><FONT COLOR=WHITE SIZE=2>Name</FONT></TH>
		<TH><FONT COLOR=WHITE SIZE=2>Location</FONT></TH>
	</TR>
<%
	String[] en=request.getParameterValues("cb");
	String query;
	String query2;

	String DB_URL = "jdbc:mysql://localhost/test";
	String DB_USER = "root";
	String DB_PASSWORD= "21000172";
	
	Connection conn;
	Statement stmt;
	ResultSet result=null;	

	for(int i=0;i<en.length; i++){
	try {
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
		query2 = "SELECT NO, NAME, LOCATION FROM RENTCAR WHERE NO ='"+en[i]+"' ";
		result = stmt.executeQuery(query2);

		if(result.next()) {		
%>

		<TR>
			<TD ALIGN=CENTER><FONT COLOR=GREEN ><%=result.getInt("NO") %></FONT></TD>	
			<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("NAME") %></FONT></TD>	
			<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("LOCATION") %></FONT></TD>
		</TR>
		
<%
		}
	
		result.close();
		stmt.close();
		conn.close();
	} catch(Exception e){e.printStackTrace();}
}

	try {
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
	
		for(int j=0; j<en.length; j++){
			query = "DELETE FROM RENTCAR WHERE NO='"+en[j]+"'";
			stmt.executeUpdate(query);
		}

		result.close();
		stmt.close();
		conn.close();
			
	} catch(Exception e){e.printStackTrace();}
%>

</TABLE>
<HR>
The above selected items has been deleted!<BR>

<FORM>
<input type="button" value="Go&nbsp;to&nbsp;main&nbsp;page." onclick="location.href='MainControl.jsp' ">
</FORM>

<P>
<HR>

</CENTER>

</BODY>
</HTML>
<%@ page contentType="text/html;charset=KSC5601" import="java.sql.*"%>

<HTML>
<HEAD><TITLE>Rent-Car Inventory System</TITLE></HEAD>
<BODY>

<CENTER><H3>Rent-Car Inventory Listing</H3>
<HR>

<%
	String DB_URL = "jdbc:mysql://localhost/test";
	String DB_USER = "root";
	String DB_PASSWORD= "21000172";

	Connection conn;
	Statement stmt;
	ResultSet result=null;	
	
	String query = "SELECT * FROM RENTCAR";

	try {
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
		result = stmt.executeQuery(query);
		
		int i=0;
%>	
	<FORM method=post action="Rent.jsp">

		<TABLE width=500>
			<TR BGCOLOR="#BE81F7">
				<TH><FONT COLOR=WHITE SIZE=2>Rent</FONT></TH>
				<TH><FONT COLOR=WHITE >Item #</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Name</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Location</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Quantity</FONT></TH>
				
			</TR>
<%
		while (result.next()) {		
%>
			<TR>
				<TD ALIGN=CENTER><input type=checkbox name=cb value="<%=result.getInt("NO")%>"></TD>
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%=result.getInt("NO") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("NAME") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("LOCATION") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getInt("QUANTITY") %></FONT></TD>
		    </TR>		
<%
			i++;
		}
%>
		</TABLE>
		<HR>
		<TABLE>
			<TR>
				<TD>	
					<input type=submit style=width:100;height:20 value=Rent>
					</FORM>
				</TD>
		</TABLE><P>
		<FORM>
		<input type="button" value="Addition&nbsp;to&nbsp;Inventory." onclick="location.href='IncludeInventory.jsp' ">
		</FORM>
				
<%		
		result.close();
		stmt.close();
		conn.close();
	} catch(Exception e){e.printStackTrace();}
%>
<HR>
<%

	try {
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
		result = stmt.executeQuery(query);
		
		int i=0;
%>	
	<FORM method=post action="Return.jsp">

		<TABLE width=500>
			<TR BGCOLOR="#BE81F7">
				<TH><FONT COLOR=WHITE SIZE=2>Return</FONT></TH>
				<TH><FONT COLOR=WHITE >Item #</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Name</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Location</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Quantity</FONT></TH>
			</TR>
<%
		while (result.next()) {		
%>
			<TR>
				<TD ALIGN=CENTER><input type=checkbox name=cb value="<%=result.getInt("NO")%>"></TD>
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%=result.getInt("NO") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("NAME") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("LOCATION") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getInt("QUANTITY") %></FONT></TD>
		    </TR>		
<%
			i++;
		}
%>
		</TABLE>
		<HR>
		<TABLE>
			<TR>
				<TD>
				<input type=submit style=width:100;height:20 value=Return >
				</FORM>
				</TD>
		</TABLE><P>
				
<%	
		result.close();
		stmt.close();
		conn.close();
	} catch(Exception e){e.printStackTrace();}
%>
<HR>
<%

	try {
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
		result = stmt.executeQuery(query);
		
		int i=0;
%>	
	<FORM method=post action="DeleteInventory.jsp">

		<TABLE width=500>
			<TR BGCOLOR="#BE81F7">
				<TH><FONT COLOR=WHITE SIZE=2>Deletion</FONT></TH>
				<TH><FONT COLOR=WHITE >Item #</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Name</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Location</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Quantity</FONT></TH>
			</TR>
<%
		while (result.next()) {		
%>
			<TR>
				<TD ALIGN=CENTER><input type=checkbox name=cb value="<%=result.getInt("NO")%>"></TD>
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%=result.getInt("NO") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("NAME") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("LOCATION") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getInt("QUANTITY") %></FONT></TD>
		    </TR>		
<%
			i++;
		}
%>
		</TABLE>
		<HR>
		<TABLE>
			<TR>
				<TD>
					<input type=submit style=width:100;height:20 value=Deletion>
					</FORM>
				</TD>
		</TABLE><P>

<%		
		result.close();
		stmt.close();
		conn.close();
	} catch(Exception e){e.printStackTrace();}
%>
<HR>
<%


	try {
		Class.forName("org.gjt.mm.mysql.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
		result = stmt.executeQuery(query);
		
		int i=0;
%>	
	<FORM method=post action="Sale.jsp">

		<TABLE width=500>
			<TR BGCOLOR="#BE81F7">
				<TH><FONT COLOR=WHITE SIZE=2>Sale</FONT></TH>
				<TH><FONT COLOR=WHITE >Item #</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Name</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Location</FONT></TH>
				<TH><FONT COLOR=WHITE SIZE=2>Quantity</FONT></TH>

			</TR>
<%
		while (result.next()) {		
%>
			<TR>
				<TD ALIGN=CENTER><input type=checkbox name=cb value="<%=result.getInt("NO")%>"></TD>
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%=result.getInt("NO") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("NAME") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getString("LOCATION") %></FONT></TD>	
				<TD ALIGN=CENTER><FONT COLOR=GREEN ><%= result.getInt("QUANTITY") %></FONT></TD>
		    </TR>		
<%
			i++;
		}
%>
		</TABLE>
		<HR>
		<TABLE>
			<TR></TR>
			<TR>
				<TD>
					
					<input type=submit style=width:100;height:20 value=Sale >
					</FORM>
		</TABLE><P>

<%		
		result.close();
		stmt.close();
		conn.close();
	} catch(Exception e){e.printStackTrace();}
%>

<HR>
</CENTER>
</BODY>
</HTML>
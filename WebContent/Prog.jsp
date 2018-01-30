<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="metier.Epreuve" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
    td
    {
        border: 1px solid black;
    }
</style>



  <%
		ArrayList<Epreuve> l = new ArrayList<Epreuve>();
		if(request.getAttribute("Programme") != null){
			l = (ArrayList)request.getAttribute("Programme");
		}
	%>
	
	<%
	if(l.size() > 0)	{
		%>
<table style="border-collapse: collapse;" border="2"  width="60%" align="center" BGCOLOR="#fdd8d4">
<thead>
    <tr>
            <th style="min-width: 85px; max-width: 85px; background: #ecece6;">Jour</th>
        <th style="min-width: 85px; max-width: 85px; background: #ecece6;">Horaires</th>
<th style="min-width: 85px; max-width: 85px; background: #ecece6;">Matiere</th>
<!--         <th style="min-width: 85px; max-width: 85px; background: #ecece6;">Mardi</th> -->
<!--         <th style="min-width: 85px; max-width: 85px; background: #ecece6;">Mercredi</th> -->
<!--         <th style="min-width: 85px; max-width: 85px; background: #ecece6;">Jeudi</th> -->
<!--         <th style="min-width: 85px; max-width: 85px; background: #ecece6;">Vendredi</th> -->
<!--          <th style="min-width: 85px; max-width: 85px; background: #ecece6;">Samedi</th> -->
    </tr>
   
     </thead>
	<tbody>	
		<%
			for(int i = 0; i < l.size() ; i++){
				%>
    <tr>
        <td ><%= l.get(i).getJour() %></td>
        <td ><%= l.get(i).getPlageHoraire() %> </td>
        <td ><%= l.get(i).getEpreuve()%></td>
          
<!--         <td ></td> -->
<!--         <td ></td> -->
<!--         <td ></td> -->
<!--         <td ></td> -->
<!--         <td ></td> -->

    </tr>

         <%
			}
		%>
</tbody>
</table>
	<%
		
	}else{
		%>
		<h2> La table est vide </h2>
	<%
	}
	%>
</body>
</html>
<%@ page session="false" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.co.luciditysoftware.campervibe.domain.entities.Booking" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    @SuppressWarnings("unchecked")
    ArrayList<Booking> bookingDatabase =
            (ArrayList<Booking>)request.getAttribute("bookingDatabase");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${"Booking List"}</h1>
	
	<a href="<c:url value="booking">
            <c:param name="action" value="make" />
        </c:url>">Create Ticket</a>
        <br /><br />
        <p>Records: ${bookingDatabase.size() }
        <table>
        	<thead>
        		<tr>
	        		<th>Booking Number</th>
	        		<th>Start Date</th>
	        		<th>End Date</th>
	        		<th>Bus</th>
	        		<th></th>
        		</tr>
        	</thead>
		    <c:forEach items="${bookingDatabase}" var="b">
		    	<tr>
			    	<td>
			    		<c:out value="${b.bookingNumber}"/>
		    		</td>
		    		<td>
		    			<fmt:formatDate value="${b.startDate}" type="date" dateStyle="long" />
		    		</td>
		    		<td>
		    			<fmt:formatDate value="${b.endDate}" type="date" dateStyle="long" />
		    		</td>
		    		<td>
		    			${b.vehicle.name} 
		    		</td>
		    		<td>
		    			<a href="<c:url value="/booking/view">
							<c:param name="bookingId" value="${b.id}" />
						</c:url>">View</a>
		    		</td>
	    		</tr>
			</c:forEach>
		</table>
		
		
</body>
</html>
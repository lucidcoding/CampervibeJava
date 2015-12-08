<%@ page session="false" %>
<%@ page import="java.util.Map, java.util.UUID" %>
<%@ page import="uk.co.luciditysoftware.campervibe.domain.entities.Booking" %>

<%
    @SuppressWarnings("unchecked")
    Map<UUID, Booking> bookingDatabase =
            (Map<UUID, Booking>)request.getAttribute("bookingDatabase");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Booking List</h1>
	
	<a href="<c:url value="booking">
            <c:param name="action" value="make" />
        </c:url>">Create Ticket</a>
        <br /><br />
        <%
            if(bookingDatabase.size() == 0)
            {
                %><i>There are no tickets in the system.</i><%
            }
            else
            {
                for(UUID id : bookingDatabase.keySet())
                {
                    String idString = id.toString();
                    Booking booking = bookingDatabase.get(id);
                    %>Ticket #<%= idString %>: <a href="<c:url value="/tickets">
                        <c:param name="action" value="view" />
                        <c:param name="bookingId" value="<%= idString %>" />
                    </c:url>"><%= booking.getBookingNumber() %>
                    </a><br /><%
                }
            }
        %>
        
</body>
</html>
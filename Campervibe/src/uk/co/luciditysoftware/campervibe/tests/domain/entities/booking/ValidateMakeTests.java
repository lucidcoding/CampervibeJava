package uk.co.luciditysoftware.campervibe.tests.domain.entities.booking;

import static org.junit.Assert.*;

import java.text.*;
import java.util.*;
import org.junit.*;
import uk.co.luciditysoftware.campervibe.domain.requests.booking.*;
import uk.co.luciditysoftware.campervibe.domain.entities.*;
import uk.co.luciditysoftware.campervibe.domain.common.*;

public class ValidateMakeTests 
{
	@Test
	public void ValidRequestPasses() throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		//Arrange.
		/*
        Customer customer = new Customer()
        {
            Id = Guid.NewGuid(),
            FamilyName = "Blue"
        };
		*/
		
		Vehicle vehicle = new Vehicle();
		/*{{ 
            //Id = Guid.NewGuid()
        }};*/

        List<Booking> bookings = new ArrayList<Booking>();
        
        bookings.add(new Booking() 
        {{
            setStartDate(dateFormat.parse("01-09-2050 00:00:00"));
            setEndDate(dateFormat.parse("03-09-2050 00:00:00"));
            setVehicle(vehicle);
        }});

        vehicle.setBookings(bookings);
		MakeRequest request = new MakeRequest();
        //request.Customer = customer;
        request.setStartDate(dateFormat.parse("01-10-2050 00:00:00"));
        request.setEndDate(dateFormat.parse("01-10-2050 00:00:00"));
        request.setVehicle(vehicle);

        //Act.
        List<ValidationMessage> validationMessages = Booking.validateMake(request);
        
        //Assert.
        assertEquals(0, validationMessages.size());
    }

    @Test
    public void InvalidRequestFails() throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

    	/*
        Customer customer = new Customer()
        {
            Id = Guid.NewGuid(),
            FamilyName = "Blue"
        };
		*/
    	
    	Vehicle vehicle = new Vehicle();
        List<Booking> bookings = new ArrayList<Booking>();
        
        bookings.add(new Booking()
        {{
            setStartDate(dateFormat.parse("30-09-2050 00:00:00"));
            setEndDate(dateFormat.parse("02-10-2050 00:00:00"));
            setVehicle(vehicle);
        }});

    	vehicle.setBookings(bookings);
    	MakeRequest request = new MakeRequest();
        //request.setCustomer = customer;
        request.setStartDate(dateFormat.parse("01-10-2050 00:00:00"));
        request.setEndDate(dateFormat.parse("03-10-2050 00:00:00"));
        request.setVehicle(vehicle);

        List<ValidationMessage> validationMessages = Booking.validateMake(request);

        assertEquals(1, validationMessages.size());
        assertTrue(validationMessages.stream().anyMatch(x -> x.getText().equals("Booking conflicts with existing bookings.")));
    }
}

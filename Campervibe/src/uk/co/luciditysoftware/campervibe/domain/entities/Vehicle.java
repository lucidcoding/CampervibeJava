package uk.co.luciditysoftware.campervibe.domain.entities;

import java.math.BigDecimal;
import java.util.Currency;

public class Vehicle {
	private String name;
	private String registrationNumber;
	private String make;
	private String model;
	private BigDecimal pricePerDay;
	private Depot homeDepot;
	//private String ICollection<Booking> Bookings { get; set; }

    //public virtual VehicleStatus Status { get; set; }

    /*public decimal? Mileage
    {
        get
        {
            return Bookings.Any() ? Bookings.Max(booking => booking.EndMileage) : null;
        }
    }

    */
    
    public virtual IList<Booking> GetConflictingBookings(DateTime startDate, DateTime endDate)
    {
        return Bookings.Where(booking =>
            (startDate >= booking.StartDate && startDate < booking.EndDate)
            || (endDate > booking.StartDate && endDate <= booking.EndDate)
            || (startDate <= booking.StartDate && endDate >= booking.EndDate))
            .ToList();
    }
}
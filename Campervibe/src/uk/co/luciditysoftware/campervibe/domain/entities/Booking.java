package uk.co.luciditysoftware.campervibe.domain.entities;

import java.util.Date;
import java.math.BigDecimal;
//import java.util.Currency;

public class Booking 
{
	private String bookingNumber;
	private Date startDate;
	private Date endDate;
	private BigDecimal startMileage;
	private BigDecimal endMileage;
	private Vehicle vehicle;
	//private Customer Customer { get; set; }
	private Date collectedOn;
	private Date returnedOn;
	private BigDecimal total;
	
	public String getBookingNumber() 
	{
		return bookingNumber;
	}
	
	public void setBookingNumber(String bookingNumber) 
	{
		this.bookingNumber = bookingNumber;
	}
	
	public Date getStartDate() 
	{
		return startDate;
	}
	
	public void setStartDate(Date startDate) 
	{
		this.startDate = startDate;
	}
	
	public Date getEndDate() 
	{
		return endDate;
	}
	
	public void setEndDate(Date endDate) 
	{
		this.endDate = endDate;
	}
	
	public BigDecimal getStartMileage() 
	{
		return startMileage;
	}
	
	public void setStartMileage(BigDecimal startMileage) 
	{
		this.startMileage = startMileage;
	}
	
	public BigDecimal getEndMileage() 
	{
		return endMileage;
	}
	
	public void setEndMileage(BigDecimal endMileage) 
	{
		this.endMileage = endMileage;
	}
	
	public Vehicle getVehicle() 
	{
		return vehicle;
	}
	
	public void setVehicle(Vehicle vehicle) 
	{
		this.vehicle = vehicle;
	}
	
	public Date getCollectedOn() 
	{
		return collectedOn;
	}
	
	public void setCollectedOn(Date collectedOn) 
	{
		this.collectedOn = collectedOn;
	}
	
	public Date getReturnedOn() 
	{
		return returnedOn;
	}
	
	public void setReturnedOn(Date returnedOn) 
	{
		this.returnedOn = returnedOn;
	}
	
	public BigDecimal getTotal() 
	{
		return total;
	}
	
	public void setTotal(BigDecimal total) 
	{
		this.total = total;
	}
}

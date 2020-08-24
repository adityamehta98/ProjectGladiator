package dao;

import java.util.List;
import model.*;

public interface VehicleDAO
{
	public List<Vehicle> findAll();
	public Vehicle findVehicleByUserId(int vehicleid);
	public Vehicle findVehicleByLoanID(int vehicleid);

}
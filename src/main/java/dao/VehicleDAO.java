package dao;

import java.util.List;
import model.*;

public interface VehicleDAO
{
	public List<Vehicle> findAll();
	public User findVehicleByUserId(int userid);
	public Loan findVehicleByLoanID(int loanid);

}
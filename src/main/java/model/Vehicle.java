package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class Vehicle implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 3535245312946838477L;

	//	vehicle_id, vehicle_make, vehicle_model, vehicle_type (two_wheeler/ four_wheeler/etc.), 
//	vehicle name, ex_showroom_price, on_road_price
	@Id
	@Column(name="vehicle_id")
	@NonNull
	private int vehicleid;
	
	@Column(name="vehicle_type")
	private String vehicletype;
	
	@Column(name="vehicle_name")
	private String vehiclename;
	
	@Column(name="vehicle_model")
	private String vehiclemodel;
	
	@Column(name="ex_showroom_price")
	private String exshowroomprice;
	
	@Column(name="on_road_price")
	private String onroadprice;
	
	@OneToOne
	private Vehicle loanid;
	
	@ManyToOne
	private Vehicle accountnumber;
	
	@ManyToOne
	private Vehicle userid;
	
	public Vehicle() {}
	
	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public String getVehiclemodel() {
		return vehiclemodel;
	}

	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public String getExshowroomprice() {
		return exshowroomprice;
	}

	public void setExshowroomprice(String exshowroomprice) {
		this.exshowroomprice = exshowroomprice;
	}

	public String getOnroadprice() {
		return onroadprice;
	}

	public void setOnroadprice(String onroadprice) {
		this.onroadprice = onroadprice;
	}

	public Vehicle getLoanid() {
		return loanid;
	}

	public void setLoanid(Vehicle loanid) {
		this.loanid = loanid;
	}

	public Vehicle getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(Vehicle accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Vehicle getUserid() {
		return userid;
	}

	public void setUserid(Vehicle userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "User [Vehicle ID=" + vehicleid + ", Vehicle Type=" + vehicletype + ", Vehicle Name=" + vehiclename + ", Vehicle Model=" + vehiclemodel + ", Ex Showroom Price=" + exshowroomprice + ", On Road Price=" + onroadprice + ", Loan ID=" + loanid + ", Account Number=" + accountnumber + ",]";
	}
}
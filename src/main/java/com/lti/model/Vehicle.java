package com.lti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the VEHICLE database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEHICLE_ID")
	private String vehicleId;

	@Column(name="EX_SHOWROOM_PRICE")
	private float exShowroomPrice;

	@Column(name="ON_ROAD_PRICE")
	private float onRoadPrice;

	@Column(name="VEHICLE_COLOUR", length=30)
	private String vehicleColour;

	@Column(name="VEHICLE_NAME", length=30)
	private String vehicleName;
	
	@Column(name="VEHICLE_MODEL", length=30)
	private String vehicleModel;

	@Column(name="VEHICLE_TYPE", length=30)
	private String vehicleType;

	@Column(name="VEHICLE_YEAR")
	private long vehicleYear;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="vehicle")
	private List<Loan> loans;

	public Vehicle() {
	}
	
	public String getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}


	public float getExShowroomPrice() {
		return exShowroomPrice;
	}


	public void setExShowroomPrice(float exShowroomPrice) {
		this.exShowroomPrice = exShowroomPrice;
	}


	public float getOnRoadPrice() {
		return onRoadPrice;
	}


	public void setOnRoadPrice(float onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}


	public String getVehicleColour() {
		return vehicleColour;
	}


	public void setVehicleColour(String vehicleColour) {
		this.vehicleColour = vehicleColour;
	}


	public String getVehicleName() {
		return vehicleName;
	}


	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public String getVehicleModel() {
		return vehicleModel;
	}


	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public long getVehicleYear() {
		return vehicleYear;
	}


	public void setVehicleYear(long vehicleYear) {
		this.vehicleYear = vehicleYear;
	}


	public List<Loan> getLoans() {
		return loans;
	}


	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}


	public Loan addLoan(Loan loan) {
		getLoans().add(loan);
		loan.setVehicle(this);

		return loan;
	}

	public Loan removeLoan(Loan loan) {
		getLoans().remove(loan);
		loan.setVehicle(null);

		return loan;
	}

}
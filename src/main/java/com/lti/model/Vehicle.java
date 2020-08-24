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
	private long vehicleId;

	@Column(name="EX_SHOWROOM_PRICE")
	private BigDecimal exShowroomPrice;

	@Column(name="ON_ROAD_PRICE")
	private BigDecimal onRoadPrice;

	@Column(name="VEHICLE_COLOUR", length=30)
	private String vehicleColour;

	@Column(name="VEHICLE_MAKE", length=30)
	private String vehicleMake;

	@Column(name="VEHICLE_MODEL", length=30)
	private String vehicleModel;

	@Column(name="VEHICLE_TYPE", length=30)
	private String vehicleType;

	@Column(name="VEHICLE_YEAR")
	private BigDecimal vehicleYear;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="vehicle")
	private List<Loan> loans;

	public Vehicle() {
	}

	public long getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public BigDecimal getExShowroomPrice() {
		return this.exShowroomPrice;
	}

	public void setExShowroomPrice(BigDecimal exShowroomPrice) {
		this.exShowroomPrice = exShowroomPrice;
	}

	public BigDecimal getOnRoadPrice() {
		return this.onRoadPrice;
	}

	public void setOnRoadPrice(BigDecimal onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}

	public String getVehicleColour() {
		return this.vehicleColour;
	}

	public void setVehicleColour(String vehicleColour) {
		this.vehicleColour = vehicleColour;
	}

	public String getVehicleMake() {
		return this.vehicleMake;
	}

	public void setVehicleMake(String vehicleMake) {
		this.vehicleMake = vehicleMake;
	}

	public String getVehicleModel() {
		return this.vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public BigDecimal getVehicleYear() {
		return this.vehicleYear;
	}

	public void setVehicleYear(BigDecimal vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public List<Loan> getLoans() {
		return this.loans;
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
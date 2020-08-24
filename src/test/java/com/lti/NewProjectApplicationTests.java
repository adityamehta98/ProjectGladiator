package com.lti;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import com.lti.model.*;
import com.lti.repo.RepositoryInterface;


@SpringBootTest(classes=VehicleLoanApplication.class)
//@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class NewProjectApplicationTests {
	
	@Autowired
	private RepositoryInterface repo;
	
	@Test
	void registerUser() {
		
		UserTable user=new UserTable();
		user.setUserId(1);
		user.setUserNameFirst("Adi");
		user.setUserNameLast("Mehta");
		user.setUserNameMiddle("");
		user.setUserAge(BigDecimal.valueOf(21));
		user.setUserGender("Male");
		user.setUserAddress("221B Bakers street");
		user.setUserEmail("adya@gmail.com");
		user.setUserPass("Aditya@123");
		user.setUserZip("302001");
		user.setUserType("New");
		repo.registerUser(user);
	}
	
	@Test
	void registerAdmin() {
		Admin admin = new Admin();
		admin.setAdminId(1001);
		admin.setAdminEmail("kavaK@gmail.com");
		admin.setAdminNameFirst("KavitaJi");
		admin.setAdminNameLast("Karki");
		admin.setAdminGender("Female");
		admin.setAdminPass("abcd1234");
		admin.setAdminAge(BigDecimal.valueOf(21));
		System.out.println(repo.registerAdmin(admin));
	}
	
	
	@Test
	void registerAccount() {
		Account account= new Account();
		account.setAccNumber("DCYGR234235");
		account.setAccBankName("HDFC");
		account.setAccIfsc("HDF1344");
		account.setAccType("Corporate");
		account.setSalary(BigDecimal.valueOf(50000));
		account.setExisitingEmi(BigDecimal.valueOf(2));
		account.setUserEmploymentType("Salaried");
		account.setMonthlySavings(BigDecimal.valueOf(20000));
		System.out.println(repo.registerAccount(account));
	}
	
	@Test
	void registerLoan() {
		Loan loan=new Loan();
		loan.setLoanId(1);
		loan.setLoanAmount(BigDecimal.valueOf(50000));
		loan.setInterestRate(BigDecimal.valueOf(9));
		loan.setProcessingFee(BigDecimal.valueOf(1000));
		loan.setEmi(BigDecimal.valueOf(5000));
		loan.setTenure(BigDecimal.valueOf(36));
		loan.setApplicationStatus("Complete");
		loan.setLoanStatus("New");
		loan.setLoanStartDate(Date.valueOf("2018-09-12"));
		loan.setLoanEndDate(Date.valueOf("2021-09-12"));
		System.out.println(repo.registerLoan(loan));
	}
	
	@Test
	void registerVehicle() {
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleId(21234164);
		vehicle.setVehicleMake("Maruti Suzuki Swift");
		vehicle.setVehicleModel("VXI");
		vehicle.setVehicleType("Car");
		vehicle.setVehicleYear(BigDecimal.valueOf(700000));
		vehicle.setVehicleColour("Navy Blue");
		vehicle.setExShowroomPrice(BigDecimal.valueOf(700000));
		vehicle.setOnRoadPrice(BigDecimal.valueOf(760000));
		System.out.println(repo.registerVehicle(vehicle));
	}
}
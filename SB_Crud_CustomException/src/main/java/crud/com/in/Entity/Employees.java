package crud.com.in.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name="Employees_Details")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String city;
	private Long phoNo;
	private Long salary;
	private int pincode;
	
	
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employees(Integer id, String name, String city, Long phoNo, Long salary, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.phoNo = phoNo;
		this.salary = salary;
		this.pincode = pincode;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Long getPhoNo() {
		return phoNo;
	}


	public void setPhoNo(Long phoNo) {
		this.phoNo = phoNo;
	}


	public Long getSalary() {
		return salary;
	}


	public void setSalary(Long salary) {
		this.salary = salary;
	}


	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	
		
	
	
}

package crud.com.in.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import crud.com.in.Entity.Employees;

public interface EmployeesRepositery extends JpaRepository<Employees, Integer>{

}

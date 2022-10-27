package com.nestdigital.office.dao;

import com.nestdigital.office.model.OfficeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficeDao extends CrudRepository<OfficeModel,Integer> {
    @Query (value = "SELECT `id`, `emp_dateofjoin`, `emp_dob`, `emp_email`, `employee_address`, `employee_id`, `employee_name`, `password`, `username` FROM `office_model` WHERE employee_id=:employee_id",nativeQuery = true)
    List<OfficeModel>searchEmployee(Integer employee_id);
    @Modifying
    @Query(value = "UPDATE `office_model` SET `emp_dateofjoin`=:emp_dateofjoin,`emp_dob`=:emp_dob,`emp_email`=:emp_email,`employee_address`=:employee_address,`employee_id`=:employee_id,`employee_name`=:employee_name,`password`=:password,`username`=:username  WHERE id=:id",nativeQuery = true)
    void editEmployee(String emp_dateofjoin,String emp_dob,String emp_email,String employee_address,Integer employee_id,String employee_name,String password,String username,Integer id);
    @Modifying
    @Query(value = "DELETE FROM `office_model` WHERE employee_id=:employee_id",nativeQuery = true)
    void deleteEmployeeById(Integer employee_id);

    @Query(value = "SELECT `id`, `emp_dateofjoin`, `emp_dob`, `emp_email`, `employee_address`, `employee_id`, `employee_name`, `password`, `username` FROM `office_model` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<OfficeModel> login(String username,String password);
}

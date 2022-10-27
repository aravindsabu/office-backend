package com.nestdigital.office.controller;

import com.nestdigital.office.dao.OfficeDao;
import com.nestdigital.office.model.OfficeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class OfficeController {
    @Autowired
    private OfficeDao dao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public String addemployee(@RequestBody OfficeModel office){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentDate=String.valueOf(dt.format(now));
        office.setEmp_dateofjoin(currentDate);
        System.out.println(office.toString());
        dao.save(office);
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchEmployee",consumes = "application/json",produces = "application/json")
    public List searchEmployee(@RequestBody OfficeModel office){
        System.out.println(office.getEmployee_id());
        return(List<OfficeModel>)dao.searchEmployee(office.getEmployee_id());
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(value = "/editEmployee",consumes = "application/json",produces = "application/json")
    public String editEmployee(@RequestBody OfficeModel office){
        dao.editEmployee(office.getEmp_dateofjoin(),office.getEmp_dob(),office.getEmp_email(),office.getEmployee_address(),office.getEmployee_id(),office.getEmployee_name(),office.getPassword(),office.getUsername(),office.getId());
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path="deleteEmployee",consumes = "application/json",produces = "application/json")
    public String deleteEmployee(@RequestBody OfficeModel office){
        dao.deleteEmployeeById(office.getEmployee_id());
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewEmployee")
        public List<OfficeModel> viewEmployee(){
        return (List<OfficeModel>)dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<OfficeModel> login(@RequestBody OfficeModel office){
        return( List<OfficeModel>)dao.login(office.getUsername(),office.getPassword());

    }


}

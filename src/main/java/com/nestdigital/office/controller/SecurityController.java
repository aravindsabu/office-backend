package com.nestdigital.office.controller;

import com.nestdigital.office.dao.SecurityDao;
import com.nestdigital.office.model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController

public class SecurityController {
    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addSecurity",consumes = "application/json",produces = "application/json")
    public String addSecurity(@RequestBody SecurityModel security){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentDate=String.valueOf(dt.format(now));
        security.setDateofjoin(currentDate);
        System.out.println(security.toString());
        dao.save(security);
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchSecurity",consumes = "application/json",produces = "application/json")
    public List searchSecurity(@RequestBody SecurityModel security){
        System.out.println(security.getSecurity_code());
        return(List<SecurityModel>)dao.searchSecurity(security.getSecurity_code()) ;
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editSecurity",consumes = "application/json",produces = "application/json")
    public String editSecurity(@RequestBody SecurityModel security){
        dao.editSecurity(security.getAddress(),security.getDateofjoin(),security.getPassword(),security.getPhone_number(),security.getSecurity_code(),security.getSecurity_name(),security.getUsername(),security.getId());
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteSecurity",consumes = "application/json",produces = "application/json")
    public String deleteSecurity(@RequestBody SecurityModel security){
        dao.deleteSecurityById(security.getSecurity_code());
        return "(status:'success')";
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewSecurity")
    public List<SecurityModel>viewSecurity(){
        return (List<SecurityModel>) dao.findAll();
    }

}

package com.nestdigital.office.dao;

import com.nestdigital.office.model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {
    @Query(value = "SELECT `id`, `address`, `dateofjoin`, `password`, `phone_number`, `security_code`, `security_name`, `username` FROM `security_data` WHERE security_code=:security_code",nativeQuery = true)
    List<SecurityModel>searchSecurity(Integer security_code );

    @Modifying
    @Query(value = "UPDATE `security_data` SET `address`=:address,`dateofjoin`=:dateofjoin,`password`=:password,`phone_number`=:phone_number,`security_code`=:security_code,`security_name`=:security_name,`username`=:username WHERE id=:id",nativeQuery = true)
    void editSecurity(String address,String dateofjoin,String password,String phone_number,Integer security_code,String security_name,String username,Integer id);


    @Modifying
    @Query(value = "DELETE FROM `security_data` WHERE security_code=:security_code ",nativeQuery = true)
    void deleteSecurityById(Integer security_code);


    @Query(value = "SELECT `id`, `address`, `dateofjoin`, `password`, `phone_number`, `security_code`, `security_name`, `username` FROM `security_data` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<SecurityModel>loginSecurity(String username,String password );

}

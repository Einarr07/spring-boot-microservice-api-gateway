package com.einarr07.spring_boot_microservice_3_api_gateway.repository;

import com.einarr07.spring_boot_microservice_3_api_gateway.model.Role;
import com.einarr07.spring_boot_microservice_3_api_gateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //findBy + nombreCampo
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set role=:role where username=:username")
    void updateuserRole(@Param("username") String username, @Param("role") Role role);


}

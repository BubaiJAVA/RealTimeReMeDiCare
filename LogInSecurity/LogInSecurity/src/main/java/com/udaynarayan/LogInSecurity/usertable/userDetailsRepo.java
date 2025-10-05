package com.udaynarayan.LogInSecurity.usertable;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface userDetailsRepo extends JpaRepository<userdetails,Integer> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM userdetails u WHERE u.email = :mail")
    boolean findMailExistOrNot(@Param("mail") String email);


@Modifying
@Transactional
@Query("UPDATE userdetails u SET u.password = :pass WHERE u.email = :mail")
    int updateUpdatedPassword(@Param("mail") String email, @Param("pass") String password1);


    @Query("SELECT u FROM userdetails u WHERE u.username = :uname OR u.email = :uname")
    userdetails findUserDetails(@Param("uname") String username);
}

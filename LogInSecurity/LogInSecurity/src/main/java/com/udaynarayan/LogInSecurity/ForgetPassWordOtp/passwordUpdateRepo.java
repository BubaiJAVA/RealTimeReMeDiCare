package com.udaynarayan.LogInSecurity.ForgetPassWordOtp;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface passwordUpdateRepo extends JpaRepository<passwordupdate,Integer> {



    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM passwordupdate u WHERE u.email = :mail AND u.otp = :otpp")
    boolean checkUpdatePasswordOtp(@Param("mail") String email,@Param("otpp") int otp);

    @Modifying
    @Transactional
    @Query("DELETE FROM passwordupdate p WHERE p.email = :mail")
    int deleteVerifiedData(@Param("mail")String email);
}

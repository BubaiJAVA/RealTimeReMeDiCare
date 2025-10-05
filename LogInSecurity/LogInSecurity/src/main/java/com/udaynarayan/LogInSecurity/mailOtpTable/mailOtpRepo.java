package com.udaynarayan.LogInSecurity.mailOtpTable;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface mailOtpRepo extends JpaRepository<mailotpcheck,Integer> {
    @Query("SELECT COUNT(u) FROM mailotpcheck u WHERE u.email = :mail")
    int findMailUniqueOrNot(@Param("mail") String usermail);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM mailotpcheck u WHERE u.email = :mail AND u.otp = :otpp")

    boolean findingOtpValid(@Param("mail") String mail, @Param("otpp") int otp);

    @Transactional
    @Modifying
    @Query("UPDATE mailotpcheck m SET m.verify = 1 WHERE m.email = :mail")
    int updateVerifyColumn(@Param("mail") String mail);



    @Query("SELECT m.email FROM mailotpcheck m WHERE m.verify = :aa")
    List<String> gettingVerifiedMail(@Param("aa") int i);

//    @Query("SELECT m.email FROM mailotpheck m WHERE m.verify = :aa")
//    List<String> gettingVerifiedMail(@Param("aa") int a);

}

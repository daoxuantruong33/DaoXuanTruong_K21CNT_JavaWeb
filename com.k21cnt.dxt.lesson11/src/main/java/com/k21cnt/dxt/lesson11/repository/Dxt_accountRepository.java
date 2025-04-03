package com.k21cnt.dxt.lesson11.repository;
import com.k21cnt.dxt.lesson11.entity.Dxt_account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Dxt_accountRepository extends JpaRepository<Dxt_account, Long>{
}
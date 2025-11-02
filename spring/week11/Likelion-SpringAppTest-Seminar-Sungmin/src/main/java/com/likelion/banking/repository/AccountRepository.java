package com.likelion.banking.repository;

import com.likelion.banking.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * 계좌 정보를 관리하는 Repository 인터페이스
 * 
 * 실제 프로젝트에서는 JPA Repository나 JDBC를 사용하지만,
 * 테스트 실습을 위해 간단한 인터페이스로 구성했습니다.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Query("UPDATE Account a SET a.amount = :newAmount WHERE a.id = :id")
    default void changeAmount(@Param("id") Long id, @Param("newAmount") BigDecimal newAmount) {

    }
}
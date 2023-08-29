package com.john.codetest.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRecordRepository extends JpaRepository<com.john.codetest.models.EmailRecord, Long> {

}

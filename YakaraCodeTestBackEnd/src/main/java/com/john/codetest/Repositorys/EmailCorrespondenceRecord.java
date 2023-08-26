package com.john.codetest.Repositorys;

import com.john.codetest.models.EmailRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailCorrespondenceRecord extends JpaRepository<EmailRecord, Long> {

}

package com.example.TEST_CONVERTER.postgres.Repository;

import com.example.TEST_CONVERTER.postgres.Entity.NumbersData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersDataRepository extends JpaRepository<NumbersData, Long> {

    NumbersData findByName (String name);

    NumbersData findByNumber (Long number);
}

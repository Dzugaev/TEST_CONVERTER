package com.example.TEST_CONVERTER.postgres.Repository;

import com.example.TEST_CONVERTER.postgres.Entity.LogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogInfoRepository extends JpaRepository<LogInfo, Long> {
}

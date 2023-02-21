package com.example.TEST_CONVERTER.postgres.Repository;//package com.example.ConverterTest.postgres.Repository;

import com.example.TEST_CONVERTER.postgres.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

package com.sat.architecture.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sat.architecture.config.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

}

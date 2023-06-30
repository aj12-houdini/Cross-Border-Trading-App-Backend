package com.example.springbootdatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsertypeRepository extends JpaRepository<Usertype, String> {

    @Query(value="select * from usertypes u where u.username = ?1",nativeQuery = true)
    List<Usertype> findByUsername(String username);
}
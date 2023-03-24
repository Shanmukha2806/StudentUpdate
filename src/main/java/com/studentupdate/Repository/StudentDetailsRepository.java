package com.studentupdate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentupdate.Model.Students;

public interface StudentDetailsRepository extends JpaRepository<Students, String>{

}

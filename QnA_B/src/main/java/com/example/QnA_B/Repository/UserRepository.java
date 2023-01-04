package com.example.QnA_B.Repository;

import com.example.QnA_B.Domain.User.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser,Long> {



    
}

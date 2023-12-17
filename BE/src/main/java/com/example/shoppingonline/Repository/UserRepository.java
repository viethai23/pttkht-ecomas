package com.example.shoppingonline.Repository;

import com.example.shoppingonline.Model.User.Address;
import com.example.shoppingonline.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByAccount_Username(String username);
}

package com.kaliningleb25.portfolio_maker.dao;

import com.kaliningleb25.portfolio_maker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}

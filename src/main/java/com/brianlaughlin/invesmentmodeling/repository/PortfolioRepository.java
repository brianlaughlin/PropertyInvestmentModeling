package com.brianlaughlin.invesmentmodeling.repository;

import com.brianlaughlin.invesmentmodeling.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}

package com.sm.multi.bar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.multi.bar.domain.Bar;

@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {

  Bar findById(Long id);

}

package com.example.repositories;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long>{
	
	public Optional<MyData> findById(Long id);
	
	public List<MyData> findByNameLike(String name);
	
	public List<MyData> findByIdIsNotNullOrderByIdDesc();
	
	public List<MyData> findByAgeGreaterThan(Integer age);
	
	public List<MyData> findByAgeBetween(Integer age1, Integer age2);
	
	@Query("SELECT d FROM MyData d ORDER BY d.name")
	public List<MyData> findAllOrderByName();
	
	@Query("FROM MyData WHERE age > :min and age < :max")
	public List<MyData> findByAge(@Param("min") int min, @Param("max") int max);
	
	public Page<MyData> findAll(Pageable pageable);

}

package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.model.Doctor;

import jakarta.transaction.Transactional;


public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	
	

	@Query("FROM Doctor") // No need to use SELECT * when we are taking all records
	public List<Doctor> getAllDoctors();
	
	@Query("FROM Doctor WHERE income>=:start AND income<=:end") //Entity name should be used in HQL 
	public List<Doctor> searchDoctorByIncomeRange(double start, double end);
	
	@Query("FROM Doctor WHERE income>=:start AND income<=:end")
	public List<Doctor> getDoctorByIncomeRange(@Param("start")double startrange, @Param("end") double endrange);
	
	
	@Query("FROM Doctor WHERE specilization IN(:sp1,:sp2) ORDER BY specilization")
	public List<Doctor> searchDoctorBySpecilization(String sp1, String sp2);
	
	@Query("SELECT id,doctorName,income FROM Doctor WHERE income between :start and :end")
	public List<Object[]> searchDoctorDataByIncome(double start, double end);
	
	@Query("SELECT doctorName FROM Doctor WHERE income between :min and :max")
	public List<String> searchAllDoctorNameByIncomeRange(double min, double max);  // for one  column it should be like this
	
	
	@Query("FROM Doctor WHERE doctorName=:name")
	public Optional<Doctor> shwoDoctorInforByName(String name);
	
	@Query("SELECT doctorName,income,specilization FROM Doctor WHERE doctorName=:name")
	public Object showDoctorByName(String name);
	
	@Query("SELECT specilization FROM Doctor WHERE doctorName=:name")
	public List<String> getDoctorByName(String name);
	
	@Query("SELECT Count(Distinct doctorName) FROM Doctor")
	public Integer fetchDoctorCount();
	
	@Query("SELECT Count(*),max(income),min(income),avg(income),sum(income) FROM Doctor")
	public Object fetchAggerateData();
	
	//Below one are non select queries(Means we are altering something here)
	
	
	@Query("UPDATE Doctor SET income=income+(income * :percentage/100.0) Where specilization=:sp")
	@Modifying
	@Transactional
	public int hikeDoctroIncomeBySpecialization(String sp, double percentage);
	
	@Query("DELETE From Doctor Where income >= :start AND income <= :end")
	@Modifying
	@Transactional
	public int removeDoctorByIncomeRange(double start, double end);
	
	
	//Demo for git purpose
	@Query("SELECT Count(*),max(income),min(income),avg(income),sum(income) FROM Doctor")
	public Object fetchAggerateData1();
	
	
	
	
	

	
}
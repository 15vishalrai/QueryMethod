package com.nt.Runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Doctor;
import com.nt.repository.IDoctorRepository;

@Component
public class QueryMethodRunner implements CommandLineRunner {
	
	
	@Autowired
	IDoctorRepository doctorrepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		//will return all records
	//	doctorrepo.getAllDoctors().forEach(System.out::println);
		
		//doctorrepo.searchDoctorByIncomeRange(100000, 200000).forEach(System.out::println);
		//doctorrepo.getDoctorByIncomeRange(200000,300000).forEach(System.out::println);
		
		
		//doctorrepo.searchDoctorBySpecilization("General", "ortho").forEach(System.out::println);
		
//		doctorrepo.searchDoctorDataByIncome(100000, 300000).forEach(row->{
//			for(Object obj:row) {
//			System.out.print(obj+" ");
//			}
//			System.out.println(); 
//		});
		
		
	//	doctorrepo.searchAllDoctorNameByIncomeRange(40000, 500000).forEach(System.out::println);
		
//		Optional<Doctor> dr =doctorrepo.shwoDoctorInforByName("Vishal");
//		System.out.println(dr);
		
		
//		Object obj = doctorrepo.showDoctorByName("sonu");
//		Object data[]= (Object[])obj;  // we are telling here obj is object array only
//		for(Object o: data) {
//			System.out.print(o+" ");
//		}
//		System.out.println();
		
//		doctorrepo.getDoctorByName("vishal").forEach(System.out::println);
//		
//		Integer fetchDoctorCount = doctorrepo.fetchDoctorCount();
//		System.out.println(fetchDoctorCount);
		
		
//		Object obj = doctorrepo.fetchAggerateData();
//		Object data[]=(Object[])obj;
//		
//		for(Object o : data) {
//			System.out.println(o+" ");
//		}
		
//		int hikeDoctroIncomeBySpecialization = doctorrepo.hikeDoctroIncomeBySpecialization("Neuro", 20);
//		System.out.println(hikeDoctroIncomeBySpecialization);
		
		int removeDoctorByIncomeRange = doctorrepo.removeDoctorByIncomeRange(0, 50000.0);
		System.out.println(removeDoctorByIncomeRange);
		
		
	}

}

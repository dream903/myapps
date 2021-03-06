package org.ilh;

import java.util.stream.Stream;

import org.ilh.dao.CompanyRepository;
import org.ilh.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCompany1Application  {
	public static void main(String[] args) {
		SpringApplication.run(ServiceCompany1Application.class, args);
	}

@Bean//	sexecuter a demarrage
CommandLineRunner start(CompanyRepository companyRepository) {
	return args->{
		
		
		Stream.of("A","B","C").forEach(cn->{
			companyRepository.save(new Company(null,cn,100+Math.random()*900));
		});
		companyRepository.findAll().forEach(System.out::println);
		
		
		
};
}


}
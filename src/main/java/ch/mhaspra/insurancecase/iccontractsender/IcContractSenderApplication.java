package ch.mhaspra.insurancecase.iccontractsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IcContractSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcContractSenderApplication.class, args);
	}

}

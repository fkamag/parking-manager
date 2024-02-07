package com.kamatech.parkingmanager;


import com.kamatech.parkingmanager.consoles.CreateParkingSpot;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingManagerApplication.class, args);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite a vaga: ");
		String parkingSpot = scanner.nextLine();
		System.out.println("Enviando cadastro");
		var createParkingSpot = new CreateParkingSpot(parkingSpot);

		scanner.close();

		System.out.println("Cadastrado com sucesso");

	}


	@GetMapping("/")
	public String index() {
		return "Iniciando projeto Parking Manager";
	}


}

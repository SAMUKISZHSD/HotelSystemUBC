package br.com.brazcubas.hotelSystem;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
	// Instrução marota pra importar a interface CommandLineRunner, usado pra executar algo logo quando starta.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.brazcubas.hotelSystem.config.DatabaseConfig;
import br.com.brazcubas.hotelSystem.controller.HotelController;
import br.com.brazcubas.hotelSystem.model.dao.HotelDAO;
import br.com.brazcubas.hotelSystem.view.HotelView;

@SpringBootApplication
public class HotelSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelSystemApplication.class, args);
	}

	@Override
		// Sobrescrevendo o método startador da massa. Padrãozinho pro CommanLineRunner ;)
	public void run(String... args) throws Exception {
		
		// Inicialização das dependências
		HotelView HotelView = new HotelView();
		HotelDAO HotelDAO = new HotelDAO();
		HotelController HotelController = new HotelController(HotelDAO);
		
		// DB start
		DatabaseConfig.createTables();

		// Inicialização da CLI
		Scanner scanner = new Scanner(System.in);
		HotelSystem sistema = new HotelSystem(HotelController, HotelView, scanner);

		// Inicialização do sistema
		sistema.iniciar();
	}
}

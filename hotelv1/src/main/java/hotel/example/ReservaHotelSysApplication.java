package hotel.example;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hotel.example.config.DatabaseConfig;
import hotel.example.controller.QuartoController;
import hotel.example.model.dao.QuartoDAO;
import hotel.example.view.QuartoView;

@SpringBootApplication
public class ReservaHotelSysApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReservaHotelSysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Inicialização das dependências
		QuartoView quartoView = new QuartoView();
		QuartoDAO quartoDAO = new QuartoDAO();
		QuartoController quartoController = new QuartoController(quartoDAO);
		
		// DB start
		DatabaseConfig.createTables();

		// Inicialização da CLI
		Scanner scanner = new Scanner(System.in);
		HotelSystem sistema = new HotelSystem(quartoController, quartoView, scanner);

		// Inicialização do sistema
		sistema.iniciar();
	}
}

package fi.haagahelia.kononenbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.kononenbookstore.domain.Book;
import fi.haagahelia.kononenbookstore.domain.BookRepository;
import fi.haagahelia.kononenbookstore.domain.Category;
import fi.haagahelia.kononenbookstore.domain.CategoryRepository;

@SpringBootApplication
public class KononenbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(KononenbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner addingDemodata(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {

			Category it = new Category("IT");
			Category kauhu = new Category("Kauhu");
			Category talous = new Category("Talous");

			cRepository.save(it);
			cRepository.save(kauhu);
			cRepository.save(talous);

			bRepository.save(new Book("test", "test", "test", 2012, 20.5, it));
			bRepository.save(new Book("test2", "test2", "test2", 2013, 25.5, kauhu));
			bRepository.save(new Book("test3", "test3", "test3", 2014, 30.5, talous));

		};
	};
}

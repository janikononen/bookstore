package fi.haagahelia.kononenbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.kononenbookstore.domain.Book;
import fi.haagahelia.kononenbookstore.domain.BookRepository;

@SpringBootApplication
public class KononenbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(KononenbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner addingDemodata(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("esimerkkikirja", "jani", "123", 2012, 20.50));

		};
	}
}

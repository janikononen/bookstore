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
			int publicationYear = 2000;
			double price = 10.0;
			for (int i = 1; i <= 20; i++) {
				repository.save(new Book(
					"Book Title " + i, // book name
					"Author " + i,    // author
					"ISBN" + (1000 + i), // ISBN
					publicationYear + (i % 25),   // publication year
					price + (i * 2.5)   // price
				));
			}
			
		};
	}
}

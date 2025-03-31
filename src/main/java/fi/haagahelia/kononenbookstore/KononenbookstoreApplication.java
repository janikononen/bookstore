package fi.haagahelia.kononenbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import fi.haagahelia.kononenbookstore.domain.Book;
import fi.haagahelia.kononenbookstore.domain.BookRepository;
import fi.haagahelia.kononenbookstore.domain.Category;
import fi.haagahelia.kononenbookstore.domain.CategoryRepository;
import fi.haagahelia.kononenbookstore.domain.User;
import fi.haagahelia.kononenbookstore.domain.UserRepository;

@SpringBootApplication
public class KononenbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(KononenbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner addingDemodata(BookRepository bRepository, CategoryRepository cRepository,
			UserRepository uRepository, PasswordEncoder encoder) {
		return (args) -> {

			// Category it = new Category("IT");
			// Category kauhu = new Category("Kauhu");
			// Category talous = new Category("Talous");

			// cRepository.save(it);
			// cRepository.save(kauhu);
			// cRepository.save(talous);

			// bRepository.save(new Book("test", "test", "test", 2012, 20.5, it));
			// bRepository.save(new Book("test2", "test2", "test2", 2013, 25.5, kauhu));
			// bRepository.save(new Book("test3", "test3", "test3", 2014, 30.5, talous));

			// User user1 = new User("user", encoder.encode("u@123"), "USER");
			// User user2 = new User("admin", encoder.encode("a@123"), "ADMIN");

			// uRepository.save(user1);
			// uRepository.save(user2);
		};
	};
}

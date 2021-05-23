package demo.service;

import java.util.Optional;

import demo.domain.Book;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 23. initial creation
 */
public interface BookService {
	Optional<Book> findById(Long id);
}
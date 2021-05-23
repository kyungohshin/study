package demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import demo.domain.Book;
import demo.domain.BookRepository;
import lombok.RequiredArgsConstructor;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 23. initial creation
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	private final BookRepository bookRepository;

	@Override
	public Optional<Book> findById(Long id) {
		return bookRepository.findById(id);
	}

}

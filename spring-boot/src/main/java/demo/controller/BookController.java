package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Book;
import demo.service.BookService;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 23. initial creation
 */
@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/{bookId}")
	public ResponseEntity<Book> findAll(Long bookId) {
		Book book = bookService.findById(bookId).orElseThrow(() -> new RuntimeException("Not Found"));
		return ResponseEntity.ok(book); // httpStatus 200을 의미하는것
	}

}

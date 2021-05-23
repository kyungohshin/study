package demo.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 20. initial creation
 */
@RunWith(SpringRunner.class) // 이 클래스의 테스트 코드를 돌릴때 스프링이 로딩되도록 하는부분.(테스트가 실행되는 환경 조성)
@DataJpaTest // jpa관련 테스트 설정 로드, 내장형 db사용하기때문에 실제 db와 붙어서 테스트할필요가 없다는 장점!!
             // @Entity가 적용된 클래스를 스캔하여 spring data jpa 저장소 구성
             // 기본적으로 @Transactional 포함되어서 테스트가 끝나면 자동롤백
public class BookRepositoryTest {
	@Autowired
	BookRepository bookRepository;

	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("spring-boot");
		book.setIsbn10("123");
		book.setIsbn13("456");

		assertThat(book.isNew()).isTrue(); // '아직 하이버네이트 엔티티매니저가 아직 관리하고있지않은 객체다'를 확인하는용도

		bookRepository.save(book);
		assertThat(book.isNew()).isFalse(); // 저장후에는 em이 관리하고있음
	}

	@Test
	public void testFindByNameLike() {
		Book book = new Book();
		book.setName("spring-boot");
		book.setIsbn10("123");
		book.setIsbn13("456");

		bookRepository.save(book);

		List<Book> books = bookRepository.findByNameLike("spring%");
		assertThat(books).isNotEmpty();

		books = bookRepository.findByNameLike("boos");
		assertThat(books).isEmpty();
	}
}

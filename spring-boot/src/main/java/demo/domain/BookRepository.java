package demo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 19. initial creation
 */
//@Repository 안해도됨. spring data jpa가 레파지토리를 구현체로 바꿀때 simpleJpaRepository로 프록시 처리를 해주므로
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByNameLike(String name);
}

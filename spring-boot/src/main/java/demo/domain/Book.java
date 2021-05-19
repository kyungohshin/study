package demo.domain;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 5. 19. initial creation
 */
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Book extends AbstractPersistable<Long> {
	// AbstractPersistable안에 id가 있기때문에 @Id 선언을 안해도됨
	private String name;
	private String isbn13;
	private String isbn10;
}

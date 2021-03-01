package study.stream;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 1. initial creation
 */
@Setter
@Builder
@Getter
public class Person {
	int id;
	String name;
	int age;
}

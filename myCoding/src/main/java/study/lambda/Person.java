package study.lambda;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 27. initial creation
 */
public interface Person {

	default String getName() {
		return "abc";
	}
}

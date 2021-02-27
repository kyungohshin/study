package study.lambda;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 27. initial creation
 */
public interface Named {
	long getId();

	default String getName() {
		return "123";
	}
}

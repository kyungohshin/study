package study.lambda;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 27. initial creation
 */
public class Student implements Named, Person {

	@Override
	public long getId() {
		return 0;
	}

	@Override
	public String getName() {
		return Named.super.getName();
	}

}

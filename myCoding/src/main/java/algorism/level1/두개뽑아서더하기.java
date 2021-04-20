package algorism.level1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 4. 20. initial creation
 */
public class 두개뽑아서더하기 {
	public static int[] solution(int[] numbers) {

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1; j < numbers.length; j++) {
				if (i == j) {
					continue;
				}
				set.add(numbers[j] + numbers[i]);
			}
		}

//		set.forEach(System.out::println);

		// List<Integer> -> array(int)
//		set.stream().sorted().mapToInt(i -> i.intValue()).toArray();

		return set.stream().sorted().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String args[]) {
		int[] array = { 5, 0, 2, 7 };
		solution(array);
	}
}

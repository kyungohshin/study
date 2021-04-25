package algorism.level1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 21. initial creation
 */
public class 체육복 {
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		Set<Integer> set = Arrays.stream(lost).boxed().collect(Collectors.toSet());

		for (int i : reserve) {
			if (Arrays.stream(lost).anyMatch(k -> k == i)) {
				answer++;
				set.remove(i);
			} else if (Arrays.stream(lost).anyMatch(k -> k == i - 1) && i != n - 1) {
				answer++;
				set.remove(i - 1);
			} else if (Arrays.stream(lost).anyMatch(k -> k == i + 1) && i != 0) {
				answer++;
				set.remove(i + 1);
			}
		}

		if (answer + (n - lost.length) > n) {
			return n;
		} else {
			return answer + (n - lost.length);
		}
	}

	public static void main(String args[]) {
		int[] lost = { 2, 4, 3, 7, 9 };
		int[] reserve = { 1, 3, 6, 8 };
		System.out.println(solution(9, lost, reserve));
	}
}

package algorism.level1;

import java.util.Arrays;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 21. initial creation
 */
public class 나누어떨어지는배열 {
	public static int[] solution(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(t -> t % divisor == 0).sorted().toArray();

		if (answer.length == 0) {
			answer = new int[] { -1 };
		}

		return answer;
	}

	public static void main(String args[]) {
		int[] arr = { 5, 9, 7, 10 };
		solution(arr, 11);
	}
}

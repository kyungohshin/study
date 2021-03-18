package algorism.level1;

import java.util.Arrays;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 18. initial creation
 */
public class 모의고사 {
	public static int[] solution(int[] answers) {
		int[] answer = new int[3];

		int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[][] given_arrays = new int[3][];
		given_arrays[0] = one;
		given_arrays[1] = two;
		given_arrays[2] = three;

		for (int k = 0; k < 3; k++) {
			int count = 0;
			for (int i = 0; i < answers.length; i++) {
				int right;
				if (i >= given_arrays[k].length) {
					right = given_arrays[k][i % given_arrays[k].length];
				} else {
					right = given_arrays[k][i];
				}

				if (right == answers[i]) {
					count++;
				}
			}
			answer[k] = count;
		}

		System.out.println(Arrays.toString(answer));

		return answer;
	}

	public static void main(String args[]) {
//		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ..
		int[] array = { 1, 2, 3, 4, 5 };
		solution(array);
	}
}

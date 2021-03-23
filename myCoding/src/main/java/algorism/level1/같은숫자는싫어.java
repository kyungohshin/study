package algorism.level1;

import java.util.ArrayList;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 21. initial creation
 */
public class 같은숫자는싫어 {
	public static int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();

		list.add(arr[0]);
		int i = 1;
		while (i < arr.length) {
			if (arr[i] != arr[i - 1]) {
				list.add(arr[i]);
			}
			i++;
		}

		int[] answer = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			answer[j] = list.get(j);
		}

		return answer;
	}

	public static void main(String args[]) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
		solution(arr);
	}
}

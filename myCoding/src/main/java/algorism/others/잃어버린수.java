package algorism.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 4. 8. initial creation
 */
public class 잃어버린수 {

	public static int[] solution(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] answer = new int[2];

		for (int i : array) {
			if (map.get(i) == null) {
				map.put(i, 1);
			} else {
				map.put(i, 2);
			}
		}

		int j = 0;
		for (int i : map.keySet()) {
			if (map.get(i) == 1) {
				answer[j++] = i;
			}
		}

		Arrays.sort(answer);

		return answer;
	}

	public static void main(String[] args) {
		int array[] = solution(new int[] { 1, 2, 3, 4, 4, 3, 2, 5 });
		System.out.println(Arrays.toString(array));
	}

}

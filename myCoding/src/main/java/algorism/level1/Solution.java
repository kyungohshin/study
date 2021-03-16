package algorism.level1;

import java.util.Arrays;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 13. initial creation
 *          프로그래머스 [K번째 수]
 * 
 *          Arrays.copyOfRange(원본배열, 어디부터, 어디까지) - 원본배열의 일부분을 새로운 배열로 생성
 */
public class Solution {

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] temp = commands[i];
			int[] arr = Arrays.copyOfRange(array, temp[0] - 1, temp[1]);
			Arrays.sort(arr);

			answer[i] = arr[temp[2] - 1];
		}

//		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public static void main(String args[]) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		solution(array, commands);
	}
}

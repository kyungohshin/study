package algorism.level1;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 13. initial creation
 */
public class Solution {

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = null;

		for (int i = 0; i < commands.length; i++) {
			int[] temp = commands[i];
			for (int t : temp) {

			}
		}

		System.out.println();
		return answer;
	}

	public static void main(String args[]) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		solution(array, commands);
	}
}

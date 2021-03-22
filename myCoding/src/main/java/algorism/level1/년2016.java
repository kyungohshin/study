package algorism.level1;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 22. initial creation
 */
public class 년2016 {
	public static String solution(int a, int b) {
		String[] day = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
		int[] months = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int total = 0;

		for (int i = 0; i < a - 1; i++) {
			total += months[i];
		}

		String answer = day[(total + b) % 7];
		return answer;
	}

	public static void main(String args[]) {
		solution(1, 1);
	}
}

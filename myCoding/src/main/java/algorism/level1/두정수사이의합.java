package algorism.level1;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 4. 11. initial creation
 */
public class 두정수사이의합 {

	public static long solution(int a, int b) {
		long answer = 0;

		if (a > b) {
			for (int i = b; i <= a; i++) {
				answer += i;
			}
		} else {
			for (int i = a; i <= b; i++) {
				answer += i;
			}
		}

//		System.out.println(answer);
		return answer;
	}

	public static void main(String args[]) {
		solution(3, 3);
	}
}

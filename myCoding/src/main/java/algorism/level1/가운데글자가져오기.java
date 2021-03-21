package algorism.level1;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 21. initial creation
 */
public class 가운데글자가져오기 {
	public static String solution(String s) {
		String answer = "";
		int center = s.length() / 2;
		if (s.length() % 2 == 0) {
			answer = s.substring(center - 1, center + 1);
		} else {
			answer = s.substring(center, center + 1);
		}
		return answer;
	}

	public static void main(String args[]) {
		String array = "abcd";
		solution(array);
	}
}

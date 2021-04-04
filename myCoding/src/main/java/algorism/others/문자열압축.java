package algorism.others;

import java.util.Stack;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 4. 3. initial creation
 */
public class 문자열압축 {
	private static final String START = "(";
	private static final String END = ")";
	private static Stack<String> stack = new Stack<>();

	public static String solution(String input) {
		String[] array = input.split("");

		for (int i = 0; i < array.length; i++) {
			String c = array[i];
			if (c.equals(START)) {
				stack.push(c);
			} else if (c.equals(END)) {
				while (true) {
					String pop = stack.pop();
					if (stack.peek().equals(START)) {
						stack.pop(); // ( 제거
						int dupSize = Integer.parseInt(stack.pop());
						String result = "";
						for (int j = 0; j < dupSize; j++) {
							result += pop;
						}
						stack.push(result);
						break;
					} else {
						stack.push(stack.pop() + pop);
					}
				}
			} else {
				String pop;
				if (stack.size() != 0 && stack.peek().charAt(0) >= 97 && stack.peek().charAt(0) <= 122) { // 문자
					if (c.charAt(0) >= 48 && c.charAt(0) <= 57) {
						stack.push(c);
					} else {
						pop = stack.pop();
						pop += c;
						stack.push(pop);
					}
				} else if (stack.size() != 0 && stack.peek().charAt(0) >= 48 && stack.peek().charAt(0) <= 57) { // 숫자
					if (c.charAt(0) >= 65 && c.charAt(0) <= 122) {
						stack.push(c);
					} else {
						pop = stack.pop();
						pop += c;
						stack.push(pop);
					}
				} else {
					stack.push(c);
				}
			}
		}

		int size = stack.size();
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			arr[i] = stack.pop();
		}

		String result = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			result += arr[i];
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution("3(hi)"));
		System.out.println(solution("2(3(hi)co)"));
		System.out.println(solution("10(p)"));
		System.out.println(solution("2(2(hi)2(co))x2(bo)"));
	}

}

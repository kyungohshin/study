package algorism.level1;

import java.util.Arrays;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 22. initial creation
 */
public class 문자열마음대로정렬 {

	public static String[] solution(String[] strings, int n) {

		Arrays.sort(strings, (o1, o2) -> {
			if (o1.charAt(n) > o2.charAt(n)) {
				return 1;
			} else if (o1.charAt(n) < o2.charAt(n)) {
				return -1;
			} else {
				return o1.compareTo(o2);
			}
		});

//		Arrays.sort(strings, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				if (o1.charAt(n) > o2.charAt(n)) {
//					return 1;
//				} else if (o1.charAt(n) < o2.charAt(n)) {
//					return -1;
//				} else {
//					return o1.compareTo(o2);
//				}
//			}
//
//		});
//		System.out.println(Arrays.toString(strings));

		return strings;
	}

	public static void main(String args[]) {
		solution(new String[] { "abce", "abcd", "cdx", "sun", "bed", "car" }, 1);
	}
}

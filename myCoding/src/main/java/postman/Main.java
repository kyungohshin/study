package postman;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 26. initial creation
 */
public class Main {
	private final static String DELEMETER = "|";
	private final static String INDEX1 = "expected";
	private final static String INDEX2 = "inside";

	public void getErrorLog(String log) {
		StringBuilder result = new StringBuilder();

		String[] array = log.split("AssertionError");
		for (int i = 1; i < array.length; i++) {
			String how = array[i].substring(2, array[i].indexOf(INDEX1));
			String what = array[i].substring(array[i].indexOf(INDEX2));
			String temp = what.substring(what.indexOf(DELEMETER) + 1, what.lastIndexOf(DELEMETER));

			result.append(i + ". ");
			result.append(temp + "\n");
			result.append("    :" + how.trim());
			result.append("\n");
		}

		System.out.println(result.toString());
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.getErrorLog(args[0]);
	}

}

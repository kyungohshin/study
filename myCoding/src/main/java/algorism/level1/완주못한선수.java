package algorism.level1;

import java.util.HashMap;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 3. 20. initial creation
 */
public class 완주못한선수 {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> participantMap = new HashMap<>();

		for (String name : participant) {
			if (participantMap.get(name) == null) {
				participantMap.put(name, 1);
			} else {
				participantMap.put(name, participantMap.get(name) + 1);
			}
		}

		for (String name : completion) {
			participantMap.put(name, participantMap.get(name) - 1);
		}

		for (String name : participantMap.keySet()) {
			if (participantMap.get(name) == 1) {
				answer = name;
			}
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String args[]) {

		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		solution(participant, completion);
	}
}

package study.serialization;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author USER
 * @history
 *          2021. 2. 14. initial creation
 */
@Getter
@Setter
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private int age;
	private String phone;

	public Member(String name, String email, int age, String phone) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("Member{name='%s', email='%s', age='%s', phone='%s'}", name, email, age, phone);
	}
}

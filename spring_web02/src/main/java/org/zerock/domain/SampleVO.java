package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;

//...353p.
@Getter
@Setter
public class SampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;

	@Override
	public String toString() {
		return "SampleVO [mno=" + mno
		        + ", firstName=" + firstName
		        + ", lastName=" + lastName + "]";
	}

}

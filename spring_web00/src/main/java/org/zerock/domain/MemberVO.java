package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 12. 30. initial creation
 */
@Getter
@Setter
public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private String regdate;
	private String updatedate;
}

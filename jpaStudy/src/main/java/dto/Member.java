package dto;

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
public class Member {
	private int id;
	private int age;
	private String lobByte;
	private String lobString;
	private String memberType;
	private String userName;
	private java.sql.Timestamp regDate;
	private int team_id;
}

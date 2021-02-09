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
	private String lobbyte;
	private String lobstring;
	private String membertype;
	private String username;
	private java.sql.Timestamp regdate;
	private int team_id;

}

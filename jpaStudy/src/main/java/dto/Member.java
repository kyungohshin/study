package dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
public class Member {
	@Id
	private int id;

	private int age;

	@Lob
	private String lobbyte;

	@Lob
	private String lobstring;

//	@Enumerated(EnumType.STRING)
	private String membertype;

	private String username;

	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;

}

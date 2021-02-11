package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class Team {

	@Id
	private int id;

	private String name;

	@OneToMany
	@JoinColumn(name = "team_id") // Member테이블의 외래키
	// 외래키를 가진쪽을 주인관계로 설정하면 새로운컬럼이 생김
	private List<Member> member = new ArrayList<>();
}

package hellojpa.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="USERNAME", nullable=false, length=20) // 실제 디비컬럼이 USERNAME, 근데 자바 name과 매칭하겠다는뜻
	private String name;
	
	private int age;
	
//	@Column(name="TEAM_ID")
//	private Long teamId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TEAM_ID")
	private Team team;
	
	@Temporal(TemporalType.TIMESTAMP) @GeneratedValue(strategy=GenerationType.AUTO) // 날짜타입
	private Date regDate;

	@Enumerated(EnumType.STRING) // 자바 Enum타입 매핑, 항상 STRING으로 할것! ORDINAL이 기본값인데 그럼 0,1,2 순으로 들어감
	private MemberType memberType;

	@Lob
	private String lobString;

	@Lob
	private byte[] lobByte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public String getLobString() {
		return lobString;
	}

	public void setLobString(String lobString) {
		this.lobString = lobString;
	}

	public byte[] getLobByte() {
		return lobByte;
	}

	public void setLobByte(byte[] lobByte) {
		this.lobByte = lobByte;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", team=" + team + ", regDate=" + regDate
				+ ", memberType=" + memberType + ", lobString=" + lobString + ", lobByte=" + Arrays.toString(lobByte)
				+ "]";
	}
	
	
}

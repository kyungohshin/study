package study.optional;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/* 주문 */
@Getter
@Setter
public class Order {
	private Long id;
	private Date date;
	private Member member;
	private Order order;
}

/* 회원 */
@Getter
@Setter
class Member {
	private Long id;
	private String name;
	private Address address;
}

/* 주소 */
@Getter
@Setter
class Address {
	private String street;
	private String city;
	private String zipcode;
}

package org.zerock.domain;

/**
 *
 *
 * @author USER
 * @history
 *          2020. 10. 11. initial creation
 */
public class ProductVO {
	String name;
	int price;

	public ProductVO(String name, int price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

}

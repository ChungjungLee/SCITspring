package global.sesoc.web1.vo;

public class PersonVO {
	private String name;
	private String phone;
	private String address;
	
	/* 기본 생성자를 만들지 않으면 스프링이 인식을 못 하므로 주의 */
	public PersonVO() {}
	
	public PersonVO(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
}

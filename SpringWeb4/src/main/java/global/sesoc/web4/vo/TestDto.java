package global.sesoc.web4.vo;

import java.util.List;

public class TestDto {
	private String name;
	private String phone;
	private List<TestDto> list;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone () {
		return this.phone;
	}

	public void setList(List<TestDto> list) {
		this.list = list;
	}

	public List<TestDto> getList() {
		return this.list;
	}
}
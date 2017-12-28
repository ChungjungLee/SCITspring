package global.sesoc.web4.vo;

import java.util.List;

public class ProductVO {
	private int id;
	private String name;
	private int price;
	private List<ProductVO> productList;
	
	public ProductVO() {}
	
	public ProductVO(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.productList = null;
	}
	
	public ProductVO(int id, String name, int price, List<ProductVO> productList) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.productList = productList;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<ProductVO> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductVO> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", price=" + price + ", productList=" + productList + "]";
	}
	
	
}

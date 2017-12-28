package global.sesoc.web4.vo;

import java.util.ArrayList;

public class ProductList {
	private ArrayList<ProductVO> productList;
	
	public ProductList() {}
	
	public ProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}

	public ArrayList<ProductVO> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "ProductList [productList=" + productList + "]";
	}
	
}

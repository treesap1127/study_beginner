package kr.ac.kopo.smartshop.model;

import kr.ac.kopo.smartshop.utli.UploadFile;

public class ProductImage implements UploadFile{
	private int code;
	private String filename;
	private String UUID;
	private int productCode;
	
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
}

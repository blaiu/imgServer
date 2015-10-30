package com.img.bean.business;

/**
 * 业务配置
 * */
public class BusinessConfig {
	private String businessName;
	private int isThumbNail;
	private int compression;
	private String waterMark;
	private String waterMarkPic;
	private String waterMarkPosition;
	private int isBorder;
	private int imgFramSize;
	private String imgBorderColor;
//	private String label_30_pos;
//	private String label_180_pos;
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public int getCompression() {
		return compression;
	}
	public void setCompression(int compression) {
		this.compression = compression;
	}
 
	public String getWaterMark() {
		return waterMark;
	}
	public void setWaterMark(String waterMark) {
		this.waterMark = waterMark;
	}
 
	public String getWaterMarkPosition() {
		return waterMarkPosition;
	}
	public void setWaterMarkPosition(String waterMarkPosition) {
		this.waterMarkPosition = waterMarkPosition;
	}
	public int getIsBorder() {
		return isBorder;
	}
	public void setIsBorder(int isBorder) {
		this.isBorder = isBorder;
	}
	public int getImgFramSize() {
		return imgFramSize;
	}
	public void setImgFramSize(int imgFramSize) {
		this.imgFramSize = imgFramSize;
	}
	public String getImgBorderColor() {
		return imgBorderColor;
	}
	public void setImgBorderColor(String imgBorderColor) {
		this.imgBorderColor = imgBorderColor;
	}
//	public String getLabel_30_pos() {
//		return label_30_pos;
//	}
//	public void setLabel_30_pos(String label_30_pos) {
//		this.label_30_pos = label_30_pos;
//	}
//	public String getLabel_180_pos() {
//		return label_180_pos;
//	}
//	public void setLabel_180_pos(String label_180_pos) {
//		this.label_180_pos = label_180_pos;
//	}
	public int getIsThumbNail() {
		return isThumbNail;
	}
	public void setIsThumbNail(int isThumbNail) {
		this.isThumbNail = isThumbNail;
	}
	public String getWaterMarkPic() {
		return waterMarkPic;
	}
	public void setWaterMarkPic(String waterMarkPic) {
		this.waterMarkPic = waterMarkPic;
	}
	
}

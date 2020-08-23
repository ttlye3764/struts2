package kr.or.ddit.vo;

import java.util.List;

public class ImageBoardVO {
	private String rnum;
	private String img_seq;
	private String img_no;
	private String img_title;
	private String img_writer;
	private String img_nickname;
	private String img_pwd;
	private String img_mail;
	private String img_ip;
	private String img_content;
	private String img_hit;
	private String img_reg_date;
	private String img_status;
	private String img_depth;
	private String img_group;
	private List<ImageFileItemVO> items;

	
	public String getImg_depth() {
		return img_depth;
	}
	public void setImg_depth(String img_depth) {
		this.img_depth = img_depth;
	}
	public String getImg_group() {
		return img_group;
	}
	public void setImg_group(String img_group) {
		this.img_group = img_group;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getImg_seq() {
		return img_seq;
	}
	public void setImg_seq(String img_seq) {
		this.img_seq = img_seq;
	}
	public String getImg_no() {
		return img_no;
	}
	public void setImg_no(String img_no) {
		this.img_no = img_no;
	}
	public String getImg_title() {
		return img_title;
	}
	public void setImg_title(String img_title) {
		this.img_title = img_title;
	}
	public String getImg_writer() {
		return img_writer;
	}
	public void setImg_writer(String img_writer) {
		this.img_writer = img_writer;
	}
	public String getImg_nickname() {
		return img_nickname;
	}
	public void setImg_nickname(String img_nickname) {
		this.img_nickname = img_nickname;
	}
	public String getImg_pwd() {
		return img_pwd;
	}
	public void setImg_pwd(String img_pwd) {
		this.img_pwd = img_pwd;
	}
	public String getImg_mail() {
		return img_mail;
	}
	public void setImg_mail(String img_mail) {
		this.img_mail = img_mail;
	}
	public String getImg_ip() {
		return img_ip;
	}
	public void setImg_ip(String img_ip) {
		this.img_ip = img_ip;
	}
	public String getImg_content() {
		return img_content;
	}
	public void setImg_content(String img_content) {
		this.img_content = img_content;
	}
	public String getImg_hit() {
		return img_hit;
	}
	public void setImg_hit(String img_hit) {
		this.img_hit = img_hit;
	}
	public String getImg_reg_date() {
		return img_reg_date;
	}
	public void setImg_reg_date(String img_reg_date) {
		this.img_reg_date = img_reg_date;
	}
	public String getImg_status() {
		return img_status;
	}
	public void setImg_status(String img_status) {
		this.img_status = img_status;
	}
	public List<ImageFileItemVO> getItems() {
		return items;
	}
	public void setItems(List<ImageFileItemVO> items) {
		this.items = items;
	}

}

package kr.or.ddit.vo;

import java.util.List;

public class NoticeBoardVO {
	private String rnum;
	private String nt_seq;
	private String nt_no;
	private String nt_group;
	private String nt_depth;
	private String nt_title;
	private String nt_writer;
	private String nt_nickname;
	private String nt_pwd;
	private String nt_mail;
	private String nt_ip;
	private String nt_content;
	private String nt_hit;
	private String nt_reg_date;
	private String nt_status;
	private List<FileItemVO> Items;
	
	public List<FileItemVO> getItems() {
		return Items;
	}
	public void setItems(List<FileItemVO> items) {
		Items = items;
	}
	public String getNt_seq() {
		return nt_seq;
	}
	public void setNt_seq(String nt_seq) {
		this.nt_seq = nt_seq;
	}
	public String getNt_no() {
		return nt_no;
	}
	public void setNt_no(String nt_no) {
		this.nt_no = nt_no;
	}
	public String getNt_title() {
		return nt_title;
	}
	public void setNt_title(String nt_title) {
		this.nt_title = nt_title;
	}
	public String getNt_writer() {
		return nt_writer;
	}
	public void setNt_writer(String nt_writer) {
		this.nt_writer = nt_writer;
	}
	public String getNt_nickname() {
		return nt_nickname;
	}
	public void setNt_nickname(String nt_nickname) {
		this.nt_nickname = nt_nickname;
	}
	public String getNt_pwd() {
		return nt_pwd;
	}
	public void setNt_pwd(String nt_pwd) {
		this.nt_pwd = nt_pwd;
	}
	public String getNt_mail() {
		return nt_mail;
	}
	public void setNt_mail(String nt_mail) {
		this.nt_mail = nt_mail;
	}
	public String getNt_ip() {
		return nt_ip;
	}
	public void setNt_ip(String nt_ip) {
		this.nt_ip = nt_ip;
	}
	public String getNt_content() {
		return nt_content;
	}
	public void setNt_content(String nt_content) {
		this.nt_content = nt_content;
	}
	public String getNt_hit() {
		return nt_hit;
	}
	public void setNt_hit(String nt_hit) {
		this.nt_hit = nt_hit;
	}
	public String getNt_reg_date() {
		return nt_reg_date;
	}
	public void setNt_reg_date(String nt_reg_date) {
		this.nt_reg_date = nt_reg_date;
	}
	public String getNt_status() {
		return nt_status;
	}
	public void setNt_status(String nt_status) {
		this.nt_status = nt_status;
	}
	public String getNt_depth() {
		return nt_depth;
	}
	public void setNt_depth(String nt_depth) {
		this.nt_depth = nt_depth;
	}
	public String getNt_group() {
		return nt_group;
	}
	public void setNt_group(String nt_group) {
		this.nt_group = nt_group;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	
	
	
	
}

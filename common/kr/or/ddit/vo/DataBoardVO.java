package kr.or.ddit.vo;

import java.util.List;

public class DataBoardVO {
	private String rnum;
	private String db_no;
	private String db_title;
	private String db_writer;
	private String db_nickname;
	private String db_pwd;
	private String db_mail;
	private String db_ip;
	private String db_content;
	private String db_hit;
	private String db_reg_date;
	private String db_status;
	private String db_group;
	private String db_seq;
	private String db_depth;
	private String db_answer_status;
	private List<DataBoardVO> items;
		
	public List<DataBoardVO> getItems() {
		return items;
	}
	public void setItems(List<DataBoardVO> items) {
		items = items;
	}
	public String getDb_answer_status() {
		return db_answer_status;
	}
	public void setDb_answer_status(String db_answer_status) {
		this.db_answer_status = db_answer_status;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}	
	public String getDb_no() {
		return db_no;
	}
	public void setDb_no(String db_no) {
		this.db_no = db_no;
	}
	public String getDb_title() {
		return db_title;
	}
	public void setDb_title(String db_title) {
		this.db_title = db_title;
	}
	public String getDb_writer() {
		return db_writer;
	}
	public void setDb_writer(String db_writer) {
		this.db_writer = db_writer;
	}
	public String getDb_nickname() {
		return db_nickname;
	}
	public void setDb_nickname(String db_nickname) {
		this.db_nickname = db_nickname;
	}
	public String getDb_pwd() {
		return db_pwd;
	}
	public void setDb_pwd(String db_pwd) {
		this.db_pwd = db_pwd;
	}
	public String getDb_mail() {
		return db_mail;
	}
	public void setDb_mail(String db_mail) {
		this.db_mail = db_mail;
	}
	public String getDb_ip() {
		return db_ip;
	}
	public void setDb_ip(String db_ip) {
		this.db_ip = db_ip;
	}
	public String getDb_content() {
		return db_content;
	}
	public void setDb_content(String db_content) {
		this.db_content = db_content;
	}
	public String getDb_hit() {
		return db_hit;
	}
	public void setDb_hit(String db_hit) {
		this.db_hit = db_hit;
	}
	public String getDb_reg_date() {
		return db_reg_date;
	}
	public void setDb_reg_date(String db_reg_date) {
		this.db_reg_date = db_reg_date;
	}
	public String getDb_status() {
		return db_status;
	}
	public void setDb_status(String db_status) {
		this.db_status = db_status;
	}
	public String getDb_group() {
		return db_group;
	}
	public void setDb_group(String db_group) {
		this.db_group = db_group;
	}
	public String getDb_seq() {
		return db_seq;
	}
	public void setDb_seq(String db_seq) {
		this.db_seq = db_seq;
	}
	public String getDb_depth() {
		return db_depth;
	}
	public void setDb_depth(String db_depth) {
		this.db_depth = db_depth;
	}
	
	
	
			
}

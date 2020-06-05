package com.example.MessageMemo;


//import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	// データベースから値を取得
@Table(name="M_CUSTOMER")	// テーブル名
public class Customer {
	
	@Id	// 主キーの指定
	
	// カラム名と制約
	@Column(name="C_CD" ,columnDefinition = "VARCHAR(4)")	// 顧客コード
	private String c_num;
	
	@Column(name="C_NAME" ,nullable = false ,columnDefinition = "VARCHAR(100)")	// 顧客名
	private String c_name;
	
//	@Column(name="ADDRESS" ,columnDefinition = "VARCHAR(256)")	// 住所
//	private String address;
//	
//	@Column(name="TEL" ,columnDefinition = "VARCHAR(11)")	// 電話番号
//	private String tel;
//
//	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")	// 更新日時
//	private Timestamp update_date;
//
//	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")	// 更新者
//	private String update_user;
//	
//	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")	// 作成日時
//	private Timestamp create_date;
//
//	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")	// 作成者
//	private String create_user;
	
	
	// セッタとゲッタ
	public String getC_num() {	
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {	
//		this.address = address;
//	}
//	public String getTel() {
//		return tel;
//	}
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
	
	
	public void setAll(  String c_num
						,String c_name
						) {
		this.c_num = c_num;
		this.c_name = c_name;
	}
	
	
//	public Timestamp getCreate_date() {
//		return create_date;
//	}
//	public void setCreate_date(Timestamp create_date) {
//		this.create_date = create_date;
//	}
//	public String getCreate_user() {
//		return create_user;
//	}
//	public void setCreate_user(String create_user) {
//		this.create_user = create_user;
//	}
//	public Timestamp getUpdate_date() {
//		return update_date;
//	}
//	public void setUpdate_date(Timestamp update_date) {
//		this.update_date = update_date;
//	}
//	public String getUpdate_user() {
//		return update_user;
//	}
//	public void setUpdate_user(String update_user) {
//		this.update_user = update_user;
//	}
//
}


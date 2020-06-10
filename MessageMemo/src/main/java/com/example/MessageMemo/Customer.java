package com.example.MessageMemo;

import java.sql.Timestamp;

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
	
	@Column(name="ADDRESS" ,columnDefinition = "VARCHAR(256)")	// 住所
	private String address;
	
	@Column(name="TEL" ,columnDefinition = "VARCHAR(11)")	// 電話番号
	private String tel;

	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")	// 更新日時
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")	// 更新者
	private String update_user;
	
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")	// 作成日時
	private Timestamp create_date;

	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")	// 作成者
	private String create_user;
	
	
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
	
	
	public void setAll(  String c_num
						,String c_name
						) {
		this.c_num = c_num;
		this.c_name = c_name;
	}
	
}


package com.example.MessageMemo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		// データベースから値を取得
@Table(name="M_EMPLOYEE")	// テーブル名
public class Employee {
	
	@Id	// 主キーの指定
	
	// カラム名
	@Column(name="E_NUM" ,columnDefinition = "VARCHAR(5)")	// 社員No
	private String e_num;
	
	@Column(name="E_NAME" ,nullable = false ,columnDefinition = "VARCHAR(40)")	// 氏名
	private String e_name;

	@Column(name="E_YEAR" ,columnDefinition = "int(4)")	// 入社年
	private int e_year;
	
	@Column(name="DEPART_CD" ,columnDefinition = "CHAR(2)")	// 所属部署
	private String depart_cd;

	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")	// 更新日
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")	// 更新者
	private String update_user;
	
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")	// 作成日
	private Timestamp create_date;

	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")	// 作成者
	private String create_user;

	// セッタとゲッタ
	public String getE_num() {
		return e_num;
	}
	public void setE_num(String e_num) {
		this.e_num = e_num;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
		
	
	public void setAll(  String e_num
						,String e_name
						) {
		this.e_num = e_num;
		this.e_name = e_name;	
	}

}


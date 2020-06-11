package com.example.MessageMemo;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		// データベースから値を取得
@Table(name="T_MESSAGE")	// テーブル名
public class Message {
	
	@Id	// 主キーの指定
	
	// カラム名
	@Column(name="M_ID" ,columnDefinition = "int(11)")	// 宛先者氏名
	private int m_id;
	
	@Column(name="TO_NAME" ,columnDefinition = "VARCHAR(40)")	// 宛先者氏名
	private String to_name;
	
	@Column(name="RECEIVER_CD" ,columnDefinition = "VARCHAR(5)")	// 受電者コード
	private String receiver_cd;
	
	@Column(name="RECEIV_TIME" ,columnDefinition = "datetime")	// 受電日時
	private Timestamp receive_time;

	@Column(name="CUSTMER_CD" ,columnDefinition = "VARCHAR(4)")	// 顧客コード
	private String customer_cd;

	@Column(name="SENDER" ,columnDefinition = "VARCHAR(40)")	// 発信者
	private String sender;
	
	@Column(name="MESSAGE_CD" ,columnDefinition = "CHAR(1)")	// メッセージコード
	private String message_cd;

	@Column(name="MEMO" ,columnDefinition = "VARCHAR(256)")	// メモ
	private String memo;
	
	@Column(name="UPDATE_DATE" ,columnDefinition = "datetime")	// 更新日時
	private Timestamp update_date;

	@Column(name="UPDATE_USER" ,columnDefinition = "VARCHAR(40)")	// 更新者
	private String update_user;
	
	@Column(name="CREATE_DATE" ,columnDefinition = "datetime")	// 作成日時
	private Timestamp create_date;

	@Column(name="CREATE_USER" ,columnDefinition = "VARCHAR(40)")	// 作成者
	private String create_user;
	
	// セッタとゲッタ
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getTo_name() {
		return to_name;
	}
	public void setE_name(String to_name) {
		this.to_name = to_name;
	}
	public String getReceiver_cd() {
		return receiver_cd;
	}
	public void setE_year(String receiver_cd) {
		this.receiver_cd = receiver_cd;
	}
	public Timestamp getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(Timestamp timestamp) {
		this.receive_time = timestamp;
	}
	public String getCustomer_cd() {
		return customer_cd;
	}
	public void setCustomer_cd(String customer_cd) {
		this.customer_cd = customer_cd;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage_cd() {
		return message_cd;
	}
	public void setMessage_cd(String message_cd) {
		this.message_cd = message_cd;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	
	public void setAll(  int m_id 
						,String to_name
						,String receiver_cd
						,Timestamp timestamp
						,String customer_cd
						,String sender
						,String message_cd
						,String memo
						) {
		this.m_id = m_id;
		this.to_name = to_name;
		this.receiver_cd = receiver_cd;
		this.receive_time = timestamp;
		this.customer_cd = customer_cd;
		this.sender = sender;
		this.message_cd = message_cd;
		this.memo = memo;
	}

	
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Timestamp getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Timestamp update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_user() {
		return update_user;
	}
	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

}


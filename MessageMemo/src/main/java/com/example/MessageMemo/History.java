package com.example.MessageMemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity	// データベースから値を取得
public class History {

	@Id	// 主キー
	private int m_id;	// M_ID
	
	private Timestamp receive_time;	// 受電日時
	
	private String to_name;	// 宛先者氏名
	
	private String c_name;	// 顧客名
	
	private String sender;	// 氏名
	
	private String message_cd;	// メッセージコード
	
	private String e_name;	// 社員氏名
	
	// セッタとゲッタ
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public Timestamp getReceive_time() {
		return receive_time;
	}
	public void retReceive_time(Timestamp receive_time) {
		this.receive_time = receive_time;
	}
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String to_name) {
		this.to_name = to_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
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
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	
//	public void setAll(  int m_id
//						,Timestamp receive_time
//						,String c_name
//						,String sender
//						,String message_cd
//						,String e_name
//						) {
//		this.m_id = m_id;
//		this.receive_time = receive_time;
//		this.c_name = c_name;
//		this.sender = sender;
//		this.message_cd = message_cd;
//		this.e_name = e_name;
//	}

}


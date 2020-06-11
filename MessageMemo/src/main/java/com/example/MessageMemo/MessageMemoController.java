package com.example.MessageMemo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller		// コントローラの役割を持たせる
public class MessageMemoController {
	@Autowired	
	private CustomerRepository customerRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private MessageRepository rep;

	@RequestMapping("/msgmemo/inputForm")
	public String msg(Model model) {

		// M_CUSTOMERテーブルの全データを取得
		Iterable<Customer> customerList = customerRepository.findAll();
				
		// モデルに属性追加
		model.addAttribute("customerlist",customerList);
		
		// M_EMPLOYEEテーブルの全データを取得
		Iterable<Employee> employeeList = employeeRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("employeelist",employeeList);

		return "msg.html";	// MESSAGE MEMO画面表示	
	}
	
	// DB登録処理
	@PostMapping(path="/msgmemo/inputForm")
	public @ResponseBody void addNewMessage(	  @RequestParam String to_name
												, @RequestParam String receiver_cd
												, @RequestParam String receive_time
												, @RequestParam String customer_cd
												, @RequestParam String sender
												, @RequestParam String message_cd
												, @RequestParam String memo) {
		
		// 取得確認
//		System.out.println(to_name);
//		System.out.println(receiver_cd);
//		System.out.println(receive_time);
//		System.out.println(customer_cd);
//		System.out.println(sender);
//		System.out.println(message_cd);
//		System.out.println(memo);
		
		// 受電日時のテキストボックス値を配列に格納
		String[] times = receive_time.split(",",0);
//		for (int i=0; i<times.length; i++) {
//		      System.out.println(times[i]);
//		}
		
		// PMの場合の処理
		String hour = times[4];
		int num = Integer.parseInt(hour);
		if(times[3].equals("PM")) {
			num += 12;
		}
		System.out.println("numは" + num);	// numの値を確認
		
		
		// DB受電日時の形に文字列結合
		String time = times[0] + "-" + times[1] + "-" + times[2] + " " + num + ":" + times[5];
//		System.out.println("timeの値は" + time);		// timeの値確認
		
		// timeをTimestamp型に変換
		try {
			Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(time).getTime());
//			System.out.println("timestampは" + timestamp);	// timestampの値を確認
		
	        // DBのテーブルに登録
			Message messageAddData = new Message();
			
			// 自動採番（初期値1,以降最大ID+1）
			int cnt = rep.countT_message();
			
			int m_id;
			if(cnt == 0) {
				m_id = 1;
			} else {
				m_id = cnt + 1;
			}
			messageAddData.setM_id(cnt);			
			
			messageAddData.setAll(m_id,to_name,receiver_cd,timestamp,customer_cd,sender,message_cd,memo);
			
			Timestamp tStamp = new Timestamp(System.currentTimeMillis());
			messageAddData.setCreate_date(tStamp);
			messageAddData.setCreate_user("springuser");
			messageAddData.setUpdate_date(tStamp);
			messageAddData.setUpdate_user("springuser");
					
			messageRepository.save(messageAddData);
		
		} catch(ParseException e) {		// エラーで登録できない場合
			e.printStackTrace();
		}
	}	
}
package com.example.MessageMemo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;




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
	
	public String addNewMessage(	  @RequestParam String to_name
									, @RequestParam String receiver_cd
									, @RequestParam String receive_time
									, @RequestParam String customer_cd
									, @RequestParam String sender
									, @RequestParam String message_cd
									, @RequestParam String memo
									, Model model) {

		
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
//		System.out.println("numは" + num);	// numの値を確認
		
		
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
			if(cnt == 0) {	// 最初のデータには1
				m_id = 1;
			} else {
				m_id = cnt + 1;		// 以降最大ID+1
			}
			
//			messageAddData.setM_id(cnt);	
			
			messageAddData.setAll(m_id,to_name,receiver_cd,timestamp,customer_cd,sender,message_cd,memo);
			
			Timestamp tStamp = new Timestamp(System.currentTimeMillis());	// 現在時刻(ミリ秒)を変数に代入
			messageAddData.setCreate_date(tStamp);		// 作成者・更新日時など
			messageAddData.setCreate_user("springuser");
			messageAddData.setUpdate_date(tStamp);
			messageAddData.setUpdate_user("springuser");
					
			messageRepository.save(messageAddData);
		
			
		} catch(ParseException e) {		// エラーで登録できない場合
			e.printStackTrace();
		}
		
		model.addAttribute("enterMessage", to_name + "さん宛てのメッセージを登録しました");	// 登録メッセージ
		
		Iterable<Customer> customerList = customerRepository.findAll();		// 画面を再表示する前にデータ取得
		model.addAttribute("customerlist",customerList);
		Iterable<Employee> employeeList = employeeRepository.findAll();
		model.addAttribute("employeelist",employeeList);
		
		return "msg.html";
	}
	
	
	@GetMapping(path="/msgmemo/history")
	public String list(Model model) {
		// T_MESSAGEテーブルの全データを取得
		Iterable<Message> messageList = messageRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("messagelist",messageList);

		// データ一覧画面を表示
		return "history.html";
	}
	
//	@RequestMapping("/msgmemo/history")
//    public String insert() {
//		// データ登録画面を表示
//        return "history.html";
//    }
	
	
}



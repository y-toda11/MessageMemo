package com.example.MessageMemo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
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

	public @ResponseBody void addNewCustomer(	  @RequestParam String c_num 
												, @RequestParam String c_name) {
		
		Customer customerAddData = new Customer();
		customerAddData.setAll(c_num,c_name);
			
		customerRepository.save(customerAddData);
	}
		
	public @ResponseBody void addNewEmployee(	  @RequestParam String e_num 
												, @RequestParam String e_name) {
		
		Employee employeeAddData = new Employee();
		employeeAddData.setAll(e_num,e_name);
		
		employeeRepository.save(employeeAddData);
	}
	
	// DB登録処理
//	@PostMapping(path="/")
	public @ResponseBody String addNewMessage(	  @RequestParam int m_num 
												, @RequestParam String to_name
												, @RequestParam String receiver_cd
												, @RequestParam Timestamp receiver_time
												, @RequestParam String customer_cd
												, @RequestParam String sender
												, @RequestParam String message_cd
												, @RequestParam String memo) {
		
		Message messageAddData = new Message();
		messageAddData.setAll(m_num,to_name,receiver_cd,receiver_time,customer_cd,sender,message_cd,memo);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		messageAddData.setCreate_date(timestamp);
		messageAddData.setCreate_user("auto_system");
		messageAddData.setUpdate_date(timestamp);
		messageAddData.setUpdate_user("auto_system");
		
		messageRepository.save(messageAddData);
		
		return "/msgmemo/inputForm";
	}
	
	
}
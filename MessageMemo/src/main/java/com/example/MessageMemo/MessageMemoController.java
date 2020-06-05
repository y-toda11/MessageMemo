package com.example.MessageMemo;

//import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping("/msgmemo/inputForm")
	public String msg() {
		return "msg.html";	// MESSAGE MEMO画面表示
	}
	
	// 顧客名簿
	public void list(Model model) {
		// M_CUSTOMERテーブルの全データを取得
		Iterable<Customer> customerList = customerRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("customerlist",customerList);
	}

	public @ResponseBody void addNewCustomer(	  @RequestParam String c_num 
												, @RequestParam String c_name) {
		
		Customer customerAddData = new Customer();
		customerAddData.setAll(c_num,c_name);
			
		customerRepository.save(customerAddData);
	}
	
	// 従業員名簿
	public void list_ep(Model model) {
		// M_EMPLOYEEテーブルの全データを取得
		Iterable<Employee> employeeList = employeeRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("employeelist",employeeList);
	}

	public @ResponseBody void addNewEmployee(	  @RequestParam String e_num 
												, @RequestParam String e_name) {
		
		Employee employeeAddData = new Employee();
		employeeAddData.setAll(e_num,e_name);
		
		employeeRepository.save(employeeAddData);
	}
}
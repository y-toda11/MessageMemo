package com.example.MessageMemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface HistoryRepository extends CrudRepository<History, String> {
	@Query(value="SELECT T_MESSAGE.M_ID AS m_id"
			+ " ,T_MESSAGE.RECEIV_TIME AS receive_time"
			+ " ,T_MESSAGE.TO_NAME AS to_name"
			+ " ,M_CUSTOMER.C_NAME AS c_name"
			+ " ,T_MESSAGE.SENDER AS sender"
			+ " ,T_MESSAGE.MESSAGE_CD AS message_cd"
			+ " ,M_EMPLOYEE.E_NAME AS e_name"
			+ " FROM t_message"
			+ " LEFT JOIN m_customer"
			+ " ON t_message.CUSTMER_CD = m_customer.C_CD"
			+ " INNER JOIN m_employee"
			+ " ON t_message.RECEIVER_CD = m_employee.E_NUM;"
			, nativeQuery = true)
	
	ArrayList<History> histories();
}
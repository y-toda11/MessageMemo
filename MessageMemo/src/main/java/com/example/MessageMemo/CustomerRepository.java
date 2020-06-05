package com.example.MessageMemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、 CustomerEntity と String を指定します。
public interface CustomerRepository extends CrudRepository<Customer, String> {
	
}
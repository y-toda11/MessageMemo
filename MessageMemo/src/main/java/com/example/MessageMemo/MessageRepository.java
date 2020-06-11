package com.example.MessageMemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
//ここでは、エンティティのクラスとエンティティIDのクラス、 MessageEntity と String を指定します。
public interface MessageRepository extends CrudRepository<Message, String> {
	@Query(value="SELECT COUNT(M_ID) FROM T_MESSAGE", nativeQuery = true)
	public int countT_message();
}


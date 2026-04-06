package com.test.main;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.PlayerDao2;
import com.test.model.Players;

public class TestDemo1 {

	public static void main(String[] args) {

		ApplicationContext ctx=new AnnotationConfigApplicationContext(DBConfig.class);
		 PlayerDao2 dao=ctx.getBean(PlayerDao2.class);
		 
		 Players obj=new Players();
		 
		 obj.setId(444);
		 obj.setName("Axar");
		 obj.setTeam("Dehli");
		 obj.setPrice(456);
		 
		 dao.createPlayers(obj);
		 
		 System.out.println("Done.");
		 List<Players> list=dao.listallPlayers();
		 list.forEach(System.out::println);

	}

}

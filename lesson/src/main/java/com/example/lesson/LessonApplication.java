package com.example.lesson;

import com.example.lesson.Service.PgProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(LessonApplication.class, args);

//		 newが不要でインスタンスを取得できる
		var userService = context.getBean(PgProductService.class);
//		var list = userService.findAll();
//		list.stream().forEach(System.out::println);

//		var userService = context.getBean(PgProductService.class);
//		var list = userService.findById(3);
//		System.out.println(list);

//		var userService = context.getBean(PgProductService.class);
//		var list = userService.delete(4);
//		System.out.println(list);
	}

}

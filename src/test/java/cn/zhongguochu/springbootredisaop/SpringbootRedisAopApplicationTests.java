package cn.zhongguochu.springbootredisaop;

import cn.zhongguochu.springbootredisaop.redis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRedisAopApplicationTests {
	@Autowired
	private RedisService redisService;

	@Test
	void contextLoads() {
		User user = redisService.getObject("key", User.class);
		User user1 = redisService.getObject("key", User.class);
		System.out.println(user.getName());
		System.out.println(user1.getPhone());
	}

}

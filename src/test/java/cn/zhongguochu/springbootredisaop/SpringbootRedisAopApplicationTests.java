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
		String user = redisService.get("key");
		System.out.println(user);
	}

}

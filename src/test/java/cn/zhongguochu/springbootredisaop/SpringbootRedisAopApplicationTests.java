package cn.zhongguochu.springbootredisaop;

import cn.zhongguochu.springbootredisaop.redis.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRedisAopApplicationTests {
	@Test
	void contextLoads() {
		RedisUtils.set("111", "123");
		String userStr = RedisUtils.get("111");
		System.out.println("用户获取前：" + userStr);
	}
}

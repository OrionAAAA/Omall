package com.ori.Omall.redisDemo;



import com.ori.Omall.pojo.TbSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by Orion on 2020/11/18 11:13
 */
@SpringBootTest
public class redisDemo {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void setStr(){
        stringRedisTemplate.opsForValue().set("str","hello redis");
        System.out.println("setRedis");
    }

    @Test
    public void getStr(){
        System.out.println(stringRedisTemplate.opsForValue().get("str"));

    }

    @Test
    public void setObject(){
        TbSpecification tbSpecification=new TbSpecification();
        tbSpecification.setId(Long.valueOf(1));
        tbSpecification.setSpecName("hzjhabi");
        redisTemplate.opsForValue().set("spec2",tbSpecification);
    }

    @Test
    public void getObject(){
        System.out.println(redisTemplate.opsForValue().get("spec"));
    }
}

package com.willow.springbootmybatis;

import com.willow.elasticsearch.Employee;
import com.willow.elasticsearch.EmployeeRepository;
import com.willow.entity.Department;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() {
        System.out.println("dataSource"+dataSource.getClass());
    }
    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01(){
        System.out.println("###########"+stringRedisTemplate.opsForValue().get("msg"));
    }

    @Autowired
    private JestClient jestClient;
    @Test
    public void addES() throws IOException {
        Department dept=new Department();
        dept.setDepartmentName("人事部");
        dept.setId(1);
        Index index= new Index.Builder(dept).index("dept").type("addrees").build();
        jestClient.execute(index);
    }

    @Test
    public void search() throws IOException {
       String json="{\n" +
               "    \"query\" : {\n" +
               "        \"match\" : {\n" +
               "            \"departmentName\" : \"事\"\n" +
               "        }\n" +
               "    }\n" +
               "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("dept").addType("address").build();

        //执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    EmployeeRepository employeeRepository;
    @Test
    public void testElastic(){
        List<Employee>  list= employeeRepository.findByLastnameLike("Smith");
        System.out.println("####"+list.size());
    }
}

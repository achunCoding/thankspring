package top.wycfight.thankspring;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.wycfight.thankspring.modules.test.bean.Article;
import top.wycfight.thankspring.modules.test.bean.Book;
import top.wycfight.thankspring.modules.test.repository.BookRepository;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThankspringApplicationTests {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private JestClient jestClient;


    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test02() {
        Book book = new Book();
        bookRepository.save(book);
    }

    /**
     * 1.点对点（单播）
     */
    @Test
    public void contextLoads() {
        // Message需要自己构造一个；定义消息(消息体和消息头)
        //rabbitTemplate.send(exchange,routeKey,message);
        Map<String, Object> result = new HashMap<>(16);
        result.put("msg", "这是一个新的东西啊。嘻嘻嘻");
        result.put("data", Arrays.asList("helloword", true, 123));
        // 对象被默认序列化之后发送
        rabbitTemplate.convertAndSend("exchange.direct", "wyc", new Book("三国演义", "罗贯中"));
    }

    /**
     * 接收数据
     */
    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("wyc");
        System.out.println(o);
        System.out.println(o.getClass());

    }

    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("哈哈", "wyc"));
    }

    @Test
    public void createExchange() {
        // 创建exchange
//        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        amqpAdmin.declareQueue(new Queue("wyc.queue",true));
    }


    @Test
    public void addEs() {
        // 添加一条数据
        Article article = new Article();
        article.setId(1);
        article.setAuthor("zhangsan");
        article.setTitle("学习中");
        article.setContext("学而不思则罔，思而不学则殆!");
        // 构建索引功能
        Index index = new Index.Builder(article).index("wyc").type("xixi").id("2").build();

        try {
            // 执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void search() {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"context\" : \"学\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("wyc").addType("xixi").build();

        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

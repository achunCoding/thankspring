package top.wycfight.thankspring.modules.test.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.thankspring.modules.test.bean.Book;

/**
 * @author: wycfight@163.com
 * @description: 书本类Service
 * @create: 2018-11-26 16:43
 * @modified By:
 **/
@Service
public class BookService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "wyc.news")
    public void receiveMsg(Book book) {
        System.out.println("接到消息" + book);

    }
    @RabbitListener(queues = "wyc")
    public void receiveMsg02(Message message) {
        System.out.println("消息体" + message.getBody().toString());
        System.out.println("消息头" + message.getMessageProperties());

    }
}

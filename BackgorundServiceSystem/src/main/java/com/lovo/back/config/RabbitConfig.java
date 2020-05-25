package com.lovo.back.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmp的配置类
 */
@Configuration
public class RabbitConfig {


    @Autowired
    CachingConnectionFactory connectionFactory;
    /**
     * 合同审核的消息队列r
     * @return
     */
    @Bean
    public Queue messageQueue() {
        return new Queue("message_queue");
    }


    /**
     * 合同审核的交换机
     * @return
     */
    @Bean
    public TopicExchange messageExchange(){
        return  new TopicExchange("message_exchange");
    }


    /**
     * 将队列绑定到交换机
     * @return
     */
    @Bean
    public Binding bindingPartQueueToPartExchange(Queue messageQueue,TopicExchange messageExchange){

        return BindingBuilder.bind(messageQueue).to(messageExchange).with("message.#");

    }

    //创建AMP模板
    @Bean
    public RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory);
    }

}

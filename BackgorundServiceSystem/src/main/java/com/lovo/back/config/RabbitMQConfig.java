package com.lovo.back.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;

/**
 * rabbitMQ 的配置类
 */
public class RabbitMQConfig {
    /**
     * @return 消息队列
     */
    @Bean
    public Queue messageQueue() {
        return new Queue("message_queue");
    }

    /**
     * 消息主题交换机
     * @return
     */
    @Bean
    public TopicExchange messageExchange(){
         return  new TopicExchange("message_exchange");
    }

    /**
     * 绑定队列到交换机
     * @param messageQueue
     * @param messageExchange
     * @return
     */
    @Bean
    public Binding bndingMessageQueueToMessageExchange(Queue messageQueue,TopicExchange messageExchange){

        return BindingBuilder.bind(messageQueue).to(messageExchange).with("message#");
    }

}

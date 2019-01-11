package com.penn.springrocketmqconsumer.mq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class MessageListenerSecond implements MessageListenerConcurrently {

    final Logger logger = Logger.getLogger(MessageListenerSecond.class);
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        for (MessageExt msg : msgs) {
            try {
                logger.info(Thread.currentThread().getName()+ "---->second consumer接收到"+ msgs.size() +"条消息"
                        +"接收到的消息为:"+new String(msg.getBody(),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                logger.error(e.toString());
            }
        }
        // 有异常抛出来，不要全捕获了，这样保证不能消费的消息下次重推，每次重新消费间隔：10s,30s,1m,2m,3m
        // 如果没有异常会认为都成功消费
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

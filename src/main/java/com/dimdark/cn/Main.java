package com.dimdark.cn;

import com.dimdark.cn.model.Shop;
import com.dimdark.cn.thread.Consumer;
import com.dimdark.cn.thread.Producer;

/**
 * 测试一个生产者与一个消费者对商店中的商品
 * 进行并发操作的情况<br/>
 * @author dimdark
 * @date 2017-03-29
 * @time 9:32 PM
 */
public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        Producer producer = new Producer(shop);
        Consumer consumer = new Consumer(shop);
        Thread produceThread = new Thread(producer);
        Thread consumeThread = new Thread(consumer);
        produceThread.start();
        consumeThread.start();
    }

}

package com.dimdark.cn.thread;

import com.dimdark.cn.model.Goods;
import com.dimdark.cn.model.Shop;

import java.util.ArrayList;

/**
 * 消费者:向商店取出一个商品并消耗掉<br/>
 * 注意:当商店没有商品时消费者不能向商店取商品<br/>
 * @author dimdark
 * @date 2017-03-29
 * @time 12:12 AM
 */
public class Consumer implements Runnable {

    private Shop shop;
    private ArrayList<Goods> shelf;

    public Consumer(Shop shop){
        this.shop = shop;
        this.shelf = shop.getGoodShelf();
    }

    public void run() {
        while (true){
            sell();
        }
    }

    /**
     * 向商店中取商品<br/>
     * 当商店没有商品时消费者不能取出商品<br/>
     */
    public void sell(){
        synchronized (shop){
            try {
                //如果商店里没有商品的话消费者放弃取商品
                if(shelf.size()==0){
                    shop.wait();
                }
                Goods goods = shelf.remove(0);//取得商品
                System.out.println("===========Consumer============");
                //打印商品信息
                goods.goodsInfo();
                System.out.println("===============================");
                //线程睡眠2秒保证更容易观察到输出结果
                Thread.sleep(2000);
                //通知生产者可以放商品到商店了
                shop.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

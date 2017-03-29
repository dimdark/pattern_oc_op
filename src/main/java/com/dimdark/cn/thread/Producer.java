package com.dimdark.cn.thread;

import com.dimdark.cn.model.Goods;
import com.dimdark.cn.model.Shop;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * 生产者:产生一个商品存到商店中<br/>
 * 为了维持商店只有一个商品,当商店有商品时,生产者不能将
 * 商品存到商店中<br/>
 * @author dimdark
 * @date 2017-03-29
 * @time 12:12 AM
 */
public class Producer implements Runnable {

    private Shop shop;
    private ArrayList<Goods> shelf;

    public Producer(Shop shop){
        this.shop = shop;
        this.shelf = shop.getGoodShelf();
    }

    public void run() {
        while (true){
            stock();
        }
    }

    /**
     * 产生商品并存到商店中<br/>
     * 当商店中有商品时不能将商品存到商店中<br/>
     */
    private void stock(){
        Goods goods = createGoods();
        synchronized (shop){
            try {
                //如果商店有商品的话就不能向商店添加商品了(维持商店的商品数量始终为1)
                if(shelf.size()==1){
                    try {
                        shop.wait();//放弃获得的shop对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //将商品添加到商店中
                shelf.add(goods);
                System.out.println("producer : add a goods to the shop");
                //线程休息2秒保证更容易观察到输出结果
                Thread.sleep(2000);
                //通知消费者可以从商店中取商品了
                shop.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 产生一个商品<br/>
     * @return Goods对象
     */
    private Goods createGoods(){
        double price = (double)((int)(Math.random()*100)+1);
        String manufactureDateString = "Wed 2016-07-18 23:00";
        String qualityGuaranteePeriod = "Two Years";
        Goods goods = null;
        try {
            goods = new Goods(price,manufactureDateString,qualityGuaranteePeriod);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return goods;
    }

}

package com.dimdark.cn.model;

import java.util.ArrayList;

/**
 * 商店对象:存放商品Goods对象<br/>
 * 注意:在本项目中商店只能存放一个Goods对象(简化)<br/>
 * @author dimdark
 * @date 2017-03-29
 * @time 12:06 AM
 */
public class Shop {

    private final ArrayList<Goods> goodShelf;

    public Shop(){
        goodShelf = new ArrayList<Goods>(1);
    }

    public ArrayList<Goods> getGoodShelf() {
        return goodShelf;
    }

}

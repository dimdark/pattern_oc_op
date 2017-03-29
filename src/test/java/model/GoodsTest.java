package model;


import com.dimdark.cn.model.Goods;
import org.junit.Test;

import java.text.ParseException;

/**
 * 测试Goods类
 * @author dimdark
 * @date 2017-03-28
 * @time 11:43 PM
 */
public class GoodsTest {

    @Test
    public void goodsTest(){
        double price = 2.0d;
        String manufactureDateString = "Wed 2016-07-18 23:00";
        String qualityGuaranteePeriod = "Two Years";
        try {
            Goods goods = new Goods(price,manufactureDateString,qualityGuaranteePeriod);
            System.out.println("该商品的价格" + "------>￥" + goods.getPrice());
            System.out.println("该商品的生产日期" + "------>" + goods.getManufactureDateString());
            System.out.println("该商品的保质期" + "------>" + goods.getQualityGuaranteePeriod());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}

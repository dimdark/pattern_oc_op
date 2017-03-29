package com.dimdark.cn.model;

import com.dimdark.cn.util.DateUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.text.ParseException;
import java.util.Date;

/**
 * Goods对象表示商店中存储的商品<br/>
 * 拥有价格、生产日期和保质期等属性<br/>
 * @author dimdark
 * @date 2017-03-28
 * @time 10:54 PM
 */
public class Goods {

    /**
     * 价格
     */
    private double price;
    /**
     * 生产日期
     */
    private Date manufactureDate;
    /**
     * 保质期
     */
    private String qualityGuaranteePeriod;

    /**
     * 注意:参数manufactureDateString表示生产日期的字符串格式,并且格式限制为
     * "EEEE yyyy-MM-dd HH:mm"形式<br/>
     * 如: July 2017-03-25 12:23<br/>
     * @param price double 价格
     * @param manufactureDateString String 生产日期的字符串格式
     * @param qualityGuaranteePeriod String 保质期
     */
    public Goods(double price,String manufactureDateString, String qualityGuaranteePeriod) throws ParseException{
        this(price,DateUtil.parse(manufactureDateString),qualityGuaranteePeriod);
    }

    /**
     * 商品的构造函数<br/>
     * @param price double 价格
     * @param manufactureDate String 生产日期
     * @param qualityGuaranteePeriod String 保质期
     */
    public Goods(double price, Date manufactureDate, String qualityGuaranteePeriod) {
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }

    public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    /**
     * 返回商品的生产日期指定格式的字符串对象<br/>
     * @return
     * @throws ParseException
     */
    public String getManufactureDateString() throws ParseException{
        return DateUtil.formatDate(manufactureDate);
    }

    /**
     * 根据字符串参数pattern设置商品的生产日期<b4r
     * @param pattern String 特定日期格式的字符串
     * @throws ParseException
     */
    public void setManufactureDateString(String pattern) throws ParseException{
        setManufactureDate(DateUtil.parse(pattern));
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * 打印出商品的详细信息<br/>
     * @return String对象
     */
    @SuppressWarnings("deprecation")
    public synchronized void goodsInfo(){
        System.out.printf("goods price ------> ￥%.2f\n",price);
        System.out.printf("goods manufactureDate ------> %s\n",manufactureDate.toLocaleString());
        System.out.printf("goods qualityGuaranteePeriod ------> %s\n",qualityGuaranteePeriod);
    }

}

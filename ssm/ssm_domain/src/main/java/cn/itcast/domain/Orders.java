package cn.itcast.domain;

import cn.itcast.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;//时间字符串
    private int orderStatus;
    private String orderStatusStr;//订单状态(0 未支付 1 已支付)
    private int peopleCount;
    private Integer payType;
    private String payTypeStr;//支付方式(0 支付宝 1 微信 2其它)
    private String orderDesc;

    private List<Traveller> travellers;
    private Member member;
    private Product product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) throws Exception {
        if(orderTime!=null){
            orderTimeStr = DateUtils.getString(orderTime, "yyyy年MM月dd日 HH:mm");
        }
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        return orderTimeStr;
    }

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        //订单状态(0 未支付 1 已支付)
        if(orderStatus>=0&&orderStatus<=2){
            if(orderStatus==0){
               orderStatusStr="未支付";
            }
            if(orderStatus==1){
                orderStatusStr="已支付";
            }
        }
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        if(payType!=null&&payType>=0&&payType<=2){
            //支付方式(0 支付宝 1 微信 2其它)
            if(payType==0){
               payTypeStr="支付宝";
            }else if(payType==1){
                payTypeStr="微信";
            }else if(payType==2){
                payTypeStr="其它";
            }
        }
        this.payType = payType;
    }

    public String getPayTypeStr() {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", peopleCount=" + peopleCount +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", travellers=" + travellers +
                ", member=" + member +
                ", product=" + product +
                '}';
    }
}

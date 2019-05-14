package com.studio.yishujutan.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private String order_id;
    private String buyer_id;
    private String seller_id;
    private String book_id;
    private String order_date;
    private double order_price;
    private String express_number;
    private String method;

    public Order() {
    }

    public Order(String order_id, String buyer_id, String seller_id, String book_id, String order_date, double order_price, String express_number, String method) {
        this.order_id = order_id;
        this.buyer_id = buyer_id;
        this.seller_id = seller_id;
        this.book_id = book_id;
        this.order_date = order_date;
        this.order_price = order_price;
        this.express_number = express_number;
        this.method = method;
    }
}

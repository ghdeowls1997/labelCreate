package com.label_gen.usps.domain.easypost.model;


import com.label_gen.usps.domain.easypost.net.EasyPostResource;

import java.util.List;

public class OrderCollection extends EasyPostResource {
  List<Order> orders;
  Boolean hasMore;

  public List<Order> getOrders() {
    return orders;
  }
  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}

package com.label_gen.usps.domain.easypost.model;

import com.label_gen.usps.domain.easypost.net.EasyPostResource;

import java.util.List;

public class PickupCollection extends EasyPostResource {
    List<Pickup> pickups;
    Boolean hasMore;

    public List<Pickup> getPickups() {
        return pickups;
    }
    public void setPickups(List<Pickup> pickups) {
        this.pickups = pickups;
    }
    public Boolean getHasMore() {
        return hasMore;
    }
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}

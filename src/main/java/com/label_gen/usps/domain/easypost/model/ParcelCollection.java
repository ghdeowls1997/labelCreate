package com.label_gen.usps.domain.easypost.model;

import com.label_gen.usps.domain.easypost.net.EasyPostResource;

import java.util.List;

public class ParcelCollection extends EasyPostResource {
  List<Parcel> parcels;
  Boolean hasMore;

  public List<Parcel> getParcels() {
    return parcels;
  }
  public void setParcels(List<Parcel> parcels) {
    this.parcels = parcels;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}

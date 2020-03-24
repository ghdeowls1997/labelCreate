package com.label_gen.usps.domain.easypost.model;
import com.label_gen.usps.domain.easypost.net.EasyPostResource;

import java.util.List;

public class ContainerCollection extends EasyPostResource {
  List<Container> containers;
  Boolean hasMore;

  public List<Container> getContainers() {
    return containers;
  }
  public void setContainers(List<Container> containers) {
    this.containers = containers;
  }
  public Boolean getHasMore() {
    return hasMore;
  }
  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}

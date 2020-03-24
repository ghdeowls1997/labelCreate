package com.label_gen.usps.domain.easypost.model;

import com.label_gen.usps.domain.easypost.net.EasyPostResource;

public class ApiKey extends EasyPostResource {
    String mode;
    String key;

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
}


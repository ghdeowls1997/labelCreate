package com.label_gen.usps.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ParcelParam {
    private String Lid;
    public String addressFromId;
    public String addressToId;
    private String parcelId;
    private Double length;
    private Double width;
    private Double height;
    private Double weight;

    public String name;
    public String company;
    public String street1;
    public String street2;
    public String city;
    public String state;
    public String zip;
    public String country;
    public String phone;
    public String email;

    public String namet;
    public String companyt;
    public String street1t;
    public String street2t;
    public String cityt;
    public String statet;
    public String zipt;
    public String countryt;
    public String phonet;
    public String emailt;
}

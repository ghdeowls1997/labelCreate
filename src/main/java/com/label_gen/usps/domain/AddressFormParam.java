package com.label_gen.usps.domain;

import lombok.*;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressFormParam {
    public String lidFrom;
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
    public String carrier_facility;
    public String residential;
    public String federal_tax_id;
    public String state_tax_id;
    public String verifications;

    public String lidTo;
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
    public String carrier_facilityt;
    public String residentialt;
    public String federal_tax_idt;
    public String state_tax_idt;
    public String verificationst;
    public Long HASHADDRESS;
}

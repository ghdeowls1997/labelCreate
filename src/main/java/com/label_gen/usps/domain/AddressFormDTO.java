package com.label_gen.usps.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressFormDTO {
    public boolean success;
    public String Lid;
    public String addressFromId;
    public String addressToId;
}

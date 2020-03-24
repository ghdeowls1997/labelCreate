package com.label_gen.usps.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParcelDTO {
    public boolean success;
    public String Lid;
    public String parcelId;
    public String addressFromId;
    public String addressToId;
}

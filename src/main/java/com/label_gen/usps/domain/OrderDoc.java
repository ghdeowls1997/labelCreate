package com.label_gen.usps.domain;

import javax.persistence.*;

import com.label_gen.usps.domain.jpa.CreatedAtListener;
import com.label_gen.usps.domain.jpa.UpdatedAtListener;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EntityListeners( { CreatedAtListener.class, UpdatedAtListener.class } )
public class OrderDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String name;
    public String addressFromId;
    public String addressToId;
    public String parcelId;
    public String labelURL;


//    @Column(name="l_id")
//    @Column(name = "name")

//    @Column(name = "addressFrom")
//    private Map<String, Object> addressFrom;


//    @Column(name = "addressTo")
//    @MapKeyColumn
//    private Map<String, Object> addressTo;

//    @Column(name= "parcel")
//    @MapKeyColumn
//    private Map<String, Object> parcel;

//    @Column(name ="labelImage")
//    @MapKeyColumn
//    private Map<String, Object> labelImage;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}

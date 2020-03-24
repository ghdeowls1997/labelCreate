package com.label_gen.usps.domain;
import com.label_gen.usps.domain.easypost.EasyPost;
import com.label_gen.usps.domain.easypost.exception.EasyPostException;
import com.label_gen.usps.domain.easypost.model.*;
import com.label_gen.usps.repository.LabelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class LabelService {

    @Autowired
    LabelRepository labelRepository;

    private final String ACCESS_KEY = "EZTKc42afb21955a4593a502909295cea26fJj5QI49O6NrITQRNrX0z4g";

    public ResponseEntity<AddressFormDTO> createLabel(AddressFormParam addressFormParam) {
        Map<String, Object> addressMapFrom = new HashMap<String, Object>();
        addressMapFrom.put("street1", addressFormParam.street1);
        addressMapFrom.put("street2", addressFormParam.street2);
        addressMapFrom.put("city", addressFormParam.city);
        addressMapFrom.put("state", addressFormParam.state);
        addressMapFrom.put("zip", addressFormParam.zip);
        addressMapFrom.put("country", addressFormParam.country);
        addressMapFrom.put("company", addressFormParam.company);
        addressMapFrom.put("phone", addressFormParam.phone);
        addressMapFrom.put("email", addressFormParam.email);
        addressMapFrom.put("carrierFacility", addressFormParam.carrier_facility);
        addressMapFrom.put("residential", addressFormParam.residential);
        addressMapFrom.put("federalTaxId", addressFormParam.federal_tax_id);

        Map<String, Object> addressMapTo = new HashMap<String, Object>();
        addressMapTo.put("street1", addressFormParam.street1t);
        addressMapTo.put("street2", addressFormParam.street2t);
        addressMapTo.put("city", addressFormParam.cityt);
        addressMapTo.put("state", addressFormParam.statet);
        addressMapTo.put("zip", addressFormParam.zipt);
        addressMapTo.put("country", addressFormParam.countryt);
        addressMapTo.put("company", addressFormParam.companyt);
        addressMapTo.put("phone", addressFormParam.phonet);
        addressMapFrom.put("email", addressFormParam.emailt);
        addressMapFrom.put("carrierFacility", addressFormParam.carrier_facilityt);
        addressMapFrom.put("residential", addressFormParam.residentialt);
        addressMapFrom.put("federalTaxId", addressFormParam.federal_tax_idt);

        List<String> verificationListFrom = new ArrayList<>();
        verificationListFrom.add("delivery");
        addressMapFrom.put("verify_strict", verificationListFrom);

        List<String> verificationListTo = new ArrayList<>();
        verificationListTo.add("delivery");
        addressMapTo.put("verify_strict", verificationListTo);

        String lidDoc;
        String fromId;
        String toId;
        try {
            Address addressFrom = Address.create(addressMapFrom);
            addressMapFrom.put("id", addressFrom.getId());
            fromId = addressFrom.getId();
            log.info("addressFrom verification details: {}", addressFrom.getVerifications());
            log.info("addressFrom ID: {}", fromId);

            Address addressTo = Address.create(addressMapTo);
            addressMapTo.put("id", addressTo.getId());
            toId = addressTo.getId();
            log.info("addressTo verification details: {}", addressTo.getVerifications());
            log.info("addressTo ID: {}", toId);

            OrderDoc newDoc = new OrderDoc();
            lidDoc = fromId + toId; //unique id for label
            newDoc.setId(lidDoc); // unique
            newDoc.setAddressFromId(fromId); //set AddressFromID
            newDoc.setAddressToId(toId); // set AddressToID
//            labelRepository.save(newDoc);
        } catch (EasyPostException e) {
            log.warn("failed to validate address: {}", (Object) e.getStackTrace());
            return new ResponseEntity<>(AddressFormDTO.builder().success(false).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(AddressFormDTO.builder().success(true).Lid(lidDoc).addressFromId(fromId).addressToId(toId).build(), HttpStatus.OK);
    }

    public ResponseEntity<ResultDTO> createParcel(ParcelParam parcelParam) {
        Map<String, Object> parcelMap = new HashMap<String, Object>();
        parcelMap.put("height", parcelParam.getHeight());
        parcelMap.put("width", parcelParam.getWidth());
        parcelMap.put("length", parcelParam.getLength());
        parcelMap.put("weight", parcelParam.getWeight());
        String parcelId;
        try {
            Parcel parcel = Parcel.create(parcelMap);
//            OrderDoc target = labelRepository.findOrderDocById(parcelParam.getLid());
//            target.setParcelId(parcel.getId());
            parcelId = (String) parcel.getId();
            return createLabel(parcelParam, parcel);
//            labelRepository.saveAndFlush(target); // set Parcel Map
        } catch (EasyPostException e) {
            log.warn("failed to create parcel: {}", (Object) e.getStackTrace());
            return new ResponseEntity<>(ResultDTO.builder().success(false).build(), HttpStatus.OK);
        }
    }

    public ResponseEntity<ResultDTO> createLabel(ParcelParam addressFormParam, Parcel parcel) {
//        OrderDoc target = labelRepository.findOrderDocById(LID);
        Map<String, Object> shipmentMap = new HashMap<String, Object>();
        shipmentMap.put("parcel", parcel);
        String labelUrl;
        try {
            Map<String, Object> addressMapFrom = new HashMap<String, Object>();
            addressMapFrom.put("street1", addressFormParam.street1);
            addressMapFrom.put("street2", addressFormParam.street2);
            addressMapFrom.put("city", addressFormParam.city);
            addressMapFrom.put("state", addressFormParam.state);
            addressMapFrom.put("zip", addressFormParam.zip);
            addressMapFrom.put("country", addressFormParam.country);
            addressMapFrom.put("company", addressFormParam.company);
            addressMapFrom.put("phone", addressFormParam.phone);
            addressMapFrom.put("email", addressFormParam.email);


            Map<String, Object> addressMapTo = new HashMap<String, Object>();
            addressMapTo.put("street1", addressFormParam.street1t);
            addressMapTo.put("street2", addressFormParam.street2t);
            addressMapTo.put("city", addressFormParam.cityt);
            addressMapTo.put("state", addressFormParam.statet);
            addressMapTo.put("zip", addressFormParam.zipt);
            addressMapTo.put("country", addressFormParam.countryt);
            addressMapTo.put("company", addressFormParam.companyt);
            addressMapTo.put("phone", addressFormParam.phonet);
            addressMapFrom.put("email", addressFormParam.emailt);


            shipmentMap.put("to_address", addressMapFrom);
            shipmentMap.put("from_address", addressMapTo);

            Shipment shipment = Shipment.create(shipmentMap);
//            String rateId = shipment.getRates().get(0).id; // choose first elem, carrier defaults to USPS //
            List<String> buyCarriers = new ArrayList<>();
            buyCarriers.add("USPS");
            List<String> buyServices = new ArrayList<>();
            buyServices.add("First");
            shipment.buy(shipment.lowestRate(buyCarriers, buyServices)); // get the lowest possible
//            labelUrl = shipment.getLabelUrl();
            PostageLabel label = shipment.getPostageLabel();
            labelUrl = label.getLabelUrl();
            log.info("label url is : {}", label.getLabelUrl());
            log.info("label url is : {}", label.getLabelPdfUrl());
            log.info("label is: {}", label);
        } catch (EasyPostException e) {
            log.warn("failed to create shipment: {}", (Object) e.getStackTrace());
            return new ResponseEntity<>(ResultDTO.builder().success(false).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultDTO.builder().success(true).labelUrl(labelUrl).build(), HttpStatus.OK);
    }
}

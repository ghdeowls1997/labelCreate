package com.label_gen.usps.controller;

import com.label_gen.usps.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value="/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @CrossOrigin
    @PostMapping(value = "/address", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, headers = "Accept=application/json")
    public ResponseEntity<AddressFormDTO> createLabel(@RequestBody AddressFormParam addressFormParam) {
        return labelService.createLabel(addressFormParam);
    }
//ResponseEntity<AddressFormDTO>
    @PostMapping(value = "/parcel")
    public ResponseEntity<ResultDTO> createParcel(@RequestBody ParcelParam parcelParam) {
        return labelService.createParcel(parcelParam);
    }

//    @PostMapping(value = "/generate")
//    public ResponseEntity<ResultDTO> generateLabel(@RequestParam String LID) {
//        return labelService.createLabel(LID);
//    }
}

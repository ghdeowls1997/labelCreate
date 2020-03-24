package com.label_gen.usps.repository;

import com.label_gen.usps.domain.AddressFormParam;
import com.label_gen.usps.domain.OrderDoc;
import com.label_gen.usps.domain.easypost.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface LabelRepository extends JpaRepository<OrderDoc, String> {
    public OrderDoc findOrderDocById(String lid);
}

package com.mk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    private BigDecimal orderPrice;
    @ManyToOne
    private Product product;

}

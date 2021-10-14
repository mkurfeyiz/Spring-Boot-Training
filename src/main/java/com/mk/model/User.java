package com.mk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String fullname;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "user")
    private Set<Orders> orders = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "ordered_products",
            joinColumns = {@JoinColumn(name = "user_id",
                    referencedColumnName = "id"
            ), @JoinColumn(name = "fullname",
                    referencedColumnName = "fullname")
            },
            inverseJoinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Orders> orderedProducts = new HashSet<>();
}

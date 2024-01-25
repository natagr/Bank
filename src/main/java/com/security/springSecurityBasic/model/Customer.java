package com.security.springSecurityBasic.model;

import com.security.springSecurityBasic.model.base.AbstractIdentifiable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends AbstractIdentifiable {

    private String email;

    private String pwd;

    private String role;

}

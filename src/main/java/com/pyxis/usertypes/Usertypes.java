/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.usertypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author suresh
 */
@Entity
@Table(name="user_types")
public class Usertypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="typesno")
    private Long typesno;
    
    @Column(name="usertype")
    private String usertype;

    /**
     * @return the typesno
     */
    public Long getTypesno() {
        return typesno;
    }

    /**
     * @param typesno the typesno to set
     */
    public void setTypesno(Long typesno) {
        this.typesno = typesno;
    }

    /**
     * @return the usertype
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * @param usertype the usertype to set
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
}

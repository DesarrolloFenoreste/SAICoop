/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saicoop.modelo.dto.util;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo
 */
@XmlRootElement(name = "raiceNotice")
public class RaiceNotice implements Serializable {

    private List<String> raiceNotice;

    public RaiceNotice() {
    }

    public List<String> getRaiceNotice() {
        return raiceNotice;
    }

    public void setRaiceNotice(List<String> raiceNotice) {
        this.raiceNotice = raiceNotice;
    }

}

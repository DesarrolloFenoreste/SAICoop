
package com.saicoop.modelo.dto.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prometeo
 */
@XmlRootElement(name = "polizasDDTO")
public class PolizasDDTO implements Serializable {

    private Integer idorigenc;
    private String periodo;
    private Short idtipo;
    private Integer idpoliza;
    private Integer folio;
    private String idcuenta;
    private Short cargoabono;
    private BigDecimal monto;
    private Integer idorigenp;
    private Integer idproducto;
    private Integer idauxiliar;
    private String referencia;
    private String idorigena;
    private String concepto_mov;

    public PolizasDDTO() {
    }

    public PolizasDDTO(Integer idorigenc, String periodo, short idtipo, Integer idpoliza) {
        this.idorigenc = idorigenc;
        this.periodo = periodo;
        this.idtipo = idtipo;
        this.idpoliza = idpoliza;
    }

    @Override
    public String toString() {
        return "Polizas_DDTO{" + "idorigenc=" + idorigenc + ", periodo=" + periodo + ", idtipo=" + idtipo + ", idpoliza=" + idpoliza + ", folio=" + folio + ", idcuenta=" + idcuenta + ", cargoabono=" + cargoabono + ", monto=" + monto + ", idorigenp=" + idorigenp + ", idproducto=" + idproducto + ", idauxiliar=" + idauxiliar + ", referencia=" + referencia + ", idorigena=" + idorigena + ", concepto_mov=" + concepto_mov + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idorigenc;
        hash = 89 * hash + Objects.hashCode(this.periodo);
        hash = 89 * hash + this.idtipo;
        hash = 89 * hash + this.idpoliza;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PolizasDDTO other = (PolizasDDTO) obj;
        if (!Objects.equals(this.idorigenc, other.idorigenc)) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.idtipo, other.idtipo)) {
            return false;
        }
        return Objects.equals(this.idpoliza, other.idpoliza);
    }

    public Integer getIdorigenc() {
        return idorigenc;
    }

    public void setIdorigenc(Integer idorigenc) {
        this.idorigenc = idorigenc;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public short getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(short idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdpoliza() {
        return idpoliza;
    }

    public void setIdpoliza(Integer idpoliza) {
        this.idpoliza = idpoliza;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(String idcuenta) {
        this.idcuenta = idcuenta;
    }

    public short getCargoabono() {
        return cargoabono;
    }

    public void setCargoabono(short cargoabono) {
        this.cargoabono = cargoabono;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Integer getIdorigenp() {
        return idorigenp;
    }

    public void setIdorigenp(Integer idorigenp) {
        this.idorigenp = idorigenp;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getIdauxiliar() {
        return idauxiliar;
    }

    public void setIdauxiliar(Integer idauxiliar) {
        this.idauxiliar = idauxiliar;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getIdorigena() {
        return idorigena;
    }

    public void setIdorigena(String idorigena) {
        this.idorigena = idorigena;
    }

    public String getConcepto_mov() {
        return concepto_mov;
    }

    public void setConcepto_mov(String concepto_mov) {
        this.concepto_mov = concepto_mov;
    }

}

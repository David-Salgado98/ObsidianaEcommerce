package org.obisidiana.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "confirm")
public class Confirm {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;


    @Column(name = "carrito_id")
    private Long carritoId;



    @Column(name = "clientes_id")
    private Long clientesId;
////////////////////////////////////////
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Long carritoId) {
        this.carritoId = carritoId;
    }

    public Long getClientesId() {
        return clientesId;
    }

    public void setClientesId(Long clientesId) {
        this.clientesId = clientesId;
    }
}

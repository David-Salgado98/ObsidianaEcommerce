package org.obisidiana.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Long id;


    @Column(name = "carrito_id")
    @JsonIgnore
    private Long carritoId;



    @OneToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    ///////////////////constructor/////////////////////

///////////////////get and set/////////////////////


    public Long getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Long carritoId) {
        this.carritoId = carritoId;
    }



    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}

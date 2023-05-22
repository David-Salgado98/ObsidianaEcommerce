package org.obisidiana.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "clientes")

public class Clientes {
    public static final int FIELD_MAX_LENGTH = 160;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "cliente_id")
    private Long id;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnore
    private String password;
    private String email;
  /*  @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;*/

    @Column(name = "confirm_id")
    private Long confirmId;

    @JsonIgnore
    @OneToMany(mappedBy = "clientes",fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    ///////////////////Constructor/////////////////////

    public Clientes() {
    }

    public Clientes(Long id, String username, String password, String email, Long confirmId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.confirmId = confirmId;
    }

    ///////////////////Get and Set/////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(Long confirmId) {
        this.confirmId = confirmId;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}

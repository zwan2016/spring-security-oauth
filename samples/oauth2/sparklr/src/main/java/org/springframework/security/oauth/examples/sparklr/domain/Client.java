package org.springframework.security.oauth.examples.sparklr.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by zwan on 1/13/20.
 */

@Entity
@Table(name = "oauth_client")
public class Client {
    @Id
    @GeneratedValue
    @Column(length = 50, unique = true, nullable = false)
    private Long id;

    @NotNull
    @Pattern(regexp = "^[_.@A-Za-z0-9-]*$")
    @Size(min = 1, max = 50)
    @Column(name = "client_name", length = 50, nullable = false)
    private String clientName;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "client_domain", length = 60, nullable = false)
    private String clientDomain;

    @Email
    @Size(min = 5, max = 254)
    @Column(name = "contact_email", length = 254, unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientDomain() {
        return clientDomain;
    }

    public void setClientDomain(String clientDomain) {
        this.clientDomain = clientDomain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

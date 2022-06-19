
package com.redLink.gestionDeCompras.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  //  private UUID id;
    private Long id;
}

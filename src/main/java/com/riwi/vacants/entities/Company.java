package com.riwi.vacants.entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name ="company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    @Column(length = 40,nullable = false)
    private String name;
    @Column(length = 60, nullable = false)
    private String location;
    @Column(length = 15, nullable = false)
    private String contact;

    //Una empresa puede tener muchas vacantes
    @OneToMany(mappedBy = "company",fetch=FetchType.EAGER,
     cascade = CascadeType.ALL,
     orphanRemoval =false )//MappedBy:debemos especificar en que propiedad se està mapeando en la otra entidad. //CascadeAll: especificamos que tendrà todos los tipos de cascada . //OrphanRemoval : especifica que un objeto huerfano(sin llave foranea) será eliminado
    
    @ToString.Exclude //excluimos esta propiedad del to string
    @EqualsAndHashCode.Exclude //excluimos las propiedades dentro de la lista
    private java.util.List<Vacant> vacants;

}

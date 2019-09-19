package pt.home.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owners")
@EqualsAndHashCode(exclude = {"pets"})
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String adress, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = adress;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();
}

package pt.home.sfgpetclinic.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Owner extends Person {

    private String adress;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();
}

package pt.home.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pt.home.sfgpetclinic.model.*;
import pt.home.sfgpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Joao");
        owner1.setLastName("Sousa");
        owner1.setAddress("Rua da Escola 12");
        owner1.setCity("Porto");
        owner1.setTelephone("123456798");

        Pet joaoPet = new Pet();
        joaoPet.setPetType(savedDogPetType);
        joaoPet.setOwner(owner1);
        joaoPet.setBirthDate(LocalDate.now());
        joaoPet.setName("Bolinhas");
        owner1.getPets().add(joaoPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ana");
        owner2.setLastName("Maria");
        owner2.setAddress("Rua da Escola 13");
        owner2.setCity("Porto");
        owner2.setTelephone("987654321");

        Pet anaPet = new Pet();
        anaPet.setPetType(savedCatPetType);
        anaPet.setOwner(owner2);
        anaPet.setBirthDate(LocalDate.now());
        anaPet.setName("Fuinha");
        owner2.getPets().add(anaPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(anaPet);
        catVisit.setDescription("Diarreia violenta.");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jose");
        vet1.setLastName("Veterinario");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Carla");
        vet2.setLastName("Veterinaria");
        vet2.getSpecialties().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets.");
    }
}

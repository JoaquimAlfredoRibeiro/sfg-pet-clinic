package pt.home.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.home.sfgpetclinic.model.Owner;
import pt.home.sfgpetclinic.repositories.OwnerRepository;
import pt.home.sfgpetclinic.repositories.PetRepository;
import pt.home.sfgpetclinic.repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Mota";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner owner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner mota = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, mota.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).city("Porto").build());
        owners.add(Owner.builder().id(2l).city("Lisboa").build());

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> returnOwners = ownerSDJpaService.findAll();

        assertNotNull(returnOwners);
        assertEquals(2, returnOwners.size());
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));

        Owner owner2 = ownerSDJpaService.findById(1l);

        assertEquals(new Long(1), owner2.getId());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner owner2 = ownerSDJpaService.save(owner);

        assertNotNull(owner2);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(Owner.builder().id(1L).lastName(LAST_NAME).build());

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository, times(1)).deleteById(any());
    }
}
package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialitesService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialitesService specialitesService;
	private final VisitService visitService;

	/**
	 * @param ownerService
	 * @param vetService
	 */
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialitesService specialitesService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitesService = specialitesService;
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
		PetType dog = PetType.builder().name("Dog").build();
		PetType savedDog = petTypeService.save(dog);

		PetType cat = PetType.builder().name("Cat").build();
		PetType savedCat = petTypeService.save(cat);

		Speciality speciality1 = Speciality.builder().despcription("Radiology").build();
		Speciality savedSpeciality1 = specialitesService.save(speciality1);

		Speciality speciality2 = Speciality.builder().despcription("Surgery").build();
		Speciality savedSpeciality2 = specialitesService.save(speciality2);

		Speciality speciality3 = Speciality.builder().despcription("Dentistry").build();
		Speciality savedSpeciality3 = specialitesService.save(speciality3);

		Owner owner1 = Owner.builder().firstName("Michael").lastName("Weston").address("Fake St. 123")
				.city("Evergreen Terrace Phase 1").telephone("555-000-6969").build();

		Pet mikesPet = Pet.builder().name("Rosco").petType(savedDog).birthDate(LocalDate.now()).owner(owner1).build();

		owner1.getPets().add(mikesPet);
		ownerService.save(owner1);

		Owner owner2 = Owner.builder().firstName("Fiona").lastName("Glenanne").address("Fake St. 456")
				.city("Evergreen Terrace Phase 2").telephone("555-999-6969").build();

		Pet fionasCat = Pet.builder().name("Missiu").petType(savedCat).birthDate(LocalDate.now()).owner(owner2).build();

		owner2.getPets().add(fionasCat);
		ownerService.save(owner2);

		Visit catVisit = Visit.builder().pet(fionasCat).date(LocalDate.now()).description("Sneezy Kitty").build();

		visitService.save(catVisit);

		Vet vet1 = Vet.builder().firstName("Sam").lastName("Axe").build();
		vet1.getSpecialites().add(savedSpeciality1);

		vetService.save(vet1);

		Vet vet2 = Vet.builder().firstName("Jessie").lastName("Porter").build();
		vet2.getSpecialites().add(savedSpeciality2);

		vetService.save(vet2);

		log.info("Data loaded successfully");
	}

}

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
		PetType dog = new PetType();
		dog.setName("Dog");

		PetType savedDog = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");

		PetType savedCat = petTypeService.save(cat);

		System.out.println("Loaded Pets Types....");

		Speciality speciality1 = new Speciality();
		speciality1.setDespcription("Radiology");
		Speciality savedSpeciality1 = specialitesService.save(speciality1);

		Speciality speciality2 = new Speciality();
		speciality2.setDespcription("Surgery");
		Speciality savedSpeciality2 = specialitesService.save(speciality2);

		Speciality speciality3 = new Speciality();
		speciality3.setDespcription("Dentistry");
		Speciality savedSpeciality3 = specialitesService.save(speciality3);

		System.out.println("Loaded Specialities....");

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("Fake St. 123");
		owner1.setCity("Evergreen Terrace Phase 1");
		owner1.setTelephone("555-000-6969");

		Pet mikesPet = new Pet();
		mikesPet.setName("Rosco");
		mikesPet.setPetType(savedDog);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setOwner(owner1);
		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("Fake St. 456");
		owner2.setCity("Evergreen Terrace Phase 2");
		owner2.setTelephone("555-999-6969");

		Pet fionasCat = new Pet();
		fionasCat.setName("Missiu");
		fionasCat.setPetType(savedCat);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setOwner(owner2);
		owner2.getPets().add(fionasCat);

		ownerService.save(owner2);

		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");

		visitService.save(catVisit);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialites().add(savedSpeciality1);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialites().add(savedSpeciality2);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}

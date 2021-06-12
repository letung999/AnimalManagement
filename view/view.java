package aboutAbstract.practiceInterface.Animal.view;

import aboutAbstract.practiceInterface.Animal.Type.Habitats;
import aboutAbstract.practiceInterface.Animal.Type.Reproductions;
import aboutAbstract.practiceInterface.Animal.Type.Types;
import aboutAbstract.practiceInterface.Animal.controller.DataController;
import aboutAbstract.practiceInterface.Animal.exception.InvalidIdPetException;
import aboutAbstract.practiceInterface.Animal.exception.InvalidNameException;
import aboutAbstract.practiceInterface.Animal.model.Pet;
import aboutAbstract.practiceInterface.Animal.sort.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class view {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var pet = new Pet();
        var dataController = new DataController();
        var fileName = "ANIMAL.DAT";
        var type = new Types();
        var habitats = new Habitats();
        var reproductions = new Reproductions();
        ArrayList<Pet> pets = new ArrayList<>();
        int option;
        do {
            System.out.println("***********************************Menu********************************");
            System.out.println("1.Add animal in list");
            System.out.println("2.show information animal in list");
            System.out.println("3.Sort Name Animal In List");
            System.out.println("4.Sort Height Animal ASC");
            System.out.println("5.Sort Height Animal DESC");
            System.out.println("6.Sort Weight Animal ASC");
            System.out.println("7.Sort Weight Animal DESC");
            System.out.println("8.Search Name Pets");
            System.out.println("9.Delete Pets By Id Pet");
            System.out.println("10.Update NamePets By Id Pet");
            System.out.println("0.exits");
            System.out.println("your option");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0: {
                    System.out.println("exits");
                    break;
                }
                case 1: {
                    if (pets.size() > 0) {
                        pets = dataController.readAnimalInFile(fileName);
                    } else {
                        //don't nothing
                    }
                    int chooseAnimals, chooseHabitats, chooseReproduction;
                    String idPet;
                    String animalName;
                    String species;
                    float height;
                    float weight;
                    String habitat;
                    String reproduction;
                    do {
                        System.out.println("Enter Id Pet");
                        idPet = scanner.nextLine();
                        if (dataController.checkExitElementInfile(pets, idPet) == false) {
                            try {
                                pet.setIdPet(idPet);
                            } catch (InvalidIdPetException e) {
                                e.printStackTrace();
                            }
                            break;
                        } else {
                            System.out.println("This Pet is exits in File");
                        }
                    } while (true);

                    System.out.println("Enter your Animal Name");
                    animalName = scanner.nextLine();
                    try {
                        pet.setAnimalName(animalName);
                    } catch (InvalidNameException e) {
                        System.out.println("Occur InvalidNameException");
                        System.out.println(e.getMessage());
                    }
                    do {
                        System.out.println("Enter Species");
                        System.out.println("1.BIRD\n2.MAMMAL\n3.REPTILE");
                        chooseAnimals = scanner.nextInt();
                        if (chooseAnimals >= 1 && chooseAnimals <= 3) {
                            species = type.getTypes(chooseAnimals);
                            pet.setSpecies(species);
                            break;
                        } else {
                            System.out.println("Animals is not Suitable");
                        }

                    } while (true);


                    System.out.println("Enter height( unit: cm)");
                    height = scanner.nextInt();
                    pet.setHeight(height);
                    System.out.println("Enter weight (unit: kg)");
                    weight = scanner.nextFloat();
                    pet.setWeight(weight);
                    do {
                        System.out.println("Enter Habitat");
                        System.out.println("1.ONTHETALLTREE\n2.LAND\n3.UNDERWATER");
                        chooseHabitats = scanner.nextInt();
                        if (chooseHabitats >= 1 && chooseHabitats <= 3) {
                            habitat = habitats.getHabitats(chooseHabitats);
                            pet.setHabitat(habitat);
                            break;
                        } else {
                            System.out.println("Habitats is not Suitable");
                        }

                    } while (true);
                    do {
                        System.out.println("Enter Reproduction");
                        System.out.println("1.CUB\n2.OVIPOSIT");
                        chooseReproduction = scanner.nextInt();
                        if (chooseReproduction >= 1 && chooseReproduction <= 2) {
                            reproduction = reproductions.getReproduction(chooseReproduction);
                            pet.setReproduction(reproduction);
                            break;
                        } else {
                            System.out.println("Reproduction is not Suitable");
                        }

                    } while (true);
                    pets.add(pet);
                    dataController.writeAnimalInFile(pets, fileName);
                    break;
                }
                case 2: {
                    System.out.println("*********************************MENU**************************************");
                    pets = dataController.readAnimalInFile(fileName);
                    dataController.showInfo(pets);
                    break;
                }
                case 3: {
                    pets = dataController.readAnimalInFile(fileName);
                    System.out.println("******************************Sort By Name Animal****************************");
                    Collections.sort(pets, new SortNameAnimal());
                    dataController.showInfo(pets);
                    break;
                }
                case 4: {
                    pets = dataController.readAnimalInFile(fileName);
                    System.out.println("*********************Sort Height Animal ASC*********************");
                    Collections.sort(pets, new SortHeightAsc());
                    dataController.showInfo(pets);
                    break;
                }
                case 5: {
                    pets = dataController.readAnimalInFile(fileName);
                    System.out.println("**********************Sort Height Animal DESC******************");
                    Collections.sort(pets, new SortHeightDesc());
                    dataController.showInfo(pets);
                    break;
                }
                case 6: {
                    pets = dataController.readAnimalInFile(fileName);
                    System.out.println("**********************Sort Weight Animal ASC********************");
                    Collections.sort(pets, new SortWeightAsc());
                    dataController.showInfo(pets);
                    break;
                }
                case 7: {
                    pets = dataController.readAnimalInFile(fileName);
                    System.out.println("********************Sort Weight Animal DESC********************");
                    Collections.sort(pets, new SortWeightDesc());
                    dataController.showInfo(pets);
                    break;
                }
                case 8: {
                    pets = dataController.readAnimalInFile(fileName);
                    var result = new ArrayList<Pet>();
                    System.out.println("Enter Name Pets to Search");
                    String name = scanner.nextLine();
                    result = dataController.searchNamePet(pets, name);
                    if (result.size() == 0) {
                        System.out.println("No Information to Search");
                    } else {
                        System.out.println("*********************Result*********************");
                        dataController.showInfo(result);
                    }
                    break;
                }
                case 9: {
                    pets = dataController.readAnimalInFile(fileName);
                    String idPet;
                    System.out.println("Enter Id Pet to Delete");
                    idPet = scanner.nextLine();
                    pets = dataController.deleteElement(pets, idPet);
                    dataController.writeAnimalInFile(pets, fileName);
                    dataController.showInfo(pets);
                    break;
                }
                case 10: {
                    pets = dataController.readAnimalInFile(fileName);
                    System.out.println("********************Information Pet In File***********************");
                    dataController.showInfo(pets);
                    String idPet, namePet;
                    System.out.println("Enter ID Pet To Set");
                    idPet = scanner.nextLine();
                    if(dataController.checkExitElementInfile(pets,idPet) == false) {
                        System.out.println("idPet isn't exits");
                        break;
                    }
                    System.out.println("Enter Name Pet To Set");
                    namePet = scanner.nextLine();
                    pets = dataController.updateNamePets(pets, idPet, namePet);
                    dataController.showInfo(pets);
                    dataController.writeAnimalInFile(pets, fileName);
                    break;

                }
            }


        } while (option != 0);
    }
}

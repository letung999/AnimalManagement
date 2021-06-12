package aboutAbstract.practiceInterface.Animal.controller;

import aboutAbstract.practiceInterface.Animal.InterfaceFunction.Function;
import aboutAbstract.practiceInterface.Animal.exception.InvalidNameException;
import aboutAbstract.practiceInterface.Animal.model.Pet;

import java.io.*;
import java.util.ArrayList;

public class DataController implements Function {
    @Override
    public void writeAnimalInFile(ArrayList<Pet> pets, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pets);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Pet> readAnimalInFile(String fileName) {
        ArrayList<Pet> pets = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            pets = (ArrayList<Pet>) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pets;
    }

    @Override
    public void showInfo(ArrayList<aboutAbstract.practiceInterface.Animal.model.Pet> pets) {
        System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s\n", "ID PET",
                "ANIMALNAME", "SPECIES", "HEIGHT(cm)", "WEIGHT(kg)", "HABITAT", "REPRODUCTION");
        for (var pet : pets) {
            System.out.printf("%-20s%-30s%-20s%-20s%-20s%-20s%-20s\n",
                    pet.getIdPet(), pet.getAnimalName(), pet.getSpecies(), pet.getHeight(),
                    pet.getWeight(), pet.getHabitat(), pet.getReproduction());
        }
    }

    @Override
    public boolean checkExitElementInfile(ArrayList<Pet> pets, String idPet) {
        for (var pet : pets) {
            if (pet.getIdPet().equals(idPet) == true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Pet> searchNamePet(ArrayList<Pet> pets, String name) {
        ArrayList<Pet> results = new ArrayList<>();
        String regex = ".*" + name.toLowerCase() + ".*.*";
        for (int i = 0; i < pets.size(); ++i){
            if(pets.get(i).getAnimalName().toLowerCase().matches(regex)){
                results.add(pets.get(i));
            }
        }
        return results;
    }

    @Override
    public ArrayList<Pet> deleteElement(ArrayList<Pet> pets, String idPet) {
        if(checkExitElementInfile(pets,idPet) == false) {
            System.out.println("idPet isn't exits");
        }
        for (int i = 0; i <pets.size(); ++i){
            if(pets.get(i).getIdPet().equals(idPet) == true){
                pets.remove(pets.get(i));
            }
        }
        return pets;
    }

    @Override
    public ArrayList<Pet> updateNamePets(ArrayList<Pet> pets, String idPet, String namePet) {
        for (int i = 0; i <pets.size(); ++i){
            if(pets.get(i).getIdPet().equals(idPet) == true){
                try {
                    pets.get(i).setAnimalName(namePet);
                } catch (InvalidNameException e) {
                    e.printStackTrace();
                }
            }
        }
        return pets;
    }

}

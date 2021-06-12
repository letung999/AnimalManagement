package aboutAbstract.practiceInterface.Animal.InterfaceFunction;


import aboutAbstract.practiceInterface.Animal.model.Pet;

import java.util.ArrayList;

public interface Function {
    /**
     *
     * @param pets
     * @param fileName
     * write animal in file by create a Object and List Pets then add Object in List.
     */
    void writeAnimalInFile(ArrayList<Pet> pets, String fileName);

    /**
     *
     * @param fileName
     * @return
     * read list Pets in File, return List Pets
     */
    ArrayList<Pet> readAnimalInFile(String fileName);

    /**
     * show information List Pet by row and column
     * @param pets
     */
    void showInfo(ArrayList<Pet> pets);

    /**
     * check exits id Pets in File, if exits, will announce and Enter again.
     * @param pets
     * @param idPet
     * @return
     */
    boolean checkExitElementInfile(ArrayList<Pet> pets, String idPet);

    /**
     * this method to search pet by name in list
     * input is name and out put list name
     * @param pets
     * @param name
     * @return
     */
    ArrayList<Pet> searchNamePet(ArrayList<Pet> pets, String name);

    /**
     * this method delete Pet by Id
     * input is idPet, output result List after delete
     * @param pets
     * @param idPet
     * @return
     */
    ArrayList<Pet> deleteElement(ArrayList<Pet> pets, String idPet);

    /**
     * this is method up date name Pet by search id pet and set element at this location
     * @param pets
     * @param idPet
     * @param namePet
     * @return
     */
    ArrayList<Pet> updateNamePets(ArrayList<Pet> pets, String idPet, String namePet);



}

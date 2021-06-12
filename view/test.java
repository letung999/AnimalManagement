package aboutAbstract.practiceInterface.Animal.view;

import aboutAbstract.practiceInterface.Animal.exception.InvalidIdPetException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //idPet = scanner.nextInt();
        String idPet = scanner.nextLine();
        String regex = "^\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(idPet);
        if (matcher.find()) {
            System.out.println(idPet);
        } else {
            System.out.println("sai");
        }

    }
}

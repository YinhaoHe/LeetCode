import java.util.Scanner;
import java.util.*;
public class Main {
    public static String getName(String str) {
        String[] names = str.trim().split(",");
        StringBuilder firstName = new StringBuilder(names[1].split(" ")[1].trim());
        StringBuilder lastName = new StringBuilder(names[0].split(" ")[0].trim()).reverse();
        return (firstName + " " + lastName).toString();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            // System.out.println(input.nextLine());
            System.out.println(getName(input.nextLine()));
        }
    }
}  
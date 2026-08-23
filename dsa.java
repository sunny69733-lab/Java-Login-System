import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class dsa {
    int employe_id;
    String name;
    String Station_id;// ng03 // ssk04//sp22

    public static void main(String[] args) {
        dsa info = new dsa();
        Scanner input = new Scanner(System.in);
        System.out.println("Practicing DSA ! ");
        ArrayList<String> emplys = new ArrayList<String>();
        while (true) {
            System.out.println("**********************Welcome*********************");
            System.out.println("Enter 1 to Add Emplyo info ! ");
            System.out.println("Enter 2 to view Emplyo info !");// also Sort them using collentions
            System.out.println("Enter 3 to Delete Emplyo info !");
            System.out.println("Enter 4 to change  or modify Emplyo info !");
            System.out.println("Enter 5 to Clear Emplyo info !");
            System.out.println("Enter 6 to know Wroking Staff Emplyo info !");
            int options = input.nextInt();
            switch (options) {
                case 1:
                    System.out.println("How Many Employes you want to add ! ");
                    int elements = input.nextInt();
                    for (int i = 1; i < elements; i++) {
                        System.out.println("Enter The Empplye Name At Index ! " + i + " : ");
                        String name = input.nextLine();
                        emplys.add(name);
                    }
                    System.out.println("Saved Succesfully ! ");
                    System.out.println("*******************************************");

                    break;
                case 2:
                    Collections.sort(emplys);
                    System.out.println("**************************View info ! ********************");
                    for (String elem : emplys) {
                        System.out.println(" " + elem);
                    }
                    System.out.println("*******************************************");
                    break;
                case 3:
                    System.out.println("Enter The Index ID to delete ! ");
                    int index = input.nextInt();
                    emplys.remove(index);
                    for (String ele : emplys) {
                        System.out.println("Your New  List ! ");
                        System.out.println(ele);
                    }
                    System.out.println("*******************************************");
                    break;
                case 4:
                    System.out.println("Enter The Index number to Change !  ");
                    int indexs = input.nextInt();
                    System.out.println("Enter The New Name !  ");
                    String new_name = input.nextLine();
                    emplys.set(indexs, new_name);
                    for (String elem : emplys) {
                        System.out.println(" Your New  List " + elem);
                    }
                    System.out.println("*******************************************");
                    break;
                case 5:
                    System.out.println("Are You Sure Your want to Delete !  Enter y/n");
                    String decision = input.nextLine();
                    if (decision != "y" || decision != "Y") {
                        emplys.clear();
                    } else {
                        for (String elem : emplys) {
                            System.out.println(" Your OLd  List " + elem);
                        }
                    }
                    System.out.println("*******************************************");
                    break;
                case 6 :
                    System.out.println("The Working Employes are ! ");
                    emplys.size();
                    System.out.println("*******************************************");
                    break;

                default:
                    System.out.println("Thanks for Coming ! ");;
            }
        }

    }
}
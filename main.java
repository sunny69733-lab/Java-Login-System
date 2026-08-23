
import java.util.ArrayList;
import java.util.Scanner;
public class main{
    public static void main(String[] args) {
        System.err.println("Print Arrays OF String and Integer ! ");
        Scanner input = new Scanner(System.in);
        ArrayList<String>DSM_name = new ArrayList<String>();
        ArrayList<Integer>DSM_id = new ArrayList<Integer>();
        while(true){
            System.err.println(" Enter 1 to add INFO about DSM name and ID");
            System.err.println(" Enter 2 to View INFO about DSM name and ID");
            System.out.print(" Enter Your Options ! ");
            int option = input.nextInt();
            
            switch (option) {
                case 1 :
                    System.out.println("Enter The Dsm name info 1 ! ");
                    int persons = input.nextInt();
                    for (int i = 0; i < persons; i++) {
                        String name = input.next();
                        DSM_name.add(name);
                    }
                    System.out.println("Now Enter ids ! ");
                    for (int i = 0; i < persons; i++) {
                        int id = input.nextInt();
                        DSM_id.add(id);
                    }
                    System.out.println("Saved Succesfully ! ");
                    break;
                    case 2 : 
                    System.out.println("View Info ! ");
                    System.out.println("Enter The Person You Want to View ! ");

                   // int person = input.nextInt();
                    for (int i = 0; i < 1; i++) {
                        System.out.print("ID = "+DSM_id);
                    }
                default:
                    throw new AssertionError();
            }

        }

    }
}

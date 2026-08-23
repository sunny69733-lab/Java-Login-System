import java.util.ArrayList;
import java.util.Scanner;

public class contacts {
    static void Display() {
        System.out.println("Press 1 for Name ! ");
        System.out.println("Press 2 for Number ! ");
        System.out.println(": ");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> name = new ArrayList<String>();

        ArrayList<Integer> ph_number = new ArrayList<Integer>();
        ArrayList<Integer> index_number = new ArrayList<Integer>();
        System.out.println("Enter Your Contact Details ! ");
        // for (int i = 0; i < numbers; i++) {
        // System.out.print("Enter your Contact Name : ");
        // String nam = input.next();
        // name.add(nam);

        // System.out.println("Enter Your Contact Number ! ");
        // int num = input.nextInt();
        // ph_number.add(num);

        // }
        // System.out.println(" ");
        // System.out.println("View Your Info 1 ! ");
        // for (int i = 0; i < 1; i++) {
        // System.err.print(" " + name);
        // System.out.println(" ");
        // System.err.print(" " + ph_number);
        // }
        System.out.println("How Many Contacts  ? ");
        int number = input.nextInt();
        while (true) {

            System.out.println(" ");
            System.err.println("View Opitons ! ");
            System.out.println("Press 1 to ADD Contacts ! ");
            System.out.println("Press 2 to Edit Contacts ! ");
            System.out.println("Press 3 to Delete Contacts ! ");
            System.out.println("Press 4 to Serach Contacts ! ");
            System.out.println("Press 5 to View Contacts ! ");
            System.out.println("Press 6 to Exit Contacts ! ");

            System.out.println(" Enter Your Options ! ");
            int options = input.nextInt();

            switch (options) {
                case 1:
                    System.out.println("Enter Your Info Name and Phone Number ! ");

                    for (int i = 0; i < number; i++) {
                        System.out.println("Enter Your Index Number  ! ");
                        int index = input.nextInt();
                        index_number.add(index);

                        System.out.println("Enter Your Contact Name  ! ");
                        String nama = input.next();
                        name.add(nama);
                        System.out.println("Enter Your Contact Number ! ");
                        int num = input.nextInt();
                        ph_number.add(num);
                    }
                    System.out.println("Info Saved Sussefully ! ");

                    break;
                case 2:
                    System.out.println("Edit info ! ");
                    System.out.println("What you want to Edit ! ");
                    Display();
                    int options2 = input.nextInt();
                    if (options2 == 1) {
                        System.out.println("Enter Your Contact Name To Edit ! ");
                        String na = input.next();
                        System.out.println("Enter Your Index Value ! ");
                        int indexs = input.nextInt();
                        name.set(indexs, na);
                    } else if (options == 2) {
                        System.out.println("Enter Your Contact Number to edit !  ");
                        int num = input.nextInt();
                        System.out.println("Enter Your Index Value ! ");
                        int indexs = input.nextInt();
                        ph_number.set(indexs, num);
                    } else {
                        System.out.println("Enter Vaild Info ! ");
                        break;
                    }

                    System.out.println("Info Saved Sussefully ! ");
                    break;
                case 3:
                    System.out.println("Enter A Index Number to Delete ! ");
                    int delete = input.nextInt();
                    System.out.println("What You want to Delete ! ");
                    Display();
                    int option3 = input.nextInt();
                    if(option3 == 1 ){
                        name.remove(delete);
                    }
                    else if (option3 == 2 ){
                        ph_number.remove(delete);
                    }
                    
                    System.out.println("Info Saved Sussefully ! ");
                    break;
                case 4:
                    System.out.println("Seraching in Contacts ! ");

                    int Element = input.nextInt();
                    for(int i = 0 ; i < 1;i++){
                        System.err.printf("%-10d %-15s %-15s\n",
                         
                        index_number.get(Element),
                        name.get(Element),
                        ph_number.get(Element));
                    }
                    
                    
                    break;
                case 5:
                    System.out.println(" View Contact Info ALL ! ");
                    for (int i = 0; i < number; i++) {
                        // System.out.print(" " + name);
                        // System.out.println(" ");
                        // System.out.println(" " + ph_number);
                        // System.out.printf("%-10s\n", index_number);

                        // System.out.printf("%-10s\n", name);

                        // System.out.printf("%-10s \n",ph_number);

                        System.out.printf("%-10d %-15s %-15s\n",
                                index_number.get(i),
                                name.get(i),
                                ph_number.get(i));
                    }

                    System.out.println("Info Saved Sussefully ! ");
                    break;
                case 6:
                    System.out.println("Fuck You ! ");
                    break;

            }

        }

    }

}
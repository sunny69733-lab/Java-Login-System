import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// opening//closeing//kg/kg_sale//non_cash_sale(upi+sm+cc)//non_cash_kg
// cash_kg//cash_sale//manual//

// first user login seletie station and then ask info like maneger or dsm if dsm then enter There info like sale 
// maneger = ask sale total no of emplyess and then 
public class igl {

    static double kg(double opening, double closeing) {
        return closeing - opening;
    }

    static double kg_sale(double opening, double closeing) {

        return (closeing - opening) * 83.09;
    }

    static double non_cash_sale(double upi, double sm, double cc) {
        return upi + sm + cc;
    }

    static double non_cash_kg(double upi, double sm, double cc) {
        return (upi + sm + cc) / 83.09;
    }

    static double cash_kg(double opening, double closeing, double upi, double sm, double cc) {
        return ((closeing - opening)) - (upi + sm + cc) / 83.09;
    }

    static double cash_sale(double opening, double closeing, double upi, double sm, double cc) {
        return (((closeing - opening)) - (upi + sm + cc) / 83.09) * 83.09;
    }

    static int maunals(int manual) {
        return manual;
    }

    static double Salary(int no_days, int cl, double wages) {
        return (no_days + cl) * wages;
    }

    static double fetival_Salary(int no_days, int cl, double wages, int fetival,double fetival_Wage) {
        return ((no_days + fetival + cl) * wages)+fetival_Wage;
    };

    // functions which will use in dsm
    /// useess // smart card recharge using upi and sale info
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "Sunny*788";
        System.out.println("********************************Welcome to Sale APP ! ********************************");
        // This will store Station_info like station name and id
        Scanner input = new Scanner(System.in);
        ArrayList<String> DSM = new ArrayList<String>();

        LinkedList<String> Station_name = new LinkedList<String>();
        LinkedList<Integer> Station_ID = new LinkedList<Integer>();

        Station_name.add("Sari kale khan ");
        Station_ID.add(001);
        Station_name.add("IP State  ");
        Station_ID.add(002);
        Station_name.add("Shanti path ");
        Station_ID.add(003);
        Station_name.add("nagla machi  ");
        Station_ID.add(004);
        Station_name.add("R K Puram ");
        Station_ID.add(005);
        for (int i = 0; i < 5; i++) {
            System.out.println(Station_ID.get(i) + " = " + Station_name.get(i));
        }
        System.out.print("Enter your Station Name : ");
        String Station_names = input.nextLine();
        System.out.print("Enter your Station Id : ");
        int Station_IDs = input.nextInt();
        while (true) {
            System.out.println("Are You a maneger or DSM ! " + Station_names + " " + Station_IDs);
            String Choise = input.next();
            if (Choise.equals("DSM")) { // equals to helps to comparing two Strings
                System.out.println("Enter your name ! ");
                String name = input.next();
                DSM.add(name);

                while (true) {
                    System.out.println("Press 1 To Enter Sale Info ! ");
                    System.out.println("Press 2 To View  Sale  Info ! ");
                    System.out.println("Press 3 To Edit  Sale Info (not working) ! ");
                    System.out.println("Press 4 To Total  Sale Info (not working)! ");
                    System.out.println("Press 5 To Total  Salary  Info ! ");
                    System.out.println("Press 6 To Exit ! ");
                    System.out.print(" : ");
                    int options = input.nextInt();
                    switch (options) {
                        case 1:
                            System.out.println(
                                    "********************************Enter Your Sale Info ******************************** "
                                            + name);
                            String[] Dispender_No = { "1A", "1B", "2A", "2B", "3A", "3B", "4A", "4B", "5A", "5B", "6A",
                                    "6B", "7B",
                                    "7A" };
                            for (int i = 0; i < Dispender_No.length; i++) {
                                System.out.println(" " + Dispender_No[i]);
                            }
                            System.out.println("Enter Your Dispender No ! ");
                            String dispender = input.next();
                            System.out.println("Your Dispender No is " + dispender + "!");
                            System.out.println(
                                    "********************************Enter Your Sale info ! ******************************** ");
                            //// sale info by dsm
                            while (true) {

                                // kg sale
                                System.out.println("Enter Opening  ! ");
                                double opening = input.nextDouble();
                                System.out.println("Enter Closing  ! ");
                                double Closing = input.nextDouble();
                                System.out.println("Enter Your Manual Reading ! ");
                                int manual = input.nextInt();
                                System.out.println("Your Kg  ! " + kg(opening, Closing));
                                System.out.println("Your Kg  Sale  ! " + kg_sale(opening, Closing));
                                // non cash details
                                System.out.print("Enter UPI  :  ");
                                double upi = input.nextDouble();
                                System.out.print("Enter Smart Card  : ");
                                double sm = input.nextDouble();
                                System.out.print("Enter Credit Card   :  ");
                                double cc = input.nextDouble();
                                //
                                System.out.println(
                                        "********************************Your Non Cash Kg Sale Info   ! ********************************");
                                System.out.println("Your Non Cash Kg  = " + non_cash_kg(upi, sm, cc));
                                System.out.println("Your Non Cash Kg Sale = " + non_cash_sale(upi, sm, cc));
                                /// cash info
                                System.out.println(
                                        "********************************Your Cash Info ! ********************************");
                                System.out.println("Cash Kg = " + cash_kg(opening, Closing, upi, sm, cc));
                                System.out.println("Cash Sale = " + cash_sale(opening, Closing, upi, sm, cc));
                                System.out.println("Your Manaul = " + maunals(manual));
                                break;

                            }
                        case 2:
                            // System.out.println("Your Sale info ! ");
                            // System.out.println("your kg Sale " + kg(opening, options));

                            // // }
                            break;
                        case 3:
                            System.out.println("What Your want to edit ! ");
                            System.out.println("Enter 1 for Name !  ");
                            System.out.println("Enter 2 for exit !  ");
                            System.out.println(" : ");
                            int optionss = input.nextInt();

                            switch (optionss) {
                                case 1:
                                    System.out.println("Enter The Coreect nama ! ");
                                    String nam = input.next();
                                    System.out.println("Enter The Index Number Also !");
                                    int index = input.nextInt();

                                    DSM.set(index, nam);
                                    System.out.println("Saved Info Succesfully ! ");
                                    break;
                                case 2:
                                    System.out.println("Thanks For Coming ! ");
                                    break;

                                default:
                                    System.out.println("Enter a Vaild info  ! ");
                            }
                            break;
                        case 4:
                            // System.out.println("Enter Your name to know sale ! ");
                            // String dsm_name = input.next();
                            // for (int i = 0; i < 10; i++) {
                            // if(dsm_name==)
                            // };\
                            break;
                        // static double Salary(int no_days, int cl, double wages, int fetival) {
                        // return (no_days + fetival + cl) * wages;
                        // };
                        //
                        case 5:
                            System.out.println("View Your Salary ! ");
                            System.out.println("Enter Your No Of Working Days !  ");
                            int no_days = input.nextInt();
                            System.out.println("Enter Your No Of CL !  ");
                            int cl = input.nextInt();
                            System.out.println("Enter Your Wages per Day !  ");
                            double wages = input.nextInt();
                            System.out.println("Any Festival ( y/ n ) ! ");
                            String fet = input.next();
                            if (fet.equals("y")) {
                                System.out.println("Enter no of festival ! ");
                                int fetival = input.nextInt();
                                System.out.println("Enter fetival Wages per day ! ");
                                double fetival_Wage = input.nextDouble();
                                System.out.println("Your Total Monthly Salary is = "
                                        + fetival_Salary(no_days, cl, wages, fetival,fetival_Wage));

                            }
                            else if ( fet.equals("n")){
                                System.out.println("Your Total Monthly Salary is = " + Salary(no_days, cl, wages));
                            }
                            else {
                                System.out.println("Thanks for coming ! ");
                                break;
                            }

                    }

                }
            } else {
                System.out.println("Enter You Name ! ");
                String names = input.next();
                while (true) {
                    System.out.println("What You want to know ! " + " Mr " + names);
                    System.out.println("Press 1 for DSM Sale Info ! ");// connect with java sql to fetch info
                    System.out.println("Press 2 for Station Sale  Info ! ");// connect with java sql to fecth info
                    System.out.println("Press 3 for Working  Info ! ");//
                    System.out.println("Press 4 for Exit  ! ");// Exit
                    break;

                }
            }

        }
    }

}

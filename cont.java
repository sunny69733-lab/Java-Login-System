import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class cont {
    static void register(String username, int password) {

    }

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

    // static double Salary(int no_days, int cl, double wages) {
    //     return (no_days + cl) * wages;
    // } upcoming updates ! 

    // static double fetival_Salary(int no_days, int cl, double wages, int fetival, double fetival_Wage) {
    //     return ((no_days + fetival + cl) * wages) + fetival_Wage;
    // };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/igl";
        String user = "root";
        String pass = "Sunny*788";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("************* Welcome to IGL DATABASE ! ****************** ");
            System.out.println("Press 1 for Register ! ");
            System.out.println("Press 2 for Login ! ");
            System.out.println("Press 3 for Exit ! ");
            System.out.print("Enter Your Options  : ");
            int options = input.nextInt();
            switch (options) {
                case 1:
                    System.out.println("**************** Register Your ID ! ***************** ");
                    System.out.println("Enter Your Username ! ");
                    String username1 = input.next();
                    System.out.println("Enter Your Password ! ");
                    int password1 = input.nextInt();
                    String query = "INSERT INTO login_sys(username,password) VALUES (?,?) ";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, username1);
                    ps.setInt(2, password1);
                    ps.executeUpdate();
                    System.out.println("Registration Successfull ! ");
                    return;
                case 2:

                    System.out.println("********************** Login Page ***************");
                    System.out.println("Enter Your Username ! ");
                    String username2 = input.next();
                    System.out.println("Enter Your Password ! ");
                    int password2 = input.nextInt();
                    String query1 = "SELECT * FROM login_sys WHERE username=? AND password=?";
                    PreparedStatement ps1 = con.prepareStatement(query1);

                    ps1.setString(1, username2);
                    ps1.setInt(2, password2);

                    ResultSet rs = ps1.executeQuery();

                    if (rs.next()) {
                        System.out.println("✅ Login Successful!");
                        System.out.println("Press 1 for DSM  ! ");
                        System.out.println("Press 2 for Maneger/Techinician ! ");
                        int Optionss = input.nextInt();
                        if (Optionss == 1) {
                            while (true) {
                                ////////////////////////////////////////////////////////////////////////////////
                                /// ///////////////////////////////////////////////////////////////////////////
                                /// /////////////////////////////////////////////////////////////////////////////
                                System.out.println("***************** DSM SALE  MENU ********************");
                                System.out.println("Press 1 for Enter Sale info ! ");
                                System.out.println("Press 2 for View Sale info ! ");// upcming updates -> serach by date and name shift 
                                System.out.print(" : ");
                                int options1 = input.nextInt();
                                switch (options1) {
                                    case 1:
                                        System.out.println(
                                                "***************** DSM  SALE  INFO ***************************");
                                        System.out.println("Enter Your Name ! ");
                                        String name = input.next();
                                        System.out.println("Enter Your Shift : A <> B <> C <> ");
                                        String Shift = input.next();
                                        System.out.println("Your name  = " + name + " || " + " Shift =  " + Shift);
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
                                        String query2 = "INSERT INTO dsm_info1(name,Shift,opening, Closing,kg,kg_sale,upi,sm,cc,non_cash_kg,non_cash_sale,cash_kg,cash_sale,maunals ) VALUES (?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                                        PreparedStatement ps3 = con.prepareStatement(query2);

                                        // Set values
                                        ps3.setString(1, name);
                                        ps3.setString(2, Shift);
                                        ps3.setDouble(3, opening);
                                        ps3.setDouble(4, Closing);
                                        ps3.setDouble(5, kg(opening, Closing));
                                        ps3.setDouble(6, kg_sale(opening, Closing));
                                        ps3.setDouble(7, upi);
                                        ps3.setDouble(8, sm);
                                        ps3.setDouble(9, cc);
                                        ps3.setDouble(10, non_cash_kg(upi, sm, cc));
                                        ps3.setDouble(11, non_cash_sale(upi, sm, cc));
                                        ps3.setDouble(12, cash_kg(opening, Closing, upi, sm, cc));
                                        ps3.setDouble(13, cash_sale(opening, Closing, upi, sm, cc));
                                        ps3.setInt(14, manual);

                                        // Execute
                                        ps3.executeUpdate();

                                        System.out.println("✅ Data Inserted Successfully!");

                                        
                                    case 2:
                                        System.out.println(
                                                "****************************************** View Your Sale Info ! ******************************************** ");
                                        System.out.print("Enter Your Name : ");
                                        String dsm_name = input.next();
                                        System.out.print("Enter Your Shift : ");
                                        String dsm_Shift = input.next();
                                        String query6 = "Select * from dsm_info1 where name = ? and Shift = ? ";
                                        PreparedStatement ps6 = con.prepareStatement(query6);
                                        ps6.setString(1, dsm_name);
                                        ps6.setString(2, dsm_Shift);
                                        ResultSet rs6 = ps6.executeQuery();
                                        while (rs6.next()) {
                                            System.out.println(rs6.getString("name") + " | " + rs6.getString("shift")
                                                    + " | " + rs6.getDouble("opening") + " | "
                                                    + rs6.getDouble("Closing") + " | " + rs6.getDouble("kg") + " | "
                                                    + rs6.getDouble("kg_sale") + " | " + rs6.getDouble("upi") + " | "
                                                    + rs6.getDouble("sm") + " | " + rs6.getDouble("cc") + " | " +
                                                    rs6.getDouble("non_cash_kg") + " | "
                                                    + rs6.getDouble("non_cash_sale")
                                                    + " | " + rs6.getDouble("cash_kg") + " | "
                                                    + rs6.getDouble("cash_sale") + " | " + rs6.getInt("maunals"));
                                        }

                                    case 3:
                                        System.out.println("Thanks For Coming ! ");
                                        break;
                                }
                                break;
                            }
                            /// //////////////////////////////////////////////////////////////////////////// ////////////////////////////////////////////////////////////////////////////
                            /// 

                        } 
                        else if (Optionss == 2) {
                            System.out.println(
                                    "***************************** MANGENER AND TECHINICIAN DRIVEN MENU ! **********************");

                            System.out.println("Press 1 View All DSM Sale Info ! ");
                            System.out.println("Press 2 Search By Name ! ");
                            System.out.println("Press 3 Search By Shift ! ");
                            System.out.println("Press 4 Combine Shift Sale  !(UPI/CC/SM) ");
                            System.out.println("Press 5 RETURN   ! ");
                            System.out.print(" :  ");
                            int mangeer_options = input.nextInt();
                            switch (mangeer_options) {
                                case 1:
                                    System.out.println(
                                            "************************ VIEW ALL DSM SALE INFO *******************************");
                                    String query5 = "SELECT * FROM dsm_info1";
                                    PreparedStatement ps5 = con.prepareStatement(query5);
                                    ResultSet rs5 = ps5.executeQuery();

                                    while (rs5.next()) {// fectching info // opening,
                                                        // Closing,kg,kg_sale,upi,sm,cc,non_cash_kg,non_cash_sale,cash_kg,cash_sale,maunals
                                        System.out.println(rs5.getString("name") + " | " + rs5.getString("shift")
                                                + " | "
                                                + rs5.getDouble("opening") + " | " + rs5.getDouble("Closing") + " | "
                                                + rs5.getDouble("kg") + " | " + rs5.getDouble("kg_sale") + " | "
                                                + rs5.getDouble("upi") + " | " + rs5.getDouble("sm") + " | "
                                                + rs5.getDouble("cc") + " | " +
                                                rs5.getDouble("non_cash_kg") + " | " + rs5.getDouble("non_cash_sale")
                                                + " | " + rs5.getDouble("cash_kg") + " | " + rs5.getDouble("cash_sale")
                                                + " | "
                                                + rs5.getInt("maunals"));

                                    }
                                    return;

                                case 2:
                                    System.err.println(
                                            "************************ Search by  Name ! ************************ ");
                                    System.out.print("Enter DSM Name  : ");
                                    String Dsm_name1 = input.next();

                                    String query7 = "Select * from dsm_info1 where name = ?";
                                    PreparedStatement ps6 = con.prepareStatement(query7);
                                    ps6.setString(1, Dsm_name1);

                                    ResultSet rs7 = ps6.executeQuery();
                                    while (rs7.next()) {
                                        System.out.println(rs7.getString("name") + " | " + rs7.getString("shift")
                                                + " | " + rs7.getDouble("opening") + " | "
                                                + rs7.getDouble("Closing") + " | " + rs7.getDouble("kg") + " | "
                                                + rs7.getDouble("kg_sale") + " | " + rs7.getDouble("upi") + " | "
                                                + rs7.getDouble("sm") + " | " + rs7.getDouble("cc") + " | " +
                                                rs7.getDouble("non_cash_kg") + " | "
                                                + rs7.getDouble("non_cash_sale")
                                                + " | " + rs7.getDouble("cash_kg") + " | "
                                                + rs7.getDouble("cash_sale") + " | " + rs7.getInt("maunals"));
                                    }
                                    break;
                                case 3:
                                    System.err.println(
                                            "************************ Search by  Shift ! ************************");
                                    System.out.print("Enter Shift : ");
                                    String Shift8 = input.next();
                                    if (Shift8.equals("A")) {
                                        String query8 = "Select * from dsm_info1 where Shift = 'A' ";
                                        PreparedStatement ps8 = con.prepareStatement(query8);
                                        ps8.setString(1, Shift8);

                                        ResultSet rs8 = ps8.executeQuery();
                                        while (rs8.next()) {
                                            System.out.println(rs8.getString("name") + " | " + rs8.getString("shift")
                                                    + " | " + rs8.getDouble("opening") + " | "
                                                    + rs8.getDouble("Closing") + " | " + rs8.getDouble("kg") + " | "
                                                    + rs8.getDouble("kg_sale") + " | " + rs8.getDouble("upi") + " | "
                                                    + rs8.getDouble("sm") + " | " + rs8.getDouble("cc") + " | " +
                                                    rs8.getDouble("non_cash_kg") + " | "
                                                    + rs8.getDouble("non_cash_sale")
                                                    + " | " + rs8.getDouble("cash_kg") + " | "
                                                    + rs8.getDouble("cash_sale") + " | " + rs8.getInt("maunals"));
                                            break;
                                        }
                                    } else if (Shift8.equals("B")) {

                                        String query9 = "Select * from dsm_info1 where Shift = 'B' ";
                                        PreparedStatement ps9 = con.prepareStatement(query9);
                                        ps9.setString(1, Shift8);

                                        ResultSet rs9 = ps9.executeQuery();
                                        while (rs9.next()) {
                                            System.out.println(rs9.getString("name") + " | " + rs9.getString("shift")
                                                    + " | " + rs9.getDouble("opening") + " | "
                                                    + rs9.getDouble("Closing") + " | " + rs9.getDouble("kg") + " | "
                                                    + rs9.getDouble("kg_sale") + " | " + rs9.getDouble("upi") + " | "
                                                    + rs9.getDouble("sm") + " | " + rs9.getDouble("cc") + " | " +
                                                    rs9.getDouble("non_cash_kg") + " | "
                                                    + rs9.getDouble("non_cash_sale")
                                                    + " | " + rs9.getDouble("cash_kg") + " | "
                                                    + rs9.getDouble("cash_sale") + " | " + rs9.getInt("maunals"));
                                            break;
                                        }
                                    }
                                     else if (Shift8.equals("C")) {

                                        String query9 = "Select * from dsm_info1 where Shift = 'C' ";
                                        PreparedStatement ps9 = con.prepareStatement(query9);
                                        ps9.setString(1, Shift8);

                                        ResultSet rs9 = ps9.executeQuery();
                                        while (rs9.next()) {
                                            System.out.println(rs9.getString("name") + " | " + rs9.getString("shift")
                                                    + " | " + rs9.getDouble("opening") + " | "
                                                    + rs9.getDouble("Closing") + " | " + rs9.getDouble("kg") + " | "
                                                    + rs9.getDouble("kg_sale") + " | " + rs9.getDouble("upi") + " | "
                                                    + rs9.getDouble("sm") + " | " + rs9.getDouble("cc") + " | " +
                                                    rs9.getDouble("non_cash_kg") + " | "
                                                    + rs9.getDouble("non_cash_sale")
                                                    + " | " + rs9.getDouble("cash_kg") + " | "
                                                    + rs9.getDouble("cash_sale") + " | " + rs9.getInt("maunals"));
                                            break;
                                        }
                                    }
                                    else {
                                        System.out.println("NO DATA AVAILABLE AND INVAILD INPUT");
                                        break;
                                    }
                                    break;

                                case 4:
                                    System.out.println("***************** Know Total Shift Info *****************");
                                    System.out.println("Press 1 for Total KG Sale Of Your Shift          !  ");
                                    System.out.println("Press 2 for Total UPI Sale Of Your  Shift        !  ");
                                    System.out.println("Press 3 for Total Smart Card Sale Of Your Shift  !  ");
                                    System.out.println("Press 4 for Total Credit Card Sale Of Your Shift !  ");
                                    System.out.println("Press 5------------------ EXIT-------------------!  ");
                                    System.out.print(" : ");
                                    int options_man = input.nextInt();
                                    switch (options_man) {
                                        case 1:
                                            // count total kg
                                            System.out.print("Enter Your Shift ! ");
                                            String Shift9 = input.next();

                                            String query9 = "SELECT SUM(kg) FROM dsm_info1 WHERE shift = ? ";
                                            PreparedStatement ps9 = con.prepareStatement(query9);
                                            ps9.setString(1, Shift9);
                                            ResultSet rs9 = ps9.executeQuery();
                                            while (rs9.next()) {
                                                double totalKg = rs9.getDouble(1); // <-- FIX HERE
                                                System.out.println("Total KG: " + totalKg);
                                            }
                                            break;
                                        case 2:
                                            // Total UPI
                                            System.out.print("Enter Your Shift ! ");
                                            String Shift10 = input.next();
                                            String query10 = "Select SUM(upi) FROM dsm_info1 where shift = ? ";
                                            PreparedStatement ps10 = con.prepareStatement(query10);
                                            ps10.setString(1, Shift10);
                                            ResultSet rs10 = ps10.executeQuery();
                                            while (rs10.next()) {
                                                double totalupi = rs10.getDouble(1); // <-- FIX HERE
                                                System.out.println("Total UPI: " + totalupi);
                                            }
                                            break;
                                        case 3:
                                            // Total Smart Card
                                            System.out.print("Enter Your Shift ! ");
                                            String Shift11 = input.next();
                                            String query11 = "Select SUM(sm) FROM dsm_info1 where shift = ? ";
                                            PreparedStatement ps11 = con.prepareStatement(query11);
                                            ps11.setString(1, Shift11);
                                            ResultSet rs11 = ps11.executeQuery();
                                            while (rs11.next()) {
                                                double tsm = rs11.getDouble(1); // <-- FIX HERE
                                                System.out.println("Total SM: " + tsm);
                                            }
                                            break;
                                        case 4:
                                            // Total Credit Card
                                            System.out.print("Enter Your Shift ! ");
                                            String Shift12 = input.next();
                                            String query12 = "Select SUM(sm) FROM dsm_info1 where shift = ? ";
                                            PreparedStatement ps12 = con.prepareStatement(query12);
                                            ps12.setString(1, Shift12);
                                            ResultSet rs12 = ps12.executeQuery();
                                            while (rs12.next()) {
                                                double TCC = rs12.getDouble(1); // <-- FIX HERE
                                                System.out.println("Total Credit Card : " + TCC);
                                            }
                                            break;

                                        case 5:
                                            System.out.println("Thanks For Coming ! ");
                                            break;

                                    }

                                    break;
                                case 5:
                                    return;
                            }

                        }
                    } else {
                        System.out.println("❌ Invalid Username or Password");
                        break;
                    }

                    break;
                default:
                    System.out.println("Re Register Your Self ! ");
                    break;
            }

            con.close();
        } catch (

        Exception e) {
            System.out.println(e);
        }
    }
}

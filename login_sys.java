import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login_sys {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/login_sys";
        String user = "root";
        String pass = " MY SQL PASSWORD";
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("************* Welcome to Login System ! ****************** ");
            System.out.println("Press 1 for Register ! ");
            System.out.println("Press 2 for Login ! ");
            System.out.println("Press 3 for Change Username ! ");
            System.out.println("Press 4 for Change Password ! ");
            System.out.println("Press 5 for Exit ! ");
            System.out.print("Enter Your Options  : ");
            while (true) {
                int number = input.nextInt();
                System.out.print("Enter Your Options  : ");
                if (number == 1) {
                    System.out.println("Register Your Self ! ");
                    System.out.print("Enter Your New User Name ! ");
                    String username = input.next();
                    System.out.print("Enter Your New Password   ! ");
                    int password = input.nextInt();
                    String query = "Insert into user_info(username ,password) Values (?,?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, username);
                    ps.setInt(2, password);
                    ps.executeUpdate();
                    System.out.println("Now You Can Login ! ");
                } else if (number == 2) {
                    System.out.println("Login Your Self ! ");
                    System.out.print("Enter Your User Name ! ");
                    String username1 = input.next();
                    System.out.print("Enter Your Password  ! ");
                    int password1 = input.nextInt();
                    String query2 = "SELECT * FROM user_info WHERE username=? AND password=?";
                    PreparedStatement ps1 = con.prepareStatement(query2);
                    ps1.setString(1, username1);
                    ps1.setInt(2, password1);

                    ResultSet rs = ps1.executeQuery();
                    if (rs.next()) {
                        System.out.println("Login Successful!");
                        System.out.println("Thanks For Login ! ");
                        System.out.println("Keep waiting for future Updates ! ");
                    } else {
                        System.out.println("Invalid Username or Password!");
                    }

                } else if (number == 3) {
                    System.out.println("Change Your Username ! ");
                    System.out.print("Enter Your Old Username ! ");
                    String username2 = input.next();
                    System.err.print("Enter Your New Username ! ");
                    String username3 = input.next();
                    String query3 = "update user_info set username  = ? where  username= ?";
                    PreparedStatement ps2 = con.prepareStatement(query3);
                    ps2.setString(1, username3);
                    ps2.setString(2, username2);

                    int rows = ps2.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Username Changed Successfully!");
                        System.out.println("Your Data Saved Sucessfully  ! ");
                    } else {
                        System.out.println("Old Username Not Found!");
                    }

                } else if (number == 4) {
                    System.out.println("Change Your Password ! ");
                    System.out.print("Enter Your Username ! ");
                    String username4 = input.next();
                    System.err.print("Enter Your New password ! ");
                    int password4 = input.nextInt();
                    String query4 = "update user_info set password = ? where  username = ?";
                    PreparedStatement ps3 = con.prepareStatement(query4);
                    ps3.setInt(1, password4);
                    ps3.setString(2, username4);

                    int rows = ps3.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Password Changed Successfully!");
                        System.out.println("Your Data Saved Sucessfully  ! ");
                    } else {
                        System.out.println("Old Password Not Found!");
                    }

                } else if (number == 5) {
                    System.out.println("Thanks for coming ! ");
                    break;
                }
            }
            con.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
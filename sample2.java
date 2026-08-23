import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class sample2 {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/lms";
            String user = "root";
            String pass = "Sunny*788";
            Connection con = DriverManager.getConnection(url, user, pass);

            Scanner input = new Scanner(System.in);
            System.err.println("WElCOME TO Online Libary Management ! ");
            while (true) {
                System.out.println("Enter your Name ! ");
                String Name = input.next();
                System.out.println("Hey " + Name);
                System.out.println("What Do You Want !");
                System.out.println(" Press 1 ADD BOOKs ?");
                System.out.println(" Press 2 ISSUSE BOOKs ?");
                System.out.println(" Press 3 RETURN BOOKs ?");
                System.out.println(" Press 4 SEARCH BOOKs ?");
                System.out.println(" Press 5 DELETE BOOKs ?");
                System.out.println(" Press 6 VIEW   BOOKs ?");
                System.out.println(" Press 7 MEMBERS NAME ?");
                System.out.print(" : ");
                // book_id int PK
                // member_id int
                // book_name varchar(100)
                // auther_name varchar(100)
                // book_price
                int options = input.nextInt();
                if (options == 1) {
                    // add books
                    System.out.println("Enter BOOK_ID NAME = ");
                    String book_id = input.next();
                    System.out.println("Enter BOOK NAME = ");
                    String book_name = input.next();
                    System.out.println("Enter Auther's Book NAME = ");
                    String auther_name = input.next();
                    System.out.println("Enter BOOK PRICE  = ");
                    int book_price = input.nextInt();
                    String add_books = "Insert into lms_books_info  (book_id,book_name,auther_name,book_price) values (?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(add_books);
                    ps.setString(1, book_id);
                    ps.setString(2, book_name);
                    ps.setString(3, auther_name);
                    ps.setInt(4, book_price);
                    ps.executeUpdate();
                    System.out.println("DATA SAVED SUCCESSFULLY ! ");

                } else if (options == 2) {
                    // issuse books
                    System.out.println("Want to Issuse A book ! ");
                    System.out.println("We Have These BOOks Only ! ");
                    String view_books = " Select * from lms_books_info ";
                    PreparedStatement ps1 = con.prepareStatement(view_books);
                    ResultSet rs1 = ps1.executeQuery();
                    while (rs1.next()) {
                        System.out.println(rs1.getString("book_id") + "||" + rs1.getString("book_name") + "||"
                                + rs1.getString("auther_name") + "||" + rs1.getInt("book_price"));
                    }
                    System.out.println("Enter Book ID ! ");
                    int book_id = input.nextInt();
                    System.out.println("Enter ISSUSE DATE ! ");
                    int issuse_date = input.nextInt();
                    System.out.println("Enter Your Member ID ! ");
                    int member_id = input.nextInt();
                    System.out.println("Enter Your member_name ! ");
                    String member_name = input.nextLine();
                    System.out.println("Enter PHONE Number ! ");
                    int ph_no = input.nextInt();
                    String issuse_query = "INSERT INTO members_info " +
                            "(member_id, member_name, ph_no, issuse_date, returns) " +
                            "VALUES (?, ?, ?, ?, ?)"
                    ;
                    PreparedStatement ps5 = con.prepareStatement(issuse_query);
                    ps5.setInt(1, book_id);
                    ps5.setInt(2, member_id);
                    ps5.setString(3, member_name);

                    ps5.setInt(4, ph_no);
                    ps5.setObject(5, issuse_date);
                    ps5.executeUpdate();
                    System.out.println("DATA SAVED SUCCESSFULLY ! ");
                } else if (options == 3) {
                    // RETURN books
                    System.out.println("Thanks for Returing BOOKs ! ");
                    System.out.println("Enter Book ID ! ");
                    int book_id = input.nextInt();
                    System.out.println("Enter return DATE ! ");
                    int returns = input.nextInt();
                    System.out.println("Enter Your Member ID ! ");
                    int member_id = input.nextInt();

                    String issuse_query = "Select * from members_info where book_id = ? and member_id = ? add returns date ";
                    PreparedStatement ps5 = con.prepareStatement(issuse_query);
                    ps5.setInt(1, book_id);
                    ps5.setInt(2, member_id);
                    ps5.setObject(3, returns);
                    ps5.executeUpdate();
                    System.out.println("DATA SAVED SUCCESSFULLY ! ");
                } else if (options == 4) {
                    // SEARCH books
                    System.out.println("Enter your book name !  ");
                    String books_name = input.next();
                    String search_book = " select * from lms_books_info where book_name = ? ";
                    PreparedStatement ps1 = con.prepareStatement(search_book);

                    ps1.setString(1, books_name);

                    ResultSet rs = ps1.executeQuery();
                    System.out.println("WE have Found BOOk ! ");
                    if (rs.next()) {
                        System.out.println(rs.getString("book_id") + "||" + rs.getString("book_name") + "||"
                                + rs.getString("auther_name") + "||" + rs.getInt("book_price"));
                    } else {
                        System.out.println("Error Occoured ! ");
                    }
                } else if (options == 5) {
                    // DELETE books
                    System.out.println("Enter Your Book Id ! ");
                    int book_id = input.nextInt();
                    String dele_book = " delete from  lms_books_info where book_id = ?";
                    PreparedStatement ps9 = con.prepareStatement(dele_book);
                    ps9.setInt(1, book_id);
                    ps9.executeQuery();
                } else if (options == 6) {
                    // VIEW books
                    String query5 = "SELECT * FROM  lms_books_info";
                    PreparedStatement ps5 = con.prepareStatement(query5);
                    ResultSet rs5 = ps5.executeQuery();
                    while (rs5.next()) {
                        System.out.println(rs5.getString("book_id") + "||" + rs5.getString("book_name") + "||"
                                + rs5.getString("auther_name") + "||" + rs5.getInt("book_price"));
                    }
                    // member_id int PK
                    // ph_no varchar(100)
                    // member_name varchar(100)
                    // issuse_date date
                    // returns
                } else if (options == 7) {
                    // MEMBERS books
                    String query6 = "SELECT * FROM  members_info ";
                    PreparedStatement ps5 = con.prepareStatement(query6);
                    ResultSet rs5 = ps5.executeQuery();
                    while (rs5.next()) {
                        System.out.println(rs5.getInt("member_id") + "||" + rs5.getInt("ph_no") + "||"
                                + rs5.getString("member_name") + "||" + rs5.getInt("issuse_date") + "||"
                                + rs5.getString("returns"));
                    }
                } else {
                    System.out.println("Enter a Valid Input ! ");
                }
            }

        } catch (Exception e) {
            System.out.println("Failed To Connect DATABASE  ! ");
        }

    }
}
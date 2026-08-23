import java.util.Scanner;
import java.util.ArrayList;
import jvaa.util.list;

public class demoo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arry = {1,2,3,4,5,6,7,8,9,0};
        int result = 0;
        for (int i = 0; i < arry.length; i++) {
            result += arry[i];
            System.out.print("Sum of The Arry = "+ result);
        }


    }

}
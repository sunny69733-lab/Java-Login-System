public class new_ch {
    // cicle ka area ka parameters using class
    // area p*r*r

    static void area(int r, double pi) {
        double result = pi * (r * r);

        System.out.println("The Radius  = " + r);
        System.out.println("The area of Cirle is = " + result);
    }

    static void parameter(int r, double pi) {
        double result = (2 * pi) * r;
        System.out.println("The Radius  = " + r);
        System.out.println("The parameter of Cirle is = " + result);
    }

    public static void main(String[] args) {

        area(12, 3.14);
        parameter(12, 3.14);
    }
}
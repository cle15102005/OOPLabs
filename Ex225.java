import java.util.Scanner;
public class test {
	public static void main(String[] args) {
    Scanner nums = new Scanner(System.in);  // Create a Scanner object
    double num1= nums.nextInt();
    double num2= nums.nextInt();
    System.out.println(num1+num2);
    System.out.println(num1-num2);
    System.out.println(num1*num2);
    System.out.println(num1/num2);
    
    System.exit(0);
}
}
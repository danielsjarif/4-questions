//To run:
//Step 1: javac Prime.java
//Step 2: java Prime
//Step 3: First prompt, enter the nth prime number you want to find
//i.e., entering 5 in step 3 will give you the 5th prime which is 11.


import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
      //Used scanner to allow for user input through nextInt()
        Scanner input = new Scanner(System.in);
        int n,
        i = 2, nth_prime = 2;

        System.out.printf("Please enter the nth prime number you want to find:");
        n = input.nextInt();


        for(i = 0, nth_prime = 2; n > 0; i++) {
            for(nth_prime = 2; nth_prime < i; nth_prime++) {
                if(i % nth_prime == 0) {
                    break;
                }
            }
            if(nth_prime == i) {
                n--;
            }
        }
        System.out.printf("%d is the nth prime you are looking for", nth_prime);
    }
}

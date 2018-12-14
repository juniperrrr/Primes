
package project;

public class Game {
    
    int scoreCounter, tryAgain;
    int totalScore;
    
    boolean isInputPrimeNum(int n) {
        boolean isPrime = true;
        for (int i=2; i < n; i++) {
            if (n%i==0) {
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(n + " is a prime number");
            return false;
        }
        return true;
    }
    
    boolean isDivisibleNum(int dividend, int divisor){
        if(dividend % divisor == 0) {
            System.out.println(dividend + " / " + divisor + " = " + dividend / divisor);
        }
        else{
            System.out.println(dividend + " is not divisible by " + divisor);
            return true;
        }
        return false;
    }
    
}

import java.util.Scanner;

public class PrimeEvenThreads {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the lower bound: ");
    int lowerBound = scanner.nextInt();
    System.out.print("Enter the upper bound: ");
    int upperBound = scanner.nextInt();

    Thread primeThread = new Thread(new PrimeThread(lowerBound, upperBound));
    Thread evenThread = new Thread(new EvenThread(lowerBound, upperBound));

    primeThread.start();
    evenThread.start();
  }
}

class PrimeThread implements Runnable {
  private final int lowerBound;
  private final int upperBound;

  public PrimeThread(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  @Override
  public void run() {
    for (int i = lowerBound; i <= upperBound; i++) {
      if (isPrime(i)) {
        System.out.println("Prime: " + i);
      }
    }
  }

  private boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}

class EvenThread implements Runnable {
  private final int lowerBound;
  private final int upperBound;

  public EvenThread(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  @Override
  public void run() {
    for (int i = lowerBound; i <= upperBound; i++) {
      if (i % 2 == 0) {
        System.out.println("Even: " + i);
      }
    }
  }
}

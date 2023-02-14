import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int n = sc.nextInt();

        char[] vectGender = new char[n];
        double[] vectHeight = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Altura da " + (i + 1) + "a pessoa: ");
            sc.nextLine();
            vectHeight[i] = sc.nextDouble();
            System.out.print("Genero da " + (i + 1) + "a pessoa: ");
            vectGender[i] = sc.next().charAt(0);
        }

        double bigger = vectHeight[0];
        double smaller = vectHeight[0];
        for (int i = 1; i < n; i++) {
            if (vectHeight[i] > bigger) {
                bigger = vectHeight[i];
            }
            if (vectHeight[i] < smaller) {
                smaller = vectHeight[i];
            }
        }

        System.out.printf("Menor altura = %.2f%n", smaller);
        System.out.printf("Maior altura = %.2f%n", bigger);

        double sumWomenHeights = 0.0;
        int womenCounter = 0;
        for (int i = 0; i < n; i++) {
            if (vectGender[i] == 'f' || vectGender[i] == 'F') {
                sumWomenHeights += vectHeight[i];
                womenCounter++;
            }
        }

        if (womenCounter != 0) {
            double heightAverage = sumWomenHeights / womenCounter;
            System.out.printf("Media das alturas das mulheres = %.2f%n", heightAverage);
        } 
        
        int men = n - womenCounter;
        System.out.println("Numero de homens = " + men);

        sc.close();
    }
}
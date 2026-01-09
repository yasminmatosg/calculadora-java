import java.util.Scanner;
import java.util.Locale;

public class Calculadora {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        mostrarMenu();

        int operacao = sc.nextInt();

        System.out.println("Digite o primeiro número: ");
        double num1 = sc.nextDouble();
        System.out.println("Digite o segundo número: ");
        double num2 = sc.nextDouble();

        double resultado = 0;
        boolean operacaoValida = true;

        switch (operacao) {
            case 1:
                resultado = num1 + num2;
                break;
            case 2:
                resultado = num1 - num2;
                break;
            case 3:
                resultado = num1 * num2;
                break;
            case 4:
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("ERRO: Divisão por zero não é permitida.");
                    operacaoValida = false;
                    sc.close();
                    return;
                }
                break;
            default:
                System.out.println("Operação inválida.");
                operacaoValida = false;
                sc.close();
                return;
        }

        if (operacaoValida) {
            System.out.printf("O resultado é: %.0f%n", resultado);
        } else {
            System.out.printf("O resultado é: %.2f%n", resultado);
        }

        sc.close();
    }

    private static void mostrarMenu() {
        String titulo = "=========== CALCULADORA ============";
        String[] opcoes = {
            "Escolha uma operação:",
            "1. Adição",
            "2. Subtração",
            "3. Multiplicação",
            "4. Divisão",
        };

        int largura = titulo.length();

        System.out.println("+" + "-".repeat(largura + 2) + "+");
        System.out.println("| " + titulo + " |");
        System.out.println("|" + "-".repeat(largura + 2) + "|");
        for (String opcao : opcoes) {
            System.out.printf("| %-"+ largura +"s |\n", opcao);
        }
        System.out.println("+" + "-".repeat(largura + 2) + "+");
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funcionario f = new Funcionario(123, "Erick", "716.055.424.82", "Sao Manuel", "12345", 24,
                3000.00f
        );

        System.out.print("Digite o salário do funcionário: ");
        float s = sc.nextFloat();
        f.setSalario(s);


        System.out.println("\nEstado atual:");
        System.out.println(f.estadoObj());

        float liquido = f.calcularSalarioLiquido();

        System.out.println("\nEstado após a modificação:");
        System.out.println(f.estadoObj());
        System.out.println("Salario liquido: " + liquido);

        sc.close();
    }
}
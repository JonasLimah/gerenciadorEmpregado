import entities.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        Employer employer;
        List<Employer> employers = new ArrayList<>();
        System.out.print("Quantos trabalhadores vão ser registrados ? ");
        Integer numberEmployer = input.nextInt();
        System.out.println("=============================================");
        for (Integer i = 1; i <= numberEmployer; i++) {
            input.nextLine();
            System.out.println("empregado #" + i);
            System.out.print("nome: ");
            String name = input.nextLine();
            System.out.print("salario: ");
            Double salary = input.nextDouble();
            employer = new Employer(name, salary, i);
            employers.add(employer);

        }

        System.out.print("Você vai querer aumentar o salario de algum funcionario? (S/N)");
        String sentinela = input.next();
        while (
                sentinela.toLowerCase().startsWith("s")
        ) {
            System.out.print("Escolha o id que você vai querer aumentar o salario: ");
            Integer setId = input.nextInt();
            if (getEmployee(employers, setId) == null) {
                System.out.println("Funcionario não existe");
            } else {
                System.out.print("Quantos porcento você vai querer aumentar?  ");
                Double percent = input.nextDouble();

                employers.get(setId - 1).increaseSalary(percent);
                System.out.println(employers.get(setId - 1).toString());
                System.out.print("Você vai querer aumentar o salario de algum funcionario? (S/N)");
                sentinela = input.next();
            }
        }
    }


    public static Employer getEmployee(List<Employer> employees, Integer id) {
        Employer result = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return result;
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o seu e-mail:");
        String email = sc.nextLine();
        System.out.print("Digite a sua senha:");
        String senha = sc.nextLine();
        System.out.print("Digite (1) se quiser logar ou (2) se quiser se cadastrar:");
        int opcao = sc.nextInt();
        if (opcao == 1) {
            Authenticate loga = new Authenticate(email, senha);
        } else {
            SignUp cadastro = new SignUp(email, senha);
        }


    }
}
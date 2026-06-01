import java.util.Scanner;
public class Aprender {
    static int saida, menu, i, x;
    static String[][] funcionarios = new String[99][99]; 
    static int indice;

    public static int VerificarEspaco(String[][] funcionarios){
        for (i = 0; i < funcionarios.length; i++ ) {
            if (funcionarios[i][0] == null || funcionarios[i][0].equals("")){
                return i; 
            } 
                
        }
        return 100;
    }
    public static void menu(){
        System.out.println("Menu\n");
        System.out.println("(1)Cadastrar Funcionário Padrão");
        System.out.println("(2)Cadastrar Funcionário Comissionado");
        System.out.println("(3)Cadastrar Funcionário Produção");
        System.out.print("->");
    }

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        saida = 1;
        indice = 0;
        
        while (saida == 1){
            menu();
            menu = Input.nextInt();
            Input.nextLine();
            switch (menu) {
                case 1:
                    System.out.println("Cadastro de Funcionários\n");
                    indice = VerificarEspaco(funcionarios);
                    while (indice < funcionarios.length){
                            System.out.print("Nome: ");
                            funcionarios[indice][0] = Input.nextLine();
                            
                            while (funcionarios[indice][0].length() < 4 ){
                                System.out.println("Mínimo de caracteres é 4");
                                System.out.print("Nome: ");
                                funcionarios[indice][0] = Input.nextLine();
                            }
                            System.out.print("Matricula: ");
                            funcionarios[indice][1] = Input.nextLine();
                            while (funcionarios[indice][1].length() != 4 || !funcionarios[indice][1].matches("\\d+")){
                                System.out.println("A matrícula deve conter exatamente 4 dígitos.");
                                System.out.println("Seja apenas números ");
                                System.out.print("Matricula: ");
                                funcionarios[indice][1] = Input.nextLine();
                            }
                            System.out.println("Deseja fazer mais um cadastro?");
                            System.out.println("(1)Sim");
                            System.out.println("(2)Não");
                            System.out.print("->");
                            menu = Input.nextInt();
                            Input.nextLine();
                            if (menu == 2){
                                break;
                            }
                            indice = VerificarEspaco(funcionarios);
                            if (indice == 100){
                                System.out.println("Limite de cadastros atingido!");
                                break;
                            }
                    }
                    break;
            
                default:
                    
                    break;
            }
             
        }
 
    }
    
}

    
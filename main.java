import java.util.Scanner;
public class Main {

    //Variáveis
    public static final String salario = "2000";
    public static float x, x1;
    public static int saida, menu, i, y;
    public static String[][] funcionarios = new String[99][99]; 
    public static int indice = 0;

    public static int VerificarEspaco(String[][] funcionarios){
        for (i = 0; i < funcionarios.length; i++ ) {
            if (funcionarios[i][0] == null || funcionarios[i][0].equals("")){
                return i; 
            } 
                
        }
        return 100;
    }
    public static float CalComissao(float x, int y){
        return (x*y)/100;
    }
    public static float CalSalario(float x, float x1){
        return x + x1;
    }
    public static void menu(){
        System.out.println("Menu\n");
        System.out.println("(1)Cadastrar Funcionário Padrão:");
        System.out.println("(2)Cadastrar Funcionário Comissionado:");
        System.out.println("(3)Cadastrar Funcionário Produção:");
        System.out.println("(4)Gerar folha de Pagamento:");
        System.out.print("->");
    }

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        
        saida = 1;
        
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
                                System.out.print("Matrícula: ");
                                funcionarios[indice][1] = Input.nextLine();
                            }
                            funcionarios[indice][2] = salario;
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
                case 2:
                    System.out.println("Cadastro de Funcionários Comissionado\n");
                    indice = VerificarEspaco(funcionarios);
                    while (indice <= funcionarios.length){
                        System.out.print("Nome: ");
                        funcionarios[indice][0] = Input.nextLine();
                        
                        while (funcionarios[indice][0].length() < 4){
                            System.out.println("Mínimo de caracteres é 4");
                            System.out.print("Nome: ");
                            funcionarios[indice][0] = Input.nextLine();
                        }
                        System.out.print("Matrícula: ");
                        funcionarios[indice][1] = Input.nextLine();
                        while (funcionarios[indice][1].length() != 4 || !funcionarios[indice][1].matches("\\d+")){
                            System.out.println("A matrícula deve conter exatamente 4 dígitos.");
                            System.out.println("Seja apenas números");
                            System.out.print("Matrícula: ");
                            funcionarios[indice][1] = Input.nextLine();
                        }
                        funcionarios[indice][2] = salario;

                        System.out.print("Informe o valor das vendas: ");
                        funcionarios[indice][3] = Input.nextLine(); 
                        x = Float.parseFloat(funcionarios[indice][3]);                  
                        while (x < 0 || !funcionarios[indice][3].matches("\\d+")){
                            System.out.println("Informe um valor válido");
                            System.out.println("Seja apenas números(ex: 203.00)");
                            System.out.print("Informe o valor das vendas: ");
                            funcionarios[indice][3] = Input.nextLine(); 
                            x = Float.parseFloat(funcionarios[indice][3]);
                        }

                        System.out.print("Informe comissão percentual: ");
                        funcionarios[indice][4] = Input.nextLine();
                        while (!funcionarios[indice][4].matches("\\d+")){
                            System.out.println("Informe um valor válido");
                            System.out.println("Seja apenas números");
                            System.out.print("Informe comissão percentual: ");
                            funcionarios[indice][4] = Input.nextLine();
                        }
                        y = Integer.parseInt(funcionarios[indice][4]);
                        x = CalComissao(x, y);
                        funcionarios[indice][5] = String.valueOf(x);
                        x1 = Float.parseFloat(funcionarios[indice][2]);
                        x = CalSalario(x, x1);
                        funcionarios[indice][6] = String.valueOf(x);
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
                case 3:
                    System.out.println("Cadastrar Funcionário Produção\n");
                    indice = VerificarEspaco(funcionarios);
                    while (indice <= funcionarios.length){
                        System.out.print("Nome: ");
                        funcionarios[indice][0] = Input.nextLine();
                        while (funcionarios[indice][0].length() < 4){
                            System.out.println("Deve ter no mínimo de 4 caracteres");
                            System.out.print("Nome: ");
                            funcionarios[indice][0] = Input.nextLine();
                        }
                        System.out.print("Matrícula : ");
                        funcionarios[indice][1] = Input.nextLine();
                        while(funcionarios[indice][1].length() != 4 || !funcionarios[indice][1].matches("\\+d")){
                            System.out.println("A matrícula deve conter exatamente 4 dígitos.");
                            System.out.println("Seja apenas números.");
                            System.out.print("Matrícula: ");
                            funcionarios[indice][1] = Input.nextLine();
                        }
                        funcionarios[indice][2] = salario;
                        System.out.print("Informe a quantidades de peças: ");
                        funcionarios[indice][3] = Input.nextLine();
                        x = Integer.parseInt(funcionarios[indice][3]);
                        while (x < 0 || !funcionarios[indice][3].matches("\\+d")){
                            System.out.println("Digite apenas números");
                            System.out.println("e o valor dever maior que 0");
                            System.out.print("Informe a quantidades de peças: ");
                            funcionarios[indice][3] = Input.nextLine();
                            x = Integer.parseInt(funcionarios[indice][3]);
                        }
                        System.out.print("Informe o valor da peça: ");
                        funcionarios[indice][4] = Input.nextLine();
                        x = Float.parseFloat(funcionarios[indice][4]);
                        while(x < 0 || !funcionarios[indice][4].matches("\\+d")){
                            System.out.println("Informe um valor válido");
                            System.out.println("Seja apenas números(ex: 203.00)");
                            System.out.print("Informe o valor da peça: ");
                            funcionarios[indice][4] = Input.nextLine();
                            x = Float.parseFloat(funcionarios[indice][4]);
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
                case 4:
                    




                default:
                    
                    break;
            }
             
        }
 
    }
    
}

    
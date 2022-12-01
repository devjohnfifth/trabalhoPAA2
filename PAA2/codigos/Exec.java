import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exec{   
    public static void main(String[] args) throws FileNotFoundException{
        escolhaExercicio();
    }
    

    public static void escolhaExercicio() throws FileNotFoundException{
        Scanner s = new Scanner(System.in);
        System.out.print("\n\n\n\nEscolha o exercicio a ser executado 1,2,3 ou 4: ");
        int exercicio = s.nextInt();
        switch (exercicio) {
            case 1:
                exercicio1();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            
            default:
                break;
        }
        s.close();
    }

    public static void exercicio1() throws FileNotFoundException{
        Poligno polignos[] = leitura("test1.txt");


        //==============================================[print polignos]
        for (Poligno poligno : polignos) {
            poligno.printp();
        }
        //==============================================[print polignos]
        
    }

    public static Poligno[] leitura(String arquivo)throws FileNotFoundException{
        String pasta = "/home/joao/Área de Trabalho/github/PAA2/exemplos/"+arquivo;
        Scanner scanner = new Scanner(new FileReader(pasta)).useDelimiter("\\n");
    
        int tamanhoListaPolignos = scanner.nextInt();
        Poligno polignos[] = new Poligno[tamanhoListaPolignos];

        int con = 0;
        for(int c = 0; c < tamanhoListaPolignos; c++){
            con = 0;
            String p = scanner.next();
            String[] divisorEspaco = p.split(" ");
            int valoresX[] = new int[3];

            for (String a : divisorEspaco){
                valoresX[con] = Integer.parseInt(a);
                con++;
            }
            polignos[c] = new Poligno(valoresX[0],valoresX[1],valoresX[2]);
        }

        System.out.println("\n");
        scanner.close();

        return polignos;
    }
    
}
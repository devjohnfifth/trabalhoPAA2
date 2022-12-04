import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Exec{   
    private static List<Poligno> polygonList;
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
                exercicio2();
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
        System.out.println("=================================================Começa criação da lista de Polignos=================================================");
        Poligno polignos[] = leitura("test11.txt");
        System.out.println("=====================================================================================================================================");
        System.out.println("exércicio 1: " + Calculadora.distanciaMinimaTopo(polignos[0], polignos[1]));
        
    }

    public static void exercicio2() throws FileNotFoundException{
        leitura2("testA.txt");
        new Artista("Exercise 02", polygonList);

    }





    public static Poligno[] leitura(String arquivo)throws FileNotFoundException{
        String pasta = "/home/joao/Área de Trabalho/github/PAA2/exemplos/"+arquivo;
        Scanner scanner = new Scanner(new FileReader(pasta)).useDelimiter("\\n");
    
        int tamanhoListaPolignos = scanner.nextInt();
        Poligno polignos[] = new Poligno[tamanhoListaPolignos];

        int con = 0;
        for(int c = 0; c < tamanhoListaPolignos; c++){
            System.out.println("----------------------Poligno " + c +"----------------------");
            con = 0;
            String p = scanner.next();
            String[] divisorEspaco = p.split(" ");
            int valoresX[] = new int[3];

            for (String a : divisorEspaco){
                valoresX[con] = Integer.parseInt(a);
                con++;
            }
            polignos[c] = new Poligno(valoresX[0],valoresX[1],valoresX[2]);
            System.out.println("-----------------------------------------------------");
        }

        System.out.println("\n");
        scanner.close();

        return polignos;
    }

    private static void leitura2 (String fileName) {
        polygonList = new ArrayList<Poligno>();
        String path =  "/home/joao/Área de Trabalho/github/PAA2/exemplos/" + fileName;
        try {
            Scanner sc = new Scanner(new FileReader(path));
            int numberOfPolygons = sc.nextInt();
            for (int c = 0; c < numberOfPolygons; c++) {
                polygonList.add(
                    new Poligno(
                        sc.nextDouble(),
                        sc.nextDouble(),
                        sc.nextDouble()
                    )
                );
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
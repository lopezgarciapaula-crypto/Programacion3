import java.util.Arrays;
import java.util.Scanner; 

public class OrdenarPalabras {
    public static void main(String[]args){

        Scanner sc = new Scanner (System.in);
        String[] palabras = new String[5]; 

        for (int i = 0; i<5; i++){
            System.out.println("Palabra"+(i+1)+":"); 
            palabras[i] = sc.nextLine(); 
        }

        Arrays.sort(palabras); 

        System.out.println("Ordenadas:"); 
        for(int i=0; i<5; i++){
            System.out.println(palabras[i]); 
        }
        sc.close(); 
    }
}


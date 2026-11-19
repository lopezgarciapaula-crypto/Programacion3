public class Ejercicio2_4 {
    public static void main(String[]args){
        //Uso el Factory Method
        Usuario user = Usuario.crearDesdeArgumentos(args);

        //Si el usuario es null, es que ha habido un error --> salgo
        if(user == null){
            return;
        }

        //Calculo el IMC
        double imc = user.getPeso()/ (user.getAltura()*user.getAltura());

        //Tabla
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-15s | %-10s | %-10s | %-10s |%n", "NOMBRE", "PESO (kg)", "ALTURA (m)", "IMC");
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-15s | %10.2f | %10.2f | %10.2f |%n", 
                          user.getNombre(), user.getPeso(), user.getAltura(), imc);
        System.out.println("--------------------------------------------------");
    }
    }
    


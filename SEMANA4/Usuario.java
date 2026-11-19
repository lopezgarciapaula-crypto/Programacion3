public class Usuario {

    private String nombre; 
    private double peso; 
    private double altura; 

    public Usuario(String nombre, double peso, double altura){
        this.nombre = nombre; 
        this.peso = peso; 
        this.altura = altura; 
    }

    public String getNombre(){
        return nombre;
    }
    
    public double getPeso(){
        return peso;
    }

    public double getAltura(){
        return altura;
    }

    //Factory Method 

    public static Usuario crearDesdeArgumentos(String[] args){
        if(args.length != 3){
            System.err.println("ERROR: Debes introducir exactamente 3 argumentos: nombre, peso y altura.");
            System.err.println("Ejemplo: java Ejercicio2_4 Juan 70.5 1.75");
            return null; // Devolvemos null porque hubo un error
        }

        try{
            String nombre = args[0]; 
            double peso = Double.parseDouble(args[1]); 
            double altura = Double.parseDouble(args[2]);
            
            return new Usuario(nombre, peso, altura);

        }
        catch(NumberFormatException e){
            System.err.println("ERROR: El peso y la altura deben ser numeros validos.");
            return null; // Devolvemos null si los numeros estan mal
        }
    }
}

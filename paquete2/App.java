package SEMANA5.paquete2;

import SEMANA5.paquete1.Clase1; 
//import SEMANA5.paquete1.Clase2; //

public class App {

    public static void main(String[] args){

    System.out.println("--- Creando objeto de Clase1 ---");
    Clase1 obj1 = new Clase1(); 
    System.out.println("Atributo public: " + obj1.atributoPublic);


    // System.out.println(obj1.atributoDefault);   //
    // System.out.println(obj1.atributoProtected); //
    // System.out.println(obj1.atributoPrivate);   //
    
    obj1.metodoPublic();
    // obj1.metodoDefault();   //
    // obj1.metodoProtected(); //
    // obj1.metodoPrivate();   // 

    // Clase2 obj2 = new Clase2(); //
    }
}

/*
15. Crea  una  clase  Complejo  que  permita  trabajar  con  números  complejos  
(parte  real  y  parte imaginaria).   Incluye   los   siguientes   métodos:   
constructores   (por   defecto   y   parametrizado), accedentes, mutadores, 
suma, resta, multiplicación, división, acumulación y print().
 */
package complejo;

public class Complejo {
    
    //atributos
    double numReal;
    double numImaginario;
    
    //inicializamos el constructores
    public Complejo() {
    }
    
    //inicializamos el constructor con 2 parametros
    public Complejo(double nR, double nI){
        this.numReal = nR;
        this.numImaginario = nI;
    }
    
    //metodos set y get de los atributos
    public double getNumReal() {
        return numReal;
    }

    public void setNumReal(double numReal) {
        this.numReal = numReal;
    }

    public double getNumImaginario() {
        return numImaginario;
    }

    public void setNumImaginario(double numImaginario) {
        this.numImaginario = numImaginario;
    }
    
    //sumar dos números complejos -> (a, b) + (c, d) = (a + c, b + d);
    public Complejo sumar(Complejo c){
        Complejo aux = new Complejo();
        aux.numReal = numReal + c.numReal;
        aux.numImaginario = numImaginario + c.numImaginario;
        return aux;
    }
   
    //restar dos números complejos -> (a, b) - (c, d) = (a - c, b - d);
    public Complejo restar(Complejo c){
        Complejo aux = new Complejo();
        aux.numReal = numReal - c.numReal;
        aux.numImaginario = numImaginario - c.numImaginario;
        return aux;
    }
   
    //multiplicar dos números complejos -> (a, b) * (c, d) = (a*c – b*d, a*d + b*c)
    public Complejo multiplicar(Complejo c){
        Complejo aux = new Complejo();
        aux.numReal = numReal * c.numReal - numImaginario * c.numImaginario;
        aux.numImaginario = numReal * c.numImaginario + numImaginario * c.numReal;
        return aux;
    }
   
    //multiplicar un número complejo por un número de tipo double -> (a, b) * n = (a * n, b * n)
    public Complejo multiplicar(double n){
        Complejo aux = new Complejo();
        aux.numReal = numReal * n;
        aux.numImaginario = numImaginario * n;
        return aux;
    }
   
    //dividir dos números complejosnumImaginario -> (a, b) / (c, d) = ((a*c + b*d) / (c^2 + d^2) , (b*c – a*d) / (c^2 + d^2))
    public Complejo dividir(Complejo c){
        Complejo aux = new Complejo();
        aux.numReal = (numReal * c.numReal + numImaginario * c.numImaginario)/(c.numReal * c.numReal + c.numImaginario * c.numImaginario);
        aux.numImaginario = (numImaginario * c.numReal - numReal * c.numImaginario)/(c.numReal * c.numReal + c.numImaginario * c.numImaginario);                           
        return aux;
    }
    
    //método toString
    @Override
    public String toString() {
        return "(" + numReal + ", " + numImaginario + ")";
    }

    //método equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complejo other = (Complejo) obj;
        if (this.numReal != other.numReal) {
            return false;
        }
        if (this.numImaginario != other.numImaginario) {
            return false;
        }
        return true;
    } 
    
    public static void main(String[] args) {
        // declaración de números complejos
        Complejo c1 = new Complejo(1.0, 1.0);
        Complejo c2 = new Complejo(2.0, 2.0);
        Complejo cResult,cResult2;
        // operadores aritméticos
        cResult = c1.sumar(c2);
        System.out.println(c1 + " + " + c2 + " = " + cResult);
        
        cResult = c1.restar(c2);
        System.out.println(c1 + " - " + c2 + " = " + cResult);
        
        cResult = c1.dividir(c2);
        System.out.println(c1 + " / " + c2 + " = " + cResult);
        
        cResult = c1.multiplicar(c2);
        System.out.println(c1 + " * " + c2 + " = " + cResult);
        
        cResult = c1.multiplicar(2.0);
        System.out.println(c1 + " * 3.5 = " + cResult);
        
        cResult2 = c1.multiplicar(4.5);
        System.out.println(c1 + " * 3.5 = " + cResult);
        
        System.out.println("");
        
        if (c2.equals(cResult)) { //comparamos
            System.out.println(c2 + " igual que " + cResult);
        } else {
            System.out.println(c2 + " distinto que " + cResult);
        }
        System.out.println("");
        
        if (c1.equals(cResult2)) { //comparamos
            System.out.println(c1 + " igual que " + cResult2);
        } else {
            System.out.println(c1 + " distinto que " + cResult2);
        }
        System.out.println("");
        
    }
    
}

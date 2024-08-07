package FrameWork;

/**
 * Clase para las excepciones que se pueden tener
 */
public class GroupThreeException extends Exception {
    
    /**
     * Metodo para imprimir en caso de que exista alguna excepcion
     * @param e: e
     * @param clase: clase
     * @param metodo: metodo
     */
    public GroupThreeException(String e, String clase,String metodo){
        System.out.println("Error APP --> Log "+clase+" , "+metodo+" , "+e);
    }

    @Override
    public String getMessage() {
        return "Noseas Sapo en serio";
    }
}

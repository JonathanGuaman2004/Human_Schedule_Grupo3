package FrameWork;

public class GroupThreeException extends Exception {
    public GroupThreeException(String e, String clase,String metodo){
        System.out.println("Error APP --> Log "+clase+" , "+metodo+" , "+e);
    }
    @Override
    public String getMessage() {
        return "Noseas Sapo en serio";
    }
}

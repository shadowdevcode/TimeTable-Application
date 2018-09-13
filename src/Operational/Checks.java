package Operational;

public class Checks {
     public static boolean isEmpty(String value){
        return value.equals("");
}
     public static boolean isNumeric(String value){
        try{
            Integer.parseInt(value);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
}

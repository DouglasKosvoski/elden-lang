public class Variable {
    String varName;
    int varValue;

    String createVariable(String line){
        //String Line = line;
        String Line = line.replace("\s", "");
        String LIne = Line.substring(6);
        return (LIne);
        
    } 

}



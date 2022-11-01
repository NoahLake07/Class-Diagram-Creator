public class Variable {

    AccessModifier accessModifier;
    Type type;
    String varName;

    public Variable(AccessModifier aM,Type t, String s){
        accessModifier = aM;
        type = t;
        varName = s;
    }

    public void setVariable(AccessModifier aM,Type t, String s){
        accessModifier = aM;
        type = t;
        varName = s;
    }

    public Type getType(){
        return type;
    }

    public String getName(){
        return varName;
    }

    public AccessModifier getAccessModifier(){
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier aM){
        accessModifier = aM;
    }

}

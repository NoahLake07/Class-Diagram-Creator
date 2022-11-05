public class Variable {

    int accessModifier;
    int type;
    String varName;

    public Variable(int aM, int t, String s){
        accessModifier = aM;
        type = t;
        varName = s;
    }

    public void setVariable(int aM, int t, String s){
        accessModifier = aM;
        type = t;
        varName = s;
    }

    public int getType(){
        return type;
    }

    public String getName(){
        return varName;
    }

    public int getAccessModifier(){
        return accessModifier;
    }

    public void setAccessModifier(int aM){
        accessModifier = aM;
    }

}

import java.util.ArrayList;

public class Class {



    ArrayList<Method> methods = new ArrayList<>(0);
    ArrayList<Variable> variables = new ArrayList<>(0);
    String className = "CLASS NAME";

    // method controllers
    public void createMethod(AccessModifier accessModifier, Type returnType, String methodName){
        Method newMethod = new Method(accessModifier,returnType,methodName);
        methods.add(newMethod);
    }

    public void removeMethod(Method m){
        methods.remove(m);
    }

    // variable controllers
    public void createVariable(int accessModifier, int type, String varName){
        Variable var = new Variable(accessModifier,type,varName);
        variables.add(var);
    }

    public void removeVariable(Variable v){
        variables.remove(v);
    }

    // class controllers
    public void setClassName(String name){
        className = name;
    }

    public String getClassName(){
        return className;
    }

    public ArrayList<Method> getMethods(){
        return methods;
    }

    public ArrayList<Variable> getVariables(){
        return variables;
    }

    public void setVariables(ArrayList<Variable> v){
        variables = v;
    }

    public void setMethods(ArrayList<Method> m){
        methods = m;
    }

}

public class Method {

    AccessModifier accessModifier;
    Type returnType;
    String methodName;

    public Method(AccessModifier aM, Type rT, String name){
        accessModifier = aM;
        returnType = rT;
        methodName = name;
    }

    public String getMethodName(){
        return methodName;
    }

    public void setMethodName(String s){
        methodName = s;
    }

    public Type getReturnType(){
        return returnType;
    }

    public void setReturnType(Type t){
        returnType = t;
    }

    public String getName(){
        return methodName;
    }

    public void setName(String s){
        methodName = s;
    }

    public AccessModifier getAccessModifier(){
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier aM){
        accessModifier = aM;
    }

    public Method getMethod(){
        return this;
    }

    public void setMethod(Method m){
        accessModifier = m.getAccessModifier();
        returnType = m.getReturnType();
        methodName = m.getName();
    }

}

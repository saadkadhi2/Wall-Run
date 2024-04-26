package sample.ordermenu;


public class Name {
    private static final Name instance = new Name();
    private String name;

    private Name() {
        name = "";
    }
    public static Name getInstance() {
        return instance;
    }
    public void setName(String userName){
        name = userName;
    }
    public String getName(){
        return name;
    }
}


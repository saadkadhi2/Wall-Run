package sample.ordermenu;


public class Account {
    private String userName;
    private String mostRecentScene;
    private String password;
    private boolean isCust; //is customer is false, when a chef
    private static final Account instance = new Account();
    public static Account getInstance() {
        return instance;
    }
    public Account() {

    }
    public Account(String inUserName, String inPassword, boolean cust) {
        userName = inUserName;
        password = inPassword;
        isCust = cust;
    }
    public void setUserName(String inUserName){
        userName = inUserName;
    }
    public String getUserName(){
        return userName;
    }

    public void setPassword(String inPassword){
        password = inPassword;
    }
    public String getPassword(){
        return password;
    }

    public void setPriv(boolean cust){
        isCust = cust;
    }
    public boolean getPriv(){   //get privliges
        return isCust;
    }

    public void setRecent(String s) {
        mostRecentScene = s;
    }
    public String getRecent() {
        return mostRecentScene;
    }
}


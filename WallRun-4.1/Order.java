package sample.ordermenu;

import java.io.*;
import java.util.ArrayList;

public class Order {

    private static final Order instance = new Order();
    Account currAccount = Account.getInstance();
    ArrayList<String> order;
    boolean orderComplete = false;
    int orderNumber;
    public Order() {
        order = new ArrayList<>();
        orderNumber = 0;
    }
    void addToOrder(String menuItem) {
        order.add(menuItem+"."+currAccount.getUserName());
    }
    void addRaw(String menuItem) {
        order.add(menuItem);
    }
    void printOrder() {
        for(int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }
    }
    public static Order getInstance() {
        return instance;
    }
    public String getOrderItem(int i) {
        return order.get(i);
    }
    void updateQueue_txt() throws IOException {

        File file = new File("src/main/resources/sample/ordermenu/queue.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        clearTheFile();
        for(int i = 0; i < order.size(); i++) {
            out.write(order.get(i) + "\n");
        }
        out.close();
    }

    public static void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("src/main/resources/sample/ordermenu/queue.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

    void incrementOrderNum() {
        orderNumber++;
    }
    public int getSize() {
        return order.size();
    }
    public void clear(String toRemove) {
        order.remove(toRemove);
    }
    public void clearAll() {
        order.clear();
    }


}

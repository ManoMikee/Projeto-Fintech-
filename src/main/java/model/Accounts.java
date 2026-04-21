package model;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private  static List<User> accounts  = new ArrayList<>();;

    public Accounts(){

    }


    public static List<User> getAccounts() {
        return accounts;
    }


    public static void addAccont(User user){
        accounts.add(user);

    }
    public static void exibirContas(){
        for (User ac :  accounts){
            System.out.println(ac);
        }
    }


    public static User findByEmail(String email){
        for( User u : accounts){
            if (u.getEmail().equals(email)){
                return  u;
            }
        }

        return null;
    }

    public  static User findById(long id){
        for(User u : accounts){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }

}

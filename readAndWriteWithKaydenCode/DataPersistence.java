import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.FileNotFoundException; 

public class DataPersistence{
    private static ArrayList <String> passwords = new ArrayList<>();
    private static ArrayList <String> users = new ArrayList<>();

    // Geeks for geeks
    public static String write(String str, String password, String username) throws IOException { 
        
        str+=(username+","+password+"\n");
        // attach a file to FileWriter
        FileWriter fw=new FileWriter("Accounts.txt"); 
        
        fw.write(str); 
        // read character wise from string and write  
        // into FileWriter  
        //for (int i = 0; i < password.length(); i++) 
        //    fw.write(password.charAt(i)); 
  
        System.out.println("Writing successful"); 
        //close the file  
        fw.close(); 
        return read();
    } 

    //geeks for geeks
    public static String read() throws IOException { 
        // variable declaration 
        int ch; 
        String str="";

        // check if File exists or not 
        FileReader fr = new FileReader("Accounts.txt"); 
        try{ 
            fr = new FileReader("Accounts.txt"); 
        }catch(FileNotFoundException fe){ 
            System.out.println("File not found"); 
        } 
  
        // read from FileReader till the end of file 
        while ((ch=fr.read())!=-1){ 
            str+=(char)ch;
        }
        // close the file 
        fr.close(); 
        return str;
    } 

    public static String getLine(int line) throws IOException{
        String file = read();
        String[] arrOfstr = file.split("\n");
        if (arrOfstr.length >= line)
            return arrOfstr[line - 1];
        return "";
    }

    public static ArrayList<String> getUsernames()throws IOException{
        String file = read();
        String[] arrOfstr = file.split("\n");
        String line = "";
        users.clear();
        for(int i=0; i<arrOfstr.length; i++){
            line = getUsername(arrOfstr[i]);
            users.add(line);
        }
        return users;
    }

    public static String getUsername(String k){
        int firstComma = 0;
        int secondComma = k.indexOf(",");

        String ans = k.substring( firstComma, secondComma).trim();

        return ans;
    }
    
    public static ArrayList<String> getPasswords()throws IOException{
        String file = read();
        String[] arrOfstr = file.split("\n");
        String line = "";
        passwords.clear();
        for(int i=0; i<arrOfstr.length; i++){
            line = getPassword(arrOfstr[i]);
            passwords.add(line);
        }
        return passwords;
    }

    public static String getPassword(String k){
        int comma = k.indexOf(",");

        String ans = k.substring( comma+1, k.length()).trim();
        return ans;
    }
}
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;




public class BalanceTransactions {

public static void bookCheck(double startBalance, double endBalance){
    String filename;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter filename:");


    try{
        filename = bufferedReader.readLine();
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader br =  new BufferedReader(fileReader);
        String line;
        String arr[];
        double balance = startBalance;
        line = br.readLine();
        while( line  != null){
            arr = line.split(" ");
            double cash = Double.parseDouble(arr[1]);

            if(arr[2].equals("P")){
                balance = balance - cash;
            }
            else if(arr[2].equals("R")){
                balance = balance + cash;

            }


        }
        fileReader.close();

        if(balance == endBalance){
            System.out.println("Cash amount matches end balance");
        } else{
            System.out.println("Cash amount does not match with check book");
        }



    } catch (IOException e) {
        System.out.println("Error: Please enter correct file name");

        bookCheck(startBalance, endBalance);




    }


}




public static void main(String args[]){


    Scanner sc = new Scanner(System.in); //Creates an instance of scanner
    System.out.println("Enter the beginning day balance: "); //Asks the user for start balance
    double startBalance = sc.nextDouble(); //Stores user input
    System.out.println("Enter final balance of day: "); //Asks user for final balance
    double endBalance = sc.nextDouble(); //Stores user input.
    bookCheck(startBalance, endBalance); //Gets user input and sends it to book check for processing.







}


}

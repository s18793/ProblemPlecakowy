import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Main   {
    public static List<Integer> plik;
    public static int objetoscPlecaka;
    public static int liczbaPrzedmiotów;
    public static int[] watosci;
    public static  int[] wagi ;

    public static int najlepszyWartosc;
    public static int najlepszaWaga;

    public static int getpower(int a){
        int resault=1;
        for(int i=1; i<=a; i++){
            resault*=2;
        }
        return  resault;
    }


    public static ArrayList<Book> getDane(String pat) throws IOException {

        FileReader fileReader = new FileReader(pat);
        BufferedReader bf = new BufferedReader(fileReader);
        ArrayList<Book> books = new ArrayList<Book>();
        String line =  bf.readLine();

        objetoscPlecaka= Integer.parseInt(line.split(" ")[0]);
        liczbaPrzedmiotów=Integer.parseInt(line.split(" ")[1]);

        wagi = new int[liczbaPrzedmiotów];
        watosci = new int[liczbaPrzedmiotów];

        najlepszyWartosc= Integer.MIN_VALUE;
        najlepszaWaga= Integer.MIN_VALUE;
        line=  bf.readLine();

        String[] splits = line.split(",|\\ " );


        for (int i = 0; i < watosci.length; i++) {

            int a = (int)(Integer.parseInt(splits[i]));
            watosci[i]=a;
        }

        line = bf.readLine();
        String[] spl = line.split(",|\\ " );
        for(int i =0; i<wagi.length; i++) {
            wagi[i] = Integer.parseInt(spl[i]);
        }


        bf.close();

        return null;
    }


    public static void main(String[] args) throws IOException {

        getDane("bruteforce.txt");
        System.out.println(objetoscPlecaka);
        System.out.println("\n"+ liczbaPrzedmiotów);
       /*
        System.out.println(objetoscPlecaka);

for(int i =0; i < watosci.length; i++) {
    System.out.print(watosci[i]+", ");
}
        for(int i =0; i < wagi.length; i++) {
            System.out.print(wagi[i]+", ");
        }
       System.out.println("\n"+ liczbaPrzedmiotów);

Book[] books= new Book[liczbaPrzedmiotów];
        for(int i =0; i < liczbaPrzedmiotów; i++) {
        books[i]=new Book(watosci[i],wagi[i]);

        }
*/

        Book[] books= new Book[liczbaPrzedmiotów];
        for(int i =0; i < liczbaPrzedmiotów; i++) {
            books[i] = new Book(watosci[i], wagi[i]);
        }
        System.out.println("-------------");

        for(int i =0; i < books.length; i++) {
            System.out.println( books[i]);

        }
        System.out.println("-------------");


        /*
        for (int i = 0; i < Math.pow(2,objetoscPlecaka) ; i++) {
            int pot = 1;
            for (int j = 0 ; j < liczbaPrzedmiotów; j++) {

                if (i == 1 & pot == 1) {
                    System.out.println(books[j]);
                }
                pot *=2;
            }
        }

*/
        int wynikowa =0;

        for(int i =0; i<Math.pow(2,liczbaPrzedmiotów);i++){
            najlepszaWaga = 0;
            najlepszyWartosc = 0;

            for(int x =0;x<liczbaPrzedmiotów;x++){
                int p=(int) Math.pow(2,x);
                if((p & i )> 0){
                    najlepszaWaga+=books[x].objętość;
                    najlepszyWartosc+=books[x].wartość;


                }



            }
           // System.out.println(" ");
           /*
            for(int x =0;x<liczbaPrzedmiotów;x++) {
                int p = getpower(x);
                if ((p & i) > 0) {
                    System.out.print(1);
                } else System.out.print(0);
            }
*/

            if(najlepszaWaga<=objetoscPlecaka && najlepszyWartosc >wynikowa){
                wynikowa=najlepszyWartosc;

                for(int x =0;x<liczbaPrzedmiotów;x++) {
                    int p = getpower(x);
                    if ((p & i) > 0) {
                        System.out.print(1);
                    } else System.out.print(0);
                }
                System.out.println(" wynik aktulany to :"+ wynikowa +" ,obj: "+ najlepszaWaga)
                ;
            }



        }




        System.out.println("\n"+"wynik to :"+ wynikowa+" ");
        System.out.println();

      //  System.out.println(getpower(3));





    }




}



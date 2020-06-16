public class Book {
    int wartość; //2 linia z pliku

    int objętość;//3 linia z pliku

    public Book( int wartość, int objętość){
        this.wartość=wartość;
        this.objętość= objętość;
    }

    public String toString(){
        return wartość + " , "+objętość;
    }
}
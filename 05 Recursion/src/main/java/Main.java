public class Main {
    private static Tower a = new Tower(8);
    private static  Tower b = new Tower(0);
    private static  Tower c = new Tower(0);
    private static int totalMoves = 0;


    public static void print() throws InterruptedException {
        for (int height = 10; height >= 0; height--)
            System.out.println(a.text(height)+b.text(height)+c.text(height));
        Thread.sleep(500);
    }

    public static void main(String[] args) throws InterruptedException {
        print();
        move(8, a,b,c);
        print();
        System.out.println("TOTAL MOVES:" + totalMoves);
    }

    public static void move(int count, Tower beg, Tower aux, Tower end) throws InterruptedException{
        if(count==1) beg.moveTo(aux); //base case
        else{
            move(count-1,beg,end,aux);
            totalMoves ++;
            beg.moveTo(aux);
            print();
            move(count-1, end,aux,beg);
            totalMoves ++;
        }
    }
}

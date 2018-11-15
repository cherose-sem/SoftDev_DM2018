public class Main {
    private static Tower a = new Tower(10);
    private static  Tower b = new Tower(0);
    private static  Tower c = new Tower(0);


    public static void print() throws InterruptedException {
        for (int height = 12; height >= 0; height--)
            System.out.println(a.text(height)+b.text(height)+c.text(height));
        Thread.sleep(500);
    }

    public static void main(String[] args) throws InterruptedException {
        print();
        move(10, a,b,c);
        print();
    }

    public static void move(int c, Tower s, Tower t, Tower m) throws InterruptedException{
        if(c==1) s.moveTo(t); //base case
        else{
            move(c-1,s,m,t);
            s.moveTo(t);
            print();
            move(c-1, m,t,s);
        }
    }
}

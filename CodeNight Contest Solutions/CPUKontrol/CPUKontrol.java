public class CPUKontrol{

    static int x = 1881;
        
        public static int fonk1() {
            return x;
        }
        
        public static int fonk2() {
            int x = 1938;
            return fonk1();
        }

     public static void main(String []args){
        
        System.out.print( fonk2());
        
     }
}
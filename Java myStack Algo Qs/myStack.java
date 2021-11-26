import java.util.Scanner;

public class myStack {

      private Object[] theStack;

      private int capacity;

      private int top;

       //Constructor: Creates an empty stack

      public myStack(int capacity) {

            theStack = new Object[capacity];

            this.capacity = capacity;

            top = 0;

        }
      public boolean empty() {

          if ( top == 0 ) {
              return true;
          }

          return false;

       }


      public Object pop() {
          if ( this.top == 0 ) {
              System.out.print( "The stack is empty which cannot be popped.");
              return null;
          }

          Object current = new Object();
          current = theStack[ this.top];

             Object[] newStack = new Object[ this.capacity];

             for ( int i = 0; i < this.top - 1; i++ ) {
                 newStack[i] = theStack[i];
             }

         this.theStack = newStack;
         this.top--;

         return current;
      }


      public boolean push(Object x) {
          if ( top >= capacity ) {
              System.out.print( "The capacity of stack is full");
          }
          else {
              theStack[top] = x;
              top++;

              return true;
          }

          return false;
       }


      public int search(Object x) {
            for ( int i = 0; i < this.top; i++ ) {
                  if ( this.theStack[i] == x ) {
                      return i;
                  }
              }

          return -1;
      }


      public Object peek() {
          if ( this.top == 0 ) {
              System.out.print( "The stack is empty so you cannot peek!");
              return null;
          }

          Object peek = new Object();
          peek = theStack[ this.top];


          return peek;
      }


    public static void throwIt( int input) throws Exception {
        if ( input == 1)
            throw new RuntimeException();
        else if ( input == 2 )
            return;
        else if ( input == 3 ) {
            int x = 0;
            int y = 5 / x;
        }
        else if ( input == 4 ){
            throw new Exception();
        }
    }


     public static void main(String []args){
        try {
            Scanner scan = new Scanner( System.in);
            int value = 2;
            throwIt( value);
        } catch  (NumberFormatException ne) {
            System.out.print("Not valid ");
        
        } catch  (ArithmeticException ae) {
            System.out.print("Not valid ");
        
        } catch  (Exception re) {
            System.out.print("Not valid ");
        } finally {
            System.out.print("Finally ");
        }
        
         System.out.print("after ");
        
     }

}
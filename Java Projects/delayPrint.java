import java.util.Scanner;
import java.util.concurrent.TimeUnit;
   class delayPrint {
      public static void main(String args[]) throws Exception {
         Scanner in = new Scanner(System.in);
         printWithDelays("Good afternoon dude! I am your personal assistant Luzon Remora for the remainder of this program!", TimeUnit.MILLISECONDS, 25);
         System.out.println();
         printWithDelays("Are you having a good day? I only speak in numbers so you'll have to bear with me...", TimeUnit.MILLISECONDS, 25);
         
      }
      public static void printWithDelays(String data, TimeUnit unit, long delay) throws InterruptedException {
         for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
         }
      }
   }
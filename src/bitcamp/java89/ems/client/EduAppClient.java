package bitcamp.java89.ems.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EduAppClient {

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("서버주소? ");
    String serverAddr = keyScan.nextLine();
    
    try (
        Socket socket = new Socket(serverAddr, 8888);
        Scanner in = new Scanner(
            new BufferedInputStream(socket.getInputStream()));
        PrintStream out = new PrintStream(
            new BufferedOutputStream(socket.getOutputStream()), true)) {
      
      while (true) {
        boolean firstLine = true;
        while (true) {
          String message = in.nextLine();
          if (message.length() == 0) {
            break;
          }
          System.out.printf("%s%s", ((firstLine)?"":"\n"),message);
          firstLine = false; 
        }
        
        String command = keyScan.nextLine();
        out.println(command);
        
          break;
         } 
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      keyScan.close();
    }
  }
}

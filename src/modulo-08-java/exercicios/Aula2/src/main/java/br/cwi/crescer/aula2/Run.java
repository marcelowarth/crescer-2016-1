package br.cwi.crescer.aula2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import jdk.jfr.events.FileReadEvent;
public class Run {
    
    public static BufferedReader getReader(String fila) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fila));
    }
    
    public static BufferedWriter getWriter(String fila) throws IOException {
        return new BufferedWriter(new FileWriter(fila, true));
    }
    
    public static void main(String[] args) {
        System.out.println("Informe o caminho: ");
        Scanner scanner = new Scanner(System.in);
        String cam = scanner.nextLine();
        System.out.println("Informe o nick: ");
        Scanner scanner2 = new Scanner(System.in);
        String nick = scanner2.nextLine();
        funciona(cam, nick);
    }
    
    private static void funciona(String caminho, String nick) {
        new Thread(new Runnable() 
        {
            @Override
            public void run() {
                BufferedReader bufferReader = null;
                try 
                {
                    bufferReader = Run.getReader(caminho);
                    while(true) {
                        String readLine = bufferReader.readLine();
                        if (!(readLine == null || readLine.isEmpty())) {
                            System.out.println(readLine);
                        }
                        Thread.sleep(1000l);
                    }
                } catch (Exception e) {
                    //...
                } finally {
                    try {
                        if (bufferReader != null) {
                            bufferReader.close();
                        }
                    } catch (IOException ex) {
                        //...
                    }
                }
            }
        }).start();
        
        while(true) {
            System.out.println("Informe um valor: ");
            Scanner scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();
            if(":q!".equals(nextLine)) {
                break;
            }
            String dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm;ss").format(new Date());
            nextLine = dataAtual + " - " + nick + " - " + nextLine;
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = getWriter(caminho);
                bufferedWriter.write(nextLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (Exception e) {
                //...
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Exception e) {
                    //...
                }
            }
        }
    }
}
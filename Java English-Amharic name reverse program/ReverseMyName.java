package ReverseMyName;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class ReverseMyName {

    /**
     *
     */

public static int size1;


/**
     * @param args the command line arguments
     */

public static void main(String[] args) {
    
    try
 {
File file = new File("Robenus.txt");
         try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)))) { 
        // TODO code application logic here
Scanner read = new Scanner(System.in);
System.out.println("How many English names do you want to reverse? ");
size1= read.nextInt();
System.out.println("Press Enter to proceed.");
    ReverseEn Ar = new ReverseEn ();
    Ar.EngName();
    EthioMat Al= new EthioMat ();
    Al.jFrames();
         }
 }
catch(Exception e){
System.out.println("error");
}
}
}
class ReverseEn{
  int j;
    public void EngName(){
Scanner read = new Scanner(System.in);    
 String LatinMat[]= new String [ReverseMyName.size1];
for(j=0;j<ReverseMyName.size1;j++)
{
    LatinMat[j]=read.nextLine();
  System.out.println("Please enter full name "+ "number "+ j+1 + " ");
   LatinMat[j]=read.nextLine();

 if(j==ReverseMyName.size1-1){
break;
 }
   System.out.println("Press Enter");
 }
System.out.println("\n The names you entered in column array format :\n");
    for( j=0;j<ReverseMyName.size1;j++)
    {
System.out.println(LatinMat[j] + "\n");
    }

  String reverseL[]= new String [ReverseMyName.size1];    
System.out.println("\nThe names you entered when reversed respectively, in column array format: \n");
  for(j=0;j<ReverseMyName.size1;j++){   
reverseL [j]= "";
      for(int i=LatinMat[j].length()-1; i>=0; i--){
    reverseL [j] = reverseL [j] + LatinMat [j].charAt(i);
    } 
System.out.println(reverseL [j] + "\n");
  }
   for(j=0;j<ReverseMyName.size1;j++){   
       reverseL [j]= "";
    for(int i=LatinMat[j].length()-1; i>=0; i--){
reverseL [j] = reverseL [j] + LatinMat [j].charAt(i);
    } infoBox("Number " + j+1 + " your full name when reversed is: " + "\n" + reverseL[j], "Hello there!");}
   
}
    public static void infoBox(String infoMessage,String titleBar)
{  
   JOptionPane.showMessageDialog(null,infoMessage,"InfoBox:" + titleBar, JOptionPane.INFORMATION_MESSAGE );          
}
}
class EthioMat {
    public int size2;
     public int j,i;
public String k;
    public void jFrames()
    {
  
Scanner read = new Scanner(System.in);
System.out.println("How many Amharic names do you want to reverse? ");
size2= read.nextInt(); 
ArrayList Eth= new ArrayList();

for(j=0;j<size2;j++)
{
     k= read.nextLine();
System.out.println("Please enter full name "+ "number "+ j+1 + " ");    
   k= read.nextLine();
    Eth.add(k);
if(j==size2-1){
break;
 }
   System.out.println("Press Enter");
 }
System.out.println("\n The names you entered in row array format :"+"\n");
System.out.println(Eth);
 System.out.println("Press Enter");
    ArrayList <String>aa=new ArrayList<>();
    
    for(j=0;j<size2;j++)
{
     k= read.nextLine();
System.out.println("Please re-enter full name "+ "number "+ j + " ");    
   k= read.nextLine();
    
   aa.add(k);
if(j==size2-1){
break;
 }
 }
for( i=0; i<aa.size(); i++)
{
    StringBuilder builder= new StringBuilder(aa.get(i));
    builder.reverse();
    aa.set(i, builder.toString());
}
System.out.println(aa); 
for( i=0; i<aa.size(); i++)
{
    StringBuilder builder= new StringBuilder(aa.get(i));
    builder.reverse();
    aa.set(i, builder.toString());
}
for(i=0;i<aa.size();i++){
 StringBuilder builder= new StringBuilder(aa.get(i));
    builder.reverse();
    aa.set(i, builder.toString());
    JFrame cover = new JFrame ("ቁጥር "+j+ " ስሞት በአማርኛ ተገልብጦ ሲጻፍ ");
        JLabel assign =new JLabel();
        assign.setText(aa.get(i));
        assign.setFont(new Font("Geez Able", Font.PLAIN,40));
        cover.add(assign);
        cover.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cover.pack();
        cover.setVisible(true); 
}
    }
}     

   
    






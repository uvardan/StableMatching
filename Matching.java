import java.io.*;
import java.util.*;
import java.lang.StringBuilder.*;

public class Matching {

   public static void main(String [] args)throws FileNotFoundException, IOException {
       System.out.println("Testing intelija");

       // reading from the input file //
       File file=new File(args[0]);
            Scanner scanner= new Scanner(file);
       int col= Integer.parseInt(scanner.nextLine());
       int row=2*col;
       int Men [][]= new int [col+1][col];
       int Women [][]= new int [col+1][col];
       int woman=0;
   // Reading Men from the input file
       while(scanner.hasNextLine()){
           for (int i=1;i<((row/2)+1);i++){
                String [] line = scanner.nextLine().trim().split(" ");

                for(int j=0; j<col;j++){
                    Men[i][j]=Integer.parseInt(line[j]);
                }
           }
   // Reading Women from the input file
           int n=1;
           for(int k=(row/2)+1; k<row+1;k++)
           {
               String [] line = scanner.nextLine().trim().split(" ");
               for(int m=0;m<line.length;m++){
                   Women[n][m]=Integer.parseInt(line[m]);

               }
               n++;
           }
   // Creating the list of Men and Women
           Queue<Integer> womenList = new LinkedList<>();
           Queue<Integer> menList = new LinkedList<>();
           boolean CheckEngaged [] = new boolean[col+1];
          int women []= new int [col+1];
          int menOptimal[]= new int [col+1];

           for(int p=1;p<col+1;p++) {
               menList.add(p);
               womenList.add(p);
               women[p] = Integer.MIN_VALUE;
               menOptimal[p]=Integer.MIN_VALUE;

           }

           int currentEngage=Integer.MIN_VALUE;
           int proposedCheck=Integer.MIN_VALUE;
           while (!menList.isEmpty()){
              int man= menList.remove();
              for (int w=0;w<col;w++){
                   woman=Men[man][w];
                   if(CheckEngaged[woman]==false){
                       CheckEngaged[woman]=true;

                       women[woman]=man;
                       menOptimal[man]=woman;
                        break;

                   }
                   else{
                       for(int s=0;s<col;s++){
                           if(Women[woman][s]==women[woman]){
                               currentEngage=s;
                           }
                           if(Women[woman][s]==man){
                               proposedCheck=s;
                           }

                       }
                       if(proposedCheck<currentEngage){
                           menList.add(women[woman]);
                           menOptimal[man]=woman;
                           women[woman]=man;

                           break;
                         //  System.out.println("Women engagement updated to new men");
                       }

                   }
               }


           }
         //  for(int r=1;r<women.length; r++){
          //     System.out.println("Men" +(women[r])+ " : " +(r));
         //  }
           for(int d=1;d<menOptimal.length; d++){
               System.out.println("(" +d+ "," +menOptimal[d]+")");
           }




       }







   }


}

import java.io.*;   //LCS

import javax.lang.model.util.ElementScanner6;
public class LCS
{
 int[] lcs(int x[],int y[]);
 void printlcs(int b[][],int x[],int i,int j);
 public static void main(String ar[])throws IOException
 {
   int n;
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   System.out.println("Enter the number of characters in x :");
   n=Integer.parseInt(br.readLine());
   int x[]=new int[n];
   System.out.println("Enter the number of characters in y :");
   n=Integer.parseInt(br.readLine());
   int y[]=new int[n];
   System.out.println("Enter the characters in x");//Enter the characters one by one
   for(int i=0;i<n;i++)
    x[i]=Integer.parseInt(br.readLine());
   System.out.println("Enter the characters in y");//Enter the characters one by one
   for(int i=0;i<n;i++)
     x[i]=Integer.parseInt(br.readLine());
   printlcs(lcs(x,y),x,m,n);
 }
 int[] lcs(int x[],int y[])
 {
     int m=x.length,n=y.length;
     char b[][]=new char[m+1][n+1];// b is directional
     int c[][]=new int[m+1][n+1];// c is count
     int i,j;
     for(i=0;i<m+1;i++)
      c[i][0]=0;
     for(j=0;j<n+1;j++)
      c[0][j]=0;
     for(i=1;i<m+1;i++)
     {
        for(j=1;j<n+1;j++)
        {
            if(x[i]==y[j])
            {
               b[i][j]='d';//d is diagonal
               c[i][j]=c[i-1][j-1]+1; 
            }
            else if(c[i-1][j]>c[i][j-1])
            {
              b[i][j]='t';//t =top
              c[i][j]=c[i-1][j];
            }
            else
            { 
                b[i][j]='l';// l= left
                c[i][j]=c[i][j-1];

            }
        }
     }
     return b;
  }
  void printlcs(int b[][],int x[],int i,int j)
  {
      if(i==0 || j==0)
      {
          return;
      }
      else if(b[i][j]=='d')
      {
          printlcs(b,x,i-1,j-1);
          print(x[i]);
      }
      else if(b[i][j]='l')
       printlcs(b,x,i,j-1);
      else
       printlcs(b,x,i-1,j);
  }
}

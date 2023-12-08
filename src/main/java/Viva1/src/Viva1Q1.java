public class Viva1Q1 {
public static void main(String args[]){


int rows= 5;

System.out.println("");
for (int i=1; i<=rows; i++){ //outer loop
  for (int j=1; j<=(rows-i); j++){ 
  System.out.print(" "); // creating space for pyramid shape
  }
  
for (int k=i; k>=1; k--){ //inner for loop
  System.out.print(""+k);  // creating left pyramid 
  
}      

for (int l=2; l<=i; l++){ 
  System.out.print(""+l); //creating right pyramid   
}                            
System.out.println();
}                                                 
}
}
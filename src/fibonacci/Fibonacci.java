/*
Fibonacci Seriation taking into account the mathematical representation n=n-1+n-2
*/
package fibonacci;
import javax.swing.*;

public class Fibonacci {

    public static void main(String[] args) {
        //We initialize which will be used within this method
        int answer=0;
        //We call the Start() method to ask the user what he/she wants to do.
        answer=Start();
        //Depending on what the user responds is how we call the appropriate method
        if(answer==1){
            //We call the method where all the serialization will be displayed up to the position he indicates
            seriation(answer);
        }else{
            //We call the method where only the value of the position indicated by the user will be shown
            value(answer);
        }
    }
    
    public static int Start(){
        /*
        * In this method, the user will only be asked what action he/she wants to perform for this code.
        */
        
        //We initialize which will be used within this method
        int res = 0;
        Object[] Options={"Display the series","Display the value at the indicated position"};
        
        //In this error validator we ensure that the user selects an option and/or that no problems arise with the code.
        try{
            /*
            *We initialize the variable that will store the value that the user wants to perform, 
            as well as display a dialog box requesting the action to be performed.
            */
            String dat = String.valueOf(
                JOptionPane.showInputDialog(null,"Select an option","Fibonacci Seriation",JOptionPane.QUESTION_MESSAGE,null,Options,null));
            //Validate that the user does not cancel code execution
            if(dat != "null"){
                //Validate which option the user has chosen in the dialog box
                if(dat.equalsIgnoreCase("Display the series")){
                    //We assign the value 1 to the variable that we will return from the method
                    res=1;
                }else{
                    //We assign the value 2 to the variable that we will return from the method
                    res=2;
                }
            }else{
                //If code execution has been cancelled, the program will be terminated.
                System.exit(0);
            }
        }catch(Exception e){
            //In case of an error, we will show it in console
            System.out.println("Erro "+e.getMessage());
        }
        //We return the value assigned to the option selected by the user.
      return res;
        
    }
    
    public static void seriation(int val){
        /*
        * In this method we will show the total number of serializations required by the user.
        */
        
        //We initialize which will be used within this method
        int V1=0, V2=1, R=0, con=0, ser=0;
        String seria="";
        //In this error validator we ensure that the user selects an option and/or that no problems arise with the code.
        try{
            //We store the position where the user wants to stop the serialization, we also convert this value to type Int.
            ser= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of series you require"));
            /*
            * With this cycle of type While, we will perform the interactions that the user indicated 
            and at the same time we will store them in a variable
            */
            while(con<ser){
                if(con<2){
                    if(con==0){
                        //We store the first value of the serialization
                        seria= "" +V1;
                    con++;
                    }else{
                        //We store the second value of the serialization
                        seria=seria + ", " + V2;
                    con++;
                    }
                }else{
                    /*
                    *We perform the mathematical operation, 
                    then store the result in the variable, 
                    then assign the new values to each position.
                    ** Note: The serialization is stored as a text string without losing any of its values.
                    */
                    R=V1+V2;
                    seria=seria + ", " + R;
                    V1=V2;
                    V2=R;
                    R=0;
                    con++;
                }
            }
            //We show on the screen the serialization up to the position indicated by the user.
            JOptionPane.showMessageDialog(null, seria, "Fibonacci Seriation", 1);

            }catch(Exception e){
                //In case of an error, we will show it in console
                System.out.println("Error: "+e.getMessage());
            }
    }
    
    public static void value(int val){
        /*
        * In this method we will perform the interactions required by the user 
        and we will only store the value of the position requested by the user.
        */
        
        //We initialize which will be used within this method
        int V1=0, V2=1, R=0, con=2, ser=0;
        
        //In this error validator we ensure that the user selects an option and/or that no problems arise with the code.
        try{
            //We ask the user for the position of the value he/she wants, we also convert the user's answer to type Int to store it in a variable.
            ser= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the desired position"));
            //In this While loop we will perform the interactions requested by the user and only the value for the indicated position will be stored.
            while(con<=ser){
                R=V1+V2;
                V1=V2;
                V2=R;
                con++;
            }
            //The value of the indicated position is displayed in a dialog box.
            JOptionPane.showMessageDialog(null, "The value is: "+R, "Fibonacci Seriation", 1);
        }catch(Exception e){
            //In case of an error, we will show it in console
            System.out.println("Error: "+e.getMessage());
        }
    }
}
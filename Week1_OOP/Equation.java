import javax.swing.JOptionPane;
public class Equation{

    public static void firstsol() {

        
        String Strnum1, Strnum2; 
        Strnum1 = JOptionPane.showInputDialog(null, "Please Input first num", "First order equation with one variable", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(Strnum1); 
        Strnum2 = JOptionPane.showInputDialog(null, "Please Input second number", "First order equation with one variable", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(Strnum2); 
        if (num1 == 0){
            if(num2==0) JOptionPane.showMessageDialog(null,"This equation has infinite solutions!","Solution of equation",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null,"This equation has no solution!","Solution of equation",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            double res = -num2/num1;
            JOptionPane.showMessageDialog(null, res, "Root of first order equation", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public static void secondsol(){
        
        double a11, a12, a21, a22, b1, b2;
    
        a11 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a11:", "System of first-order equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        a12 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a12:", "System of first-order equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        a21 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a21:", "System of first-order equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        a22 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a22:", "System of first-order equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        b1 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient b1:", "System of first-order equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        b2 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient b2:", "System of first-order equations with two variables", JOptionPane.INFORMATION_MESSAGE));
    
        double det = a11 * a22 - a12 * a21;
    
        if (det == 0) {
            if (a11 * b2 == a21 * b1 && a12 * b2 == a22 * b1) {
                JOptionPane.showMessageDialog(null, "The system of equations has infinite solutions!", "Soltution of system of equations", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The system of equations has no solutions!", "Soltution of system of equations", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        else {
            double x1 = (a22 * b1 - a12 * b2) / det;    
            double x2 = (a11 * b2 - a21 * b1) / det;
            JOptionPane.showMessageDialog(null, "Solution: x1 = " + x1 + ", x2 = " + x2, "Solution of system of equations", JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    // second order equation with 1 variable 
    public static void thirdsol(){
        
        String stra, strb, strc; 
        stra = JOptionPane.showInputDialog(null, "Please Input a", "Second order equation with one variable", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(stra);
        strb = JOptionPane.showInputDialog(null, "Please Input b", "Second order equation with one variable", JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strb);
        strc = JOptionPane.showInputDialog(null, "Please Input c", "Second order equation with one variable", JOptionPane.INFORMATION_MESSAGE);
        double c = Double.parseDouble(strc);
        if(a == 0) JOptionPane.showMessageDialog(null, "Error value of a", "Error", JOptionPane.INFORMATION_MESSAGE);
        else{
            double delta = b*b - 4*a*c;
            if(delta < 0) JOptionPane.showMessageDialog(null, "No solution", "Roots of equation", JOptionPane.INFORMATION_MESSAGE);
            if(delta == 0){
                double x = (-b - Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null, "x1 = x2 = " + x , "Roots of equation", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                double x = (-b + Math.sqrt(delta))/(2*a);
                double y = (-b - Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null, "x1 = " + x + ", x2 = " + y, "Roots of equation", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
    }
    public static void main(String args[]){
        String a[]={"1","2"};
        int numvar=   Integer.parseInt((String)JOptionPane.showInputDialog(null,"Input the number of variables:","Number of variables of equation",
        JOptionPane.QUESTION_MESSAGE,null,a,1));
        if(numvar == 1){
            int degree=   Integer.parseInt((String)JOptionPane.showInputDialog(null,"Input the degree of the equation:","Degree of equation",
            JOptionPane.QUESTION_MESSAGE,null,a,1));
            if(degree == 1 ){
                Equation.firstoder_onevar(); 
            }
            else Equation.firstoder_twovars();
        }
        else Equation.secondorder_onevar();
    }
}
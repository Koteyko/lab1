package laba1;
import java.text.DecimalFormat;

public class Main {

    static double func1(double x){
        return Math.pow( Math.pow(Math.cos(x)/0.5, Math.pow(x, 1/3)) * (0.5-Math.tan(Math.pow(x, 1/3))), 
                         Math.asin(1/Math.pow(Math.E, Math.abs(x))));
    }
    
    static double func2(double x){
        return Math.pow((Math.pow(0.5/(x-2/3), 2) + 1)/Math.asin((x+1)/18),
                        (1-Math.pow(4*x*x, 4*Math.cos(x)))/2 * Math.log(Math.abs(x)));
    }
    
    static double func3(double x){
        return Math.asin(Math.cos(Math.asin(Math.pow(Math.E, Math.PI/2/Math.abs(x)*Math.PI/2/Math.abs(x))/3)));
    }
    
    static double RandomDouble(double from, double to){
        return Math.random() * (to-from) + from;
    }

    public static void main(String[] args) {
        final double lowerEdge = -8.0;
        final double upperEdge = 10.0;
        
        long[] d = new long[9];
        double[] x = new double[14];
        double[][] d2 = new double[9][14];
        
        for(int i=0, j=7; i<d.length; i++, j+=2)
            d[i]=j;
        for(int i=0; i<x.length; i++)
            x[i]= RandomDouble(lowerEdge, upperEdge);
        
        for(int i=0; i< d2.length; i++){
            for(int j=0; j< d2[i].length; j++){
                if(d[i]==19) d2[i][j]= func1(x[j]);
                else if(d[i]==7 || d[i]==9 || d[i]==13 || d[i]==23) d2[i][j]= func2(x[j]);
                else d2[i][j]=func3(x[j]);
            }
        }
        for(double[] i : d2){
            for(double j : i)
                System.out.printf(" %8.4f ", j);
            System.out.println("");
        }
        
    }
    
}

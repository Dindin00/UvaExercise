//  UVa題目網址：
//  https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=913
import java.util.*;
public class Main_UVa00972 {
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int a = sc.nextInt();
            double[][] dataA = new double[a][3];
            double start = 0.0;
            for (int i = 0; i < a; i++) {
                dataA[i][0] = start;
                dataA[i][2] = sc.nextDouble();
                dataA[i][1] = sc.nextDouble();
            }
        }
    }
}

import java.util.*;
public class Main_UVa00688 {
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);

//        用來儲存本次解共有幾個矩形
        int n = sc.nextInt();
//        用來儲存目前為第幾個解
        int count = 0;

//        若輸入矩形數量為0則結束，不為0才進行計算
        while (n != 0){

//            不為0則先+1代表目前為第幾個解
            count++;
//            用來儲存所有矩形的x軸起始位置、x軸結束位置、y軸起始位置、y軸結束位置，此陣列將用於比對是否於矩形覆蓋面積內
            double[][] blocks = new double[n][4];
//            用來儲存所有x軸的點，用來切割x軸，得所有小矩形的x軸起始位置及結束位置
            double[] a = new double[n * 2];
//            用來儲存所有y軸的點，用來切割y軸，得所有小矩形的y軸起始位置及結束位置
            double[] b = new double[n * 2];
//            用來儲存目前所有矩形覆蓋面積的總和
            double total = 0.0;

//            依照上面所輸入矩形數量開始讀取矩形資料
            for (int m = 0; m < n; m++) {
//                依照題意讀入矩形中心點(x,y)及大小
                double in_x = sc.nextDouble(), in_y = sc.nextDouble(), in_r = sc.nextDouble();
//                換算出該矩形x軸起始位置
                blocks[m][0] = in_x - in_r;
//                換算出該矩形x軸結束位置
                blocks[m][1] = in_x + in_r;
//                換算出該矩形y軸起始位置
                blocks[m][2] = in_y - in_r;
//                換算出該矩形y軸結束位置
                blocks[m][3] = in_y + in_r;
//                將本次換算出來所有x軸點存入a陣列，所有y軸點存入b陣列
                for (int i = 0; i < 2; i++) {
                    a[m * 2 + i] = blocks[m][i];
                    b[m * 2 + i] = blocks[m][i + 2];
                }
            }

//            將a、b陣列由小到大排序
            Arrays.sort(a);
            Arrays.sort(b);

//            依序讀取所有x軸點及y軸點，並每次從x及y各抓個點組成小矩形，並判斷是否被輸入的大矩形覆蓋，若是則計算出小矩形面積，再加總起來
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = 0; j < b.length - 1; j++) {
                    for (int k = 0; k < blocks.length; k++) {
                        if (a[i] >= blocks[k][0] && a[i + 1] <= blocks[k][1] && b[j] >= blocks[k][2] && b[j + 1] <= blocks[k][3]) {
                            total += (a[i + 1] - a[i]) * (b[j + 1] - b[j]);
                            break;
                        }
                    }
                }
            }

//            依照題意輸出，需先輸出第幾個解，再輸出面積總合(需要進行四捨五入至小數點第二位)，注意count及面積總合之間需要空白，且結束需要斷行
            System.out.printf("%d %.2f\n", count, ((int) Math.round(total * 100.0)) / 100.0);
//            再重新讀取矩形數量
            n = sc.nextInt();
        }
    }
}

//  UVa題目網址
//  https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=41
//  中文題目網址
//  http://luckycat.kshs.kh.edu.tw/homework/q105.htm

import java.util.*;

public class Main_UVa00105 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        用來儲存每個位置的最高高度，且題目表示數字最大只會到10000，故為了方便計算索引值將陣列長度加一
        int[] datas = new int[10001];
//        用來存放本次輸入的起始位置及結束位置，先別設定最小及最大值
        int max = 0;
        int min = 10001;

//        判斷還有整數輸入就繼續讀取
        while (sc.hasNextInt()){
//            依照題意將每棟建築起始位置、高度、結束位置存取起來
            int left = sc.nextInt(), top = sc.nextInt(), right = sc.nextInt();
//            本次起始位置如果大於目前建築物起始位置，則本次起始位置改為目前建築物的起始位置
            if (min > left) {
                min = left;
            }
//            本次結束位置如果小於目前建築物結束位置，則本次結束位置改為目前建築物的結束位置
            if (max < right) {
                max = right;
            }
//            將目前建築物的高度依照起始及結束位置填入陣列中，有比原先該位置的高度大才填入
//            注意！如果有一建築物起始位置與另一建築物結束位置相同但高度不同，則需要取起始那方，故填入時不填結束位置
            for (int i = left; i < right; i++) {
                if (top > datas[i]) {
                    datas[i] = top;
                }
            }
        }

//        用來存放目前讀取到的高度
        int current = 0;

//        從本次起始位置開始讀取每筆高度直到本次結束位置為止
        for (int i = min; i <= max; i++) {
//            如果i位置的高度大於目前高度，則將當前高度修改為i位置高度，且印出i及當前高度
            if (datas[i] != current) {
                current = datas[i];
//                若為結束位置了則不用印每次間隔的空白，且需斷行
                if (i == max) {
                    System.out.println(i + " " + current);
                }else {
                    System.out.print(i + " " + current + " ");
                }
            }
        }
    }
}
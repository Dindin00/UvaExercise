//  UVa題目網址：
//  https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=913
import java.util.*;
public class Main_UVa00972 {
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);

//        依照題意可發現每次解的開頭輸入都是整數，因此判斷是否有整數輸入有則進行處理
        while (sc.hasNextInt()){

//            讀取本次解的第一組數據共有幾筆
            int a = sc.nextInt();
//            用來存放第一組數據的內容，主要用於後面比對是否於此區域內，決定高度值之用
            double[][] dataA = new double[a][3];
//            用來存放第一組數據每一步的起始位置，預設從0開始走
            double start = 0.0;
//            用來存放所有的小區段的起始位置及結束位置，用於知道共有哪些小區域
            ArrayList<Double> array = new ArrayList<Double>();
//            將起點(0.0)也加入其中，後續計算才會抓得到第一個小區域
            array.add(start);
//            開始依前面所輸入第一組筆數依序讀取值，並儲存起來
            for (int i = 0; i < a; i++) {
//                將目前起始位置儲存至陣列中每個大區段起始位置
                dataA[i][0] = start;
//                讀取下一個值儲存至陣列中每個大區段的高度
                dataA[i][2] = sc.nextDouble();
//                將位置依據下一個值做推移，即可得目前大區段的結束位置及下個大區段的開始位置
                start += sc.nextDouble();
//                再將推移後的位置儲存至陣列中的每個大區段結束位置
                dataA[i][1] = start;
//                將目前起始位置新增至array中，來切割小區域
                array.add(dataA[i][1]);
            }
//            讀取本次解的第二組數據共有幾筆
            int b = sc.nextInt();
//            用來存放第二組數據的內容，主要用於後面比對是否於此區域內，決定高度值之用
            double[][] dataB = new double[b][3];
//            每次都從0.0開始，故先將目前起始位置歸零
            start = 0.0;
//            開始依前面所輸入第二組筆數依序讀取值，並儲存起來
            for (int i = 0; i < b; i++) {
//                將目前起始位置儲存至陣列中每個大區段起始位置
                dataB[i][0] = start;
//                讀取下一個值儲存至陣列中每個大區段的高度
                dataB[i][2] = sc.nextDouble();
//                將位置依據下一個值做推移，即可得目前大區段的結束位置及下個大區段的開始位置
                start += sc.nextDouble();
//                再將推移後的位置儲存至陣列中的每個大區段結束位置
                dataB[i][1] = start;
//                為避免需要處理重複的位置，故只存沒有存在於array中的位置
                if (!array.contains(dataB[i][1])) {
                    array.add(dataB[i][1]);
                }
            }
//            將array由小到大進行排序，讓我們可依照直線上依序擷取小區域
            Collections.sort(array);
//            由於題目要求最後結果為兩組數據構成的每個小區域的最高點之中的最低點，因此開此變數進行儲存該最後結果
            double minInMax = 10.0;
//            從array依序每次抓兩個位置切割小區域
            for (int i = 0; i < array.size() - 1; i++) {
//                用來儲存目前小區段的最高點
                double nowMax = 0.0;
//                依序判斷是位於第一筆的哪個大區段中並取得高度
                for (int j = 0; j < dataA.length; j++) {
                    if (array.get(i) >= dataA[j][0] && array.get(i + 1) <= dataA[j][1]) {
                        nowMax = dataA[j][2];
                        break;
                    }
                }
//                依序判斷是位於第二筆的哪個大區段中並取得高度
                for (int j = 0; j < dataB.length; j++) {
                    if (array.get(i) >= dataB[j][0] && array.get(i + 1) <= dataB[j][1]) {
//                        若有大於上一筆產生的最高點才修改最高點的值
                        nowMax = dataB[j][2] > nowMax ? dataB[j][2] : nowMax;
                        break;
                    }
                }
//                若目前的最高點小於之前每次小區段取得的最高點才會修改目前最小的最高點
                minInMax = nowMax < minInMax ? nowMax : minInMax;
            }
//            依照題意取小數點後三位四捨五入，且只印出小數點後三位，並最後斷行
            System.out.printf("%.3f\n", ((int) Math.round(minInMax * 1000.0)) / 1000.0);
        }
    }
}

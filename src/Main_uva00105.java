//  UVA題目網址
//  https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=41
//  中文題目網址
//  http://luckycat.kshs.kh.edu.tw/homework/q105.htm

import java.util.*;

public class Main_uva00105 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        讀取建築物資料，將左邊位置及右邊位置分別儲存，且右邊的高度加上負號(用於辨識該建築物結束位置)
        ArrayList<int[]> datas = new ArrayList<int[]>();
        while (sc.hasNextInt()){
            int left = sc.nextInt(), top = sc.nextInt(), right = sc.nextInt();
            int[] leftData = {left, top}, rightData = {right, top * -1};
            datas.add(leftData);
            datas.add(rightData);
        }

//        將所有建築物左邊及右邊進行直線上的排序
        for (int i = 0; i < datas.size(); i++) {
            for (int j = 0; j < datas.size(); j++) {
                if (datas.get(i)[0] < datas.get(j)[0] && i != j) {
                    int[] temp = datas.get(i);
                    datas.set(i, datas.get(j));
                    datas.set(j, temp);
                }
            }
        }

        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            if (current.size() == 0) {
                ans.add(datas.get(i)[0]);
                ans.add(datas.get(i)[1]);
                current.add(datas.get(i)[1]);
                Collections.sort(current);
            }else {
                int index = datas.get(i)[0];
                int top = datas.get(i)[1];
                if (top > 0) {
                    boolean check = true;
                    if (top > current.get(current.size() - 1)) {
                        for (int j = 0; j < ans.size(); j+=2) {
                            if (ans.get(j) == index && ans.get(j + 1) < top) {
                                ans.set(j + 1, top);
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            ans.add(datas.get(i)[0]);
                            ans.add(datas.get(i)[1]);
                        }
                    }
                    current.add(datas.get(i)[1]);
                    Collections.sort(current);
                }else {
                    removeVale(current, Math.abs(top));
                    if (current.size() == 0) {
                        if (ans.get(ans.size() - 2) == index) {
                            ans.set(ans.size() - 1, 0);
                        }else {
                            ans.add(datas.get(i)[0]);
                            ans.add(0);
                        }
                    }else if (Math.abs(top) > current.get(current.size() - 1)) {
                        if (ans.get(ans.size() - 2) == index && ans.get(ans.size() -1) <= Math.abs(top)) {
                            ans.set(ans.size() -1, Math.abs(top));
                        }else {
                            ans.add(datas.get(i)[0]);
                            ans.add(current.get(current.size() - 1));
                        }
                    }
                }
            }
        }

//        輸出結果
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                System.out.println(ans.get(i));
            }else {
                System.out.print(ans.get(i) + " ");
            }
        }
    }

    public static ArrayList<Integer> removeVale(ArrayList<Integer> list, int top){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == top) {
                list.remove(i);
                break;
            }
        }
        return list;
    }
}

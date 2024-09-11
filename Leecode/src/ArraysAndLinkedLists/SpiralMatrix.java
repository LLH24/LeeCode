package ArraysAndLinkedLists;

public class SpiralMatrix {

    /***
     * 螺旋数字
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int number = 1;
        int x = 0;
        int y = 0;
        int endx = 0;
        int endy = 0;
        int needCircle = n/2;//需要写的圈数
        Boolean single = (n%2 == 1);//是否为积
        int nowCircle = 1;//当前圈数
        while(nowCircle <= needCircle){
            for (int j = y;j<n-(nowCircle-1)*2-1+y;j++){//int j = y;j<n-(nowCircle-1)*2-1+y;其中n-(nowCircle-1)*2-1为需要的个数
                //y为起点，n-(nowCircle-1)*2-1为长度，n-(nowCircle-1)*2-1+y为终点
                result[x][j] = number++;
                endx = x;
                endy = j+1;
            }

            for (int i = endx;i<n-(nowCircle-1)*2-1+x;i++){
                result[i][endy] = number++;
                endx = i+1;
            }

            for (int j = endy;j>0+y;j--){
                result[endx][j] = number++;
                endy = j-1;
            }

            for (int i = endx;i>0+x;i--){
                result[i][endy] = number++;
            }
            x++;
            y++;
            nowCircle++;
        }
        if(single){//对不同圈进行分开处理
            result[x][y] = number;
        }
            return result;
    }
}

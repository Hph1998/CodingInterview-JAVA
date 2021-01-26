import java.lang.annotation.Retention;
import java.lang.reflect.Array;

/**
 * @author Lucas
 * @version 1.0.0
 * @ClassName Find01.java
 * @Description TODO
 * @createTime 2021年01月26日 15:55:00
 */
public class Find01 {

    public static boolean Find(int target, int [][] array) {
        if(array == null){
            return false;
        }
        int hLen = array.length;
        int wLen = array[0].length;
        for (int i = 0; i < hLen; i++){
            for (int j = 0;j< wLen; j++) {
                int key = array[i][j];
                if (key == target) {
                    return true;
                } else if (key > target) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int [][]array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7, array));
    }

}

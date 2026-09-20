import java.util.Arrays;

public class Top3_Podium {
    static int[] findTopThreeScores(int[] scores){
        int first=scores[0];
        int second=scores[0];
        int third=scores[0];
        for (int num:scores){

            if (num > first) {
                third = second;
                second = first;
                first = num;
            }
            else if (num > second) {
                third = second;
                second = num;
            }
            else if (num > third) {
                third = num;
            }
        }
        return new int[]{first,second,third};
    }
    public static void main(String[] args) {
        int [] scores={45, 82, 79, 90, 33, 90, 61};
        int[] topThree = findTopThreeScores(scores);
        System.out.println(Arrays.toString(topThree));
    }
}

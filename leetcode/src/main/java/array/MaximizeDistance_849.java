package array;

/**
 * <p>849. Maximize Distance to Closest Person</p>
 * <p>
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * <p>
 * There is at least one empty seat, and at least one person sitting.
 * <p>
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * <p>
 * Return that maximum distance to closest person.
 *
 * @author jixd
 * @Date Created in 2019年02月18日 16:34
 */
public class MaximizeDistance_849 {


    public int maxDistToClosest(int[] seats) {
        int i, j, res = 0, n = seats.length;
        for (i = j = 0; j < n; ++j)
            if (seats[j] == 1) {
                if (i == 0) {
                    res = Math.max(res, j - i);
                } else {
                    res = Math.max(res, (j - i + 1) / 2);
                }
                i = j + 1;
            }
        res = Math.max(res, n - i);
        return res;
    }

}

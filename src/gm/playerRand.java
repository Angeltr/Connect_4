/**
 *
 * @author Angelos Trigkas
 */

package gm;

import java.util.*;


/**
 * 
 * @author Angelos Trigkas
 * 
 * Class playerRand implements a computer player that makes
 * random moves.
 */
public class playerRand {

    private Random rand = new Random();

    int getMove(Board cB) {
        List<Integer> poss = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            if (cB.validMove(i)) {
                poss.add(i);
            }
        }
        return poss.get(Math.abs(rand.nextInt(poss.size())));
    }
}

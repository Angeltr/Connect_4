/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gm;

import java.util.*;

/**
 *
 * @author Angel
 */
public class playerRand {
    private Random rand = new Random();
int getMove(Board cB)
{
List<Integer> poss= new ArrayList<Integer>();
for(int i = 0; i <7; i++)
{
if(cB.validMove(i))
{
poss.add(i);
}
}
return poss.get(Math.abs(rand.nextInt(poss.size())));
}
}

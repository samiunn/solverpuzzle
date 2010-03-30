/*
 * Created on 27 mars 2010
 * @author jtoumit
 */
package jyt.game.puzzle.solving.impl.actions;

import jyt.game.puzzle.solving.IAction;
import jyt.game.puzzle.solving.Puzzle;

public class RotationCounterClockWise<T> implements IAction<T>
{
	private int x;
	private int y;

	/**
	 * Created on 27 mars 2010 by jtoumit.<br>
	 * @param pX
	 * @param pY
	 */
	public RotationCounterClockWise(int pX, int pY)
	{
		super();
		x = pX;
		y = pY;
	}

	public void doAction(Puzzle<T> pPuzzle)
	{
		T save = pPuzzle.get(x, y);
		pPuzzle.set(x, y, pPuzzle.get(x + 1, y));
		pPuzzle.set(x + 1, y, pPuzzle.get(x + 1, y + 1));
		pPuzzle.set(x + 1, y + 1, pPuzzle.get(x, y + 1));
		pPuzzle.set(x, y + 1, save);
	}

	@Override
	public IAction<T> getReverseAction(Puzzle<T> pPuzzle)
	{
		return new RotationClockWise<T>(x, y);
	}
}

package es.uvigo.esei.gdcr.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uvigo.esei.gdcr.gol.*;


public class BoardTest 
{
	private Board board;
	
	@Before
	public void initialize()
	{
		board = new Board();
	}
	
	@Test
	public void fewerThanTwoDies() 
	{		
		board.set(new LiveCell(), 0, 0);
		board.set(new LiveCell(), 0, 1);
		board.set(new LiveCell(), 0, 2);
		
		board.nextGeneration();
		
		assertFalse(board.isAlive(0,0));
		assertTrue(board.isAlive(0,1));
		assertFalse(board.isAlive(0,2));
	}
	
	@Test
	public void oscilatorTest()
	{
		board.set(new LiveCell(), 1, 2);
		board.set(new LiveCell(), 2, 2);
		board.set(new LiveCell(), 3, 2);
		
		board.nextGeneration();
		
		assertTrue(board.isAlive(2,1));
		assertTrue(board.isAlive(2,2));
		assertTrue(board.isAlive(2,3));
	}
}

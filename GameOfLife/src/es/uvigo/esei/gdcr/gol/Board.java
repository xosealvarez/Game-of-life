package es.uvigo.esei.gdcr.gol;

public class Board 
{
	private Cell[][] board;
	private final int x = 10;
	private final int y = 10;
	
	public Board()
	{
		this.board = new Cell[this.x][this.y];
		
		for(int i=0; i<this.x;i++)
		{
			for(int j=0; j<this.y;j++)
			{
				this.board[i][j] = new DiedCell();
			}
		}
	}

	public void set(Cell cell, int x, int y) 
	{
		this.board[x][y] = cell;
	}

	public void nextGeneration() 
	{
		Cell[][] nextBoard = new Cell[this.x][this.y];
		
		for(int i=0; i<this.x;i++)
		{
			for(int j=0; j<this.y;j++)
			{	
				nextBoard[i][j] = board[i][j].getNextState(this.countNeighbours(i,j));
			}
		}
		
		board = nextBoard;
	}

	public boolean isAlive(int x, int y) 
	{
		return this.board[x][y].isAlive();			
	}
	
	private int countNeighbours(int x, int y)
	{
		int count = 0;
		
		for(int i=x-1; i<=x+1;i++)
		{
			for(int j=y-1; j<=y+1;j++)
			{
				if((i>=0 && i<10 && j>=0 && j<10) && (i!=x || j!=y))
				{					
					if(board[i][j].isAlive())
					{
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	@Override
	public String toString()
	{
		String cad = "";
		
		for(int i=0; i<this.x;i++)
		{
			for(int j=0; j<this.y;j++)
			{
				if(board[i][j].isAlive())
				{
					cad += " X ";
				}
				else
				{
					cad += " O ";
				}
			}
			cad += "\n";
		}
		
		return cad;
	}
}

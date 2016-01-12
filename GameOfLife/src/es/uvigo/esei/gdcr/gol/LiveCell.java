package es.uvigo.esei.gdcr.gol;

public class LiveCell extends Cell 
{
	@Override
	public boolean isAlive() 
	{
		return true;
	}

	@Override
	public Cell getNextState(int countNeighbours) 
	{
		if(countNeighbours<2)
		{
			return new DiedCell();
		}
		else if(countNeighbours==2 || countNeighbours==3)
		{
			return this;
		}
		else //if(countNeighbours>3)
		{
			return new DiedCell();
		}
	}
}

package es.uvigo.esei.gdcr.gol;

public class DiedCell extends Cell 
{
	@Override
	public boolean isAlive() 
	{
		return false;
	}

	@Override
	public Cell getNextState(int countNeighbours) 
	{
		if(countNeighbours==3)
		{
			return new LiveCell();
		}
		else
		{
			return this;
		}
	}
}

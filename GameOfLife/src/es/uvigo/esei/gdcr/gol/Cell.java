package es.uvigo.esei.gdcr.gol;

public abstract class Cell 
{
	public abstract boolean isAlive();
	public abstract Cell getNextState(int countNeighbours);
}

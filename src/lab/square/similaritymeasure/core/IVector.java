package lab.square.similaritymeasure.core;

public interface IVector {
	public int getDimension();
	public boolean getValue(int dimension);
	public void printAll();
	public boolean equals(IVector vector);
}

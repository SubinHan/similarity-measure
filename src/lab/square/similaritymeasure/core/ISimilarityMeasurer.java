package lab.square.similaritymeasure.core;

import java.util.Collection;

public interface ISimilarityMeasurer {
	public double comparate(IVector v1, IVector v2) throws Exception;
	public IVector calculateMostSimilar(IVector vector, Collection<IVector> others);
}

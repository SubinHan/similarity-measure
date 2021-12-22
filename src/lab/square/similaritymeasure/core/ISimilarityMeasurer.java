package lab.square.similaritymeasure.core;

//import java.util.Collection;
import java.util.List;

public interface ISimilarityMeasurer {
	public double compare(IVector v1, IVector v2) throws Exception;
	public double[] calculateMostSimilar(IVector target, List<IVector> others, int exclude) throws Exception;
}

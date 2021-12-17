package lab.square.similaritymeasure.core;

import java.util.Collection;

public class Jaccard implements ISimilarityMeasurer {
	
	
	public Jaccard() {
		
	}
	
	@Override
	public double comparate(IVector v1, IVector v2) throws Exception {
		if(v1.getDimension() != v2.getDimension()) {
			throw new Exception("The dimensions are not the same");
		}
		
		int dimension = v1.getDimension();
		
		int common = 0;
		
		for(int i = 0; i < dimension; i++) {
			if(v1.getValue(i) == v2.getValue(i) && v1.getValue(i)) {
				common++;
			}
		}
		
		int numV1 = 0, numV2 = 0;
		
		for(int i = 0; i < dimension; i++) {
			if(v1.getValue(i))
				numV1++;
			if(v2.getValue(i))
				numV2++;
		}
		
		double result = (double)common / (double)(numV1 + numV2 - common);
		
		return result;
	}

	@Override
	public IVector calculateMostSimilar(IVector vector, Collection<IVector> others) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

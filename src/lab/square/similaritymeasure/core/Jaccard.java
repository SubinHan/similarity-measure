package lab.square.similaritymeasure.core;

//import java.util.Collection;
import java.util.List;

public class Jaccard implements ISimilarityMeasurer {
	
	
	public Jaccard() {
		
	}
	
	@Override
	public double compare(IVector v1, IVector v2) throws Exception {
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
	public double[] calculateMostSimilar(IVector target, List<IVector> others, int exclude) throws Exception {
		double [] max = new double[] {0.0, -1.0}; // 최종 유사도, 최종 인덱스 
		
		for(int i=0; i<others.size(); i++) {
			if(i == exclude) continue;
			IVector it = others.get(i);
			if(target.getDimension() != it.getDimension()) {
				throw new Exception("The dimensions are not the same");
			} 
			double res = compare(target, it);
			if(max[0] < res) {
				max[0] = res;
				max[1] = i;
			}
		}
		return max;
	}
}

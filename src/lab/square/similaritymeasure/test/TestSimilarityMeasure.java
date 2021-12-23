package lab.square.similaritymeasure.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;

import lab.square.similaritymeasure.core.ISimilarityMeasurer;
import lab.square.similaritymeasure.core.IVector;
import lab.square.similaritymeasure.core.Jaccard;
import lab.square.similaritymeasure.core.MostSimilarVector;

public class TestSimilarityMeasure {
	@Test
	public void testMeasure() throws Exception {

		IVector v1 = new Vector(new boolean[] { true, true, true, false, false });
		IVector v2 = new Vector(new boolean[] { true, true, false, false, false });
		IVector v3 = new Vector(new boolean[] { true, false, false, false, false });
		
		List<IVector> list = List.of(v1, v2, v3);  // Java 9 이상
		
		ISimilarityMeasurer measurer;
		measurer = new Jaccard();	
		
		System.out.println(measurer.compare(v1, v2));
		System.out.println(measurer.compare(v1, v3));
		
		assertTrue(measurer.compare(v1, v2) > measurer.compare(v1, v3));
		assertTrue(measurer.compare(v1, v2) == measurer.compare(v2, v1));
		

		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			IVector target = list.get(i);
			MostSimilarVector result = measurer.calculateMostSimilar(list, i);  // list의 i번째 요소를 타켓으로, 그와 제일 비슷한 IVector를 찾는다. 단, i 제외																		// 단, 자기 자신은 list에서 제외한 채로.
			for(IVector vector : result.vectors) {
				System.out.print("list의 "+i+"번째 요소 ");   target.printAll();   System.out.print(" 와 \n");
				vector.printAll();   
				System.out.print(" 은 가장 유사하다. (유사도 " + result.similarity +")\n\n");
			}
		}
		
		
		
//		int resultIndex = measurer.calculateMostSimilar(v1, list, 0);  // 일단 한개만 test 해보았을 때의 상황
//		IVector resultVector = list.get(resultIndex);
//		for(int i=0; i<resultVector.getDimension(); i++) {
//			System.out.print(resultVector.getValue(i) + " ");
//		} System.out.println();
		
		
	}

	private class Vector implements IVector {
		private boolean[] vector;

		public Vector(boolean[] vector) {
			this.vector = vector;
		}

		@Override
		public int getDimension() {
			return vector.length;
		}

		@Override
		public boolean getValue(int dimension) {
			return vector[dimension];
		}

		@Override
		public void printAll() {
			for(boolean v : vector) {
				System.out.print(v + " ");
			}
		}
		
		@Override
		public boolean equals(IVector vector) {
			int i = 0;
			
			if(getDimension() != vector.getDimension()) {
				return false;
			}
			
			for(boolean v : this.vector) {
				if(v != vector.getValue(i++)) {
					return false;
				}
			}
			return true;
		}
	}
}

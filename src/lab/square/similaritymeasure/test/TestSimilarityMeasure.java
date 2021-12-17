package lab.square.similaritymeasure.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import lab.square.similaritymeasure.core.ISimilarityMeasurer;
import lab.square.similaritymeasure.core.IVector;
import lab.square.similaritymeasure.core.Jaccard;

public class TestSimilarityMeasure {

	@Test
	public void testMeasure() throws Exception {

		IVector v1 = new Vector(new boolean[] { true, true, true, false, false });
		IVector v2 = new Vector(new boolean[] { true, true, false, false, false });
		IVector v3 = new Vector(new boolean[] { true, false, false, false, false});
		
		ISimilarityMeasurer measurer;
		
		measurer = new Jaccard();	
		
		System.out.println(measurer.comparate(v1, v2));
		System.out.println(measurer.comparate(v1, v3));
		
		assertTrue(measurer.comparate(v1, v2) > measurer.comparate(v1, v3));
		assertTrue(measurer.comparate(v1, v2) == measurer.comparate(v2, v1));
		
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

	}

}

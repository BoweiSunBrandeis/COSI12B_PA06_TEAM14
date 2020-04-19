package pa06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample) and a list of Samples
 * (the one's closest to that sample point, ideally).
 * 
 * @author Team 14
 *
 */
public class Cluster {
	private Sample clusterPoint;
	private ArrayList<Sample> cluster;

	public Cluster(ArrayList<Sample> samples) {
		this.cluster = samples;

	}

	/**
	 * choose k items from the Sample list
	 * 
	 * @param the number of samples to pick
	 * @return a list of elements which are randomly chosen
	 */
	public Sample[] randomPick(int num) {
		Collections.shuffle(cluster);
		Sample[] res = new Sample[num];
		for (int i = 0; i < num; i++) {
			res[i] = cluster.get(i);
		}
		return res;
	}

	public void add(Sample sample) {
		this.cluster.add(sample);
	}

	/**
	 * prints contents of cluster
	 */
	public void print() {
		for (int i = 0; i < this.cluster.size(); i++) {
			System.out.print("{");
			for (int j = 0; j < this.cluster.get(i).sampleLength(); j++) {
				System.out.print(this.cluster.get(i).getElement(j));
				if (j < this.cluster.get(i).sampleLength() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("}");
		}
	}
	
	
	/**
	 * 
	 * @return the closest sample point
	 */
	public Sample closestSamplePoint() {
		Sample result = this.cluster.get(0);
		for (Sample i : cluster) {
			if (result.distanceTo(this.clusterPoint) > i.distanceTo(this.clusterPoint)) {
				result = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		double[] p1 = { 1.1d, 2.1d, 3.14, 2.71 };
		double[] p2 = { 1.1, 2.1, 3.14, 1.71 };
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);

		ArrayList<Sample> samples = new ArrayList<Sample>();
		samples.add(s1);
		samples.add(s2);

		Cluster cluster = new Cluster(samples);
		// System.out.println(cluster.randomPick(1)[0].toString());
		// System.out.println(cluster.randomPick(1)[0].toString());
		cluster.print();
		cluster.closestSamplePoint();
	}

}

package pa06;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Blue print for the K-Means class
 * @author Team 14
 *
 */

public class KMeans {
	ArrayList<Cluster>[] cluster;
	Cluster originalData;
	
	public KMeans() {
		
	}
	
	
	public static void main(String[] args) {
		// ask for the file name and the number of clusters
		Scanner in = new Scanner(System.in);
		System.out.print("Filename: ");
		String filename = in.nextLine();
		System.out.print("Num of clusters: ");
		int numClusters = in.nextInt();
	}

}

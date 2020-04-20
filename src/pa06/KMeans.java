package pa06;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Blue print for the K-Means class
 * 
 * @author Team 14
 *
 */

public class KMeans {
	int k;
	ArrayList<Cluster>[] cluster;
	Cluster originalData;

	public KMeans(int k) {
		this.k = k;

	}

	/**
	 * reads a file and adds it to the originalData cluster
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */

	public void readFile(String fileName) throws FileNotFoundException {
		try {
			Scanner fileReader = new Scanner(new File(fileName));
			while (fileReader.hasNextLine()) {
				String currentLine = fileReader.nextLine();
				Scanner lineReader = new Scanner(currentLine);
				double sampleCoords[] = new double[2];
				sampleCoords[1] = lineReader.nextDouble();
				sampleCoords[2] = lineReader.nextDouble();
				Sample point = new Sample(sampleCoords);
				this.originalData.add(point);

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

	public static void main(String[] args) {
		// ask for the file name and the number of clusters
		Scanner in = new Scanner(System.in);
		System.out.print("Filename: ");
		String filename = in.nextLine();
		System.out.print("Num of clusters: ");
		int numClusters = in.nextInt();
		
		// build the cluster
		KMeans kMeans = new KMeans(numClusters);
		
		
	}

}

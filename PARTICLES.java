package assign1;

//import decimal format method
import java.text.DecimalFormat;

public class PARTICLES {

	public static void main(String[] args) {
		
		//make a format for 2 decimal place
		DecimalFormat df = new DecimalFormat("#.00");
		
		//Making arrays for the X coords, Y coords, and letter name
		int[] xCoords = {8, 8, 20, 16, 7, 20, 12, 20, 18, 3, 3, 7, 18, 5, 18, 9, 12, 2, 19, 15};
		int[] yCoords = {17, 14, 9, 6, 14, 3, 5, 11, 15, 7, 10, 8, 3, 9, 16, 18, 8, 1, 18, 12};
		char[] letterName = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
		
		//making doubles to store cumulative, min, max, mean values
		double cumulative = 0;
		double minMass = 0;
		double maxMass = 0;
		double meanMass;
		double meanDist = 0;
		
		//Printing the Header of the chart
		System.out.print("\t\t\t\tDistance\n");
		System.out.print("\t\t  X\t  Y\t  To\t\t\t\t\tParticle\n");
		System.out.print("Particle\tCoord\tCoord\tOrigin\t\tColor\tSpin\tMass\tType\n");
		System.out.print("_________________________________________________________________________________\n");
		
		//using for loop to print particle content
		for (int i = 0; i < letterName.length; i++) {
			
			//calculate distance of point from origin using pythagorean theorem
			double distance = Math.sqrt(xCoords[i] * xCoords[i] + yCoords[i] * yCoords[i]);
			//format value for printing
			String distString = df.format(distance);		
			
			//calculate type of particle
			//create empty string for particle type
			String partType;
			
			//make strings to store color and spin
			String partColor;
			String spin;
			
			//make double to store mass
			double mass;
			
			//check if x coordinate is Odd
			if (xCoords[i] % 2 == 1) {
				//if odd, check if y is even
				if (yCoords[i] % 2 == 0) {
					//x = odd, y = even -> MU
					partType = "Mu";
					//assign values depending on type
					partColor = "BLUE";
					spin = "LEFT";
					//calculate mass
					mass = 1.5f * distance;
					} else { 
						//x = odd, y = odd -> SIGMA
						partType = "Sigma";
						partColor = "RED";
						spin = "RIGHT";
						mass = 1.75f * distance;
						}
				} else { //if x coordinate is Even
					//if y is even
					if (yCoords[i] % 2 == 0) {
						//x = even, y = even -> TAU
						partType = "Tau";
						partColor = "GREEN";
						spin = "UP";
						mass = 2.5f * distance;
						} else {
							//x = even, y = odd -> OMEGA
							partType = "Omega";
							partColor = "BLACK";
							spin = "DOWN";
							mass = 2.75f * distance;
						}
					}
			
			//format mass value into 2 decimal for printing
			String massString = df.format(mass);
			
			
			//printing each line of the chart left to right (name, x, y, dist, color, spin, mass, type)
			System.out.print("PA_" + letterName[i] +"\t\t" + xCoords[i] + "\t" + yCoords[i] + "\t" + distString 
					+ "\t\t" + partColor + "\t" + spin + "\t" + massString + "\t" + partType);
			//printing line break after each line
			System.out.println();
			
			
			//Adding mass to cumulative
			cumulative += mass;
			//adding distance to meanDist
			meanDist += distance;
			
			//Assigning min and max
			//if its the first value, assign mass to both
			if (minMass == 0 && maxMass == 0) {
				minMass = mass;
				maxMass = mass;
			} else {
				//if not the first value, compare current i value with min and max
				if (mass < minMass) {
					minMass = mass;
				}
				
				if (mass > maxMass) {
					maxMass = mass;
				}
			}
		} //END OF FOR LOOP
		
		//calculate mean mass by dividing cumulative by length of array
		meanMass = cumulative / letterName.length;
		//calculate mean distance by dividing by length of array
		meanDist /= letterName.length;
		
		//converting doubles to 2df for printing
		String cumulativeString = df.format(cumulative);
		String minString = df.format(minMass);
		String maxString = df.format(maxMass);
		String meanMassString = df.format(meanMass);
		String meanDistString = df.format(meanDist);
		
		//printing out the results
		System.out.print("\nCumulative Particle Mass:\t" + cumulativeString + "\tImperials\n");
		System.out.print("Minimum Particle Mass:\t\t" + minString + "\tImperials\n");
		System.out.print("Maximum Particle Mass:\t\t" + maxString + "\tImperials\n");
		System.out.print("Mean Particle Mass:\t\t" + meanMassString + "\tImperials\n");
		System.out.print("Mean Particle Distance:\t\t" + meanDistString + "\tcm\n");
		System.out.print("____________________________________________________Chart Prepared by Zoe Chow");
	}

}

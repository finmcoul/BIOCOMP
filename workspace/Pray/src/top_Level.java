import java.io.IOException;
import java.util.Random;

//for each line in the input file
//run the neuron maker 50 times
//	collect the output and find the mean squared error MSE
public class top_Level {
	 

	public static void main(String[] args) throws IOException {
		float best = 0;
		inputer INP = new inputer();
		// get input from the user
		INP.getUserInput();
		
		int activation_function = INP.actFun;

		// holds the MSE
		float[] localMSEValues = new float[INP.fileLength + 1];
		float localMSE = 0;

		float[] globalMSE = new float[INP.popSize];
		int globalMSEIterator = 0;

		// holds the population
		Neuron_Maker[] BRAIN = new Neuron_Maker[INP.popSize];

		// initialise population
		for (int x = 0; x < BRAIN.length; x++) {
			BRAIN[x] = new Neuron_Maker(INP.mutateMax, INP.mutateMin,activation_function);
			BRAIN[x].initialise_network();
		}
		System.out.println("hi");

		// for each iteration
		for (int a = 0; a < INP.numOfIterations; a++) {
			System.out.println("iteration:" + a);

			// for each network, set the first node
			for (int y = 0; y < BRAIN.length; y++) {
				// for each line in the text file
				for (int x = 0; x < INP.fileLength; x++) {
					BRAIN[y].first.weight = INP.IOS[x][0];

					// for each network - run network

					BRAIN[y].run_network();

					localMSEValues[x] = BRAIN[y].last.runningTotal;
System.out.println("evolve");
					// evolve here
					// BRAIN[best] dont touch
					// mess the rest
					// evolve or mutate the neurons
					for (int j = 0; j < BRAIN.length; j++) {

						if (j != best) {
							// do the damn crossover
							Neuron spacer = null;
							if (INP.crossRate > 0) {
								for (int k = 0; k < INP.crossRate; k++) {
									// move neuron crossRate times
									spacer = BRAIN[j].c1;
									BRAIN[j].c1 = BRAIN[j].c2;
									BRAIN[j].c2 = BRAIN[j].c3;
									BRAIN[j].c3 = BRAIN[j].c4;
									BRAIN[j].c4 = BRAIN[j].c5;
									BRAIN[j].c5 = spacer;
								}
							}

							// do the mutation
							if (INP.mutationRate > 0) {
								Random r = new Random();
								float randomValue = (float) (-0.2 + (0.5 + (-0.2))
										* r.nextFloat());
								for (int k = 0; k < INP.mutationRate; k++) {
	/*							*/
									BRAIN[j].c1.weight = (float) (BRAIN[j].c1.weight * randomValue);
									BRAIN[j].c2.weight = (float) (BRAIN[j].c2.weight * randomValue);
									BRAIN[j].c3.weight = (float) (BRAIN[j].c3.weight * randomValue);
									BRAIN[j].c4.weight = (float) (BRAIN[j].c4.weight * randomValue);
									BRAIN[j].c5.weight = (float) (BRAIN[j].c5.weight * randomValue);

									/*System.out.println("weights after c1:"
											+ BRAIN[j].c1.weight);
									System.out.println("weights after c2:"
											+ BRAIN[j].c2.weight);
									System.out.println("weights after c3:"
											+ BRAIN[j].c3.weight);
									System.out.println("weights after c4:"
											+ BRAIN[j].c4.weight);
									System.out.println("weights after c5:"
											+ BRAIN[j].c5.weight);
*/
								}

							}
						}
					}

					// -----------------------------------------------------------------------------
					// run INP.popSize times for each item in the text file

					// System.out.println("mys:"+MSE[y]);

				}

				// calc mse for each newtork
				float g = (float) (1.00 / (localMSEValues.length - 1));

				// calculate mse for each network
				// System.out.println(localMSEValues.length);

				// go through
				for (int b = 0; b < localMSEValues.length - 1; b++) {

					float totalMSE = INP.IOS[b][1] - localMSEValues[b];

					// System.out.println(b + " " + globalMSE.length + " "+
					// totalMSE);
					localMSE = g * (totalMSE * totalMSE);
				}

				
				if (globalMSEIterator < globalMSE.length) 
				{
					globalMSE[globalMSEIterator] = localMSE;
					globalMSEIterator++;
				}
				else
				{
					globalMSEIterator=0;
					System.out.println("current val of globalMSEIterator"+globalMSEIterator);
					globalMSE[globalMSEIterator] = localMSE;
					globalMSEIterator++;
				}

				// evolve network

				// evolve network/mutate network
				// -----------------------------------------------------------------------------

				// find best one

				System.out.println("evolution starting now");
				

				float minValue = globalMSE[0];
				float a1 = globalMSE[0];
				for (int i = 0; i < globalMSE.length; i++) {
					System.out.println("globalMSE[i] " + globalMSE[i]
							+ " minValue " + minValue);
					if (globalMSE[i] < minValue) {
						minValue = globalMSE[i];
						a1 = i;

					}
				}
				best = a1;

				System.out.println("best" + best + " " + minValue);
				// ----------------------------------------------------------------------

			}
		}

	}

}

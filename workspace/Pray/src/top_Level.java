import java.io.IOException;
import java.util.ArrayList;
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
		for (int x = 0; x < BRAIN.length; x++) 
		{
			
			BRAIN[x] = new Neuron_Maker(INP.mutateMax, INP.mutateMin,activation_function);
			BRAIN[x].initialise_network();
		}

		
		
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
					
					// evolve here
					// BRAIN[best] dont touch
					// mess the rest
					// evolve or mutate the neurons
					for (int j = 0; j < BRAIN.length-1; j++) {

						if (j != best) {
							// do the damn crossover
							if (INP.crossRate > 0) {
							Neuron spacer = null;
							
							if(INP.popSize>1)
							
								
								for (int k = 0; k < INP.crossRate; k++) {
									
									// move neuron crossRate times
									
									Neuron spacer1 = BRAIN[j].c1;
									Neuron spacer2 = BRAIN[j].c2;
									Neuron spacer3 = BRAIN[j].c3;
								
									
									BRAIN[j].c1 = BRAIN[j+1].c1;
									BRAIN[j].c2 = BRAIN[j+1].c2;
									BRAIN[j].c3 = BRAIN[j+1].c3;
									
									BRAIN[j+1].c1 = spacer1;
									BRAIN[j+1].c2 = spacer2;
									BRAIN[j+1].c3 = spacer3;
									
								}
							}
						}

							// do the mutation
							if (INP.mutationRate > 0) {
								Random r = new Random();
								float randomValue = (float) (-0.2 + (0.5 + (-0.2))
										* r.nextFloat());
								for (int k = 0; k < INP.mutationRate; k++) {
									
									for(ArrayList<Neuron> nlist:BRAIN[j].allHLayers)
//										each neuron in each layer
										for(Neuron n:nlist)
										{
											 n.weight = n.weight * randomValue;
										}


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

				System.out.println("Smallest MSE"+ best);
				// ----------------------------------------------------------------------

			System.out.println("print structure");
			System.out.println("first node");
			for(ArrayList<Neuron> ar:BRAIN[(int) best].allHLayers)
			{
				System.out.println("Nodes in this layer" + ar.size());
			}
			System.out.println("Last node");
			
			
			//EVOlVE STRUCTURE HERE
/*			step 1 find best in brain to leave alone
 
			step 2 mutate the other networks
			populate
			
			step 3 ???
			step 4 profit
			
			
			case 1 
			add node to layer
			
			case 2
			add a new layer with 1 node
				only doable if greater than 1 node in layer
				
			case 3 
			delete a node
				only doable if greater than 1 node in layer
			
			*/
			
			//step 1
			for(int aa = 0; aa<BRAIN.length;aa++ )
			{
				if(aa != (int)best)
				
				{
					Random randomGenerator = new Random();
					int randomInt = randomGenerator.nextInt(3);

					//					insert case statement
					if(randomInt == 0)
					{
//						add a node
						//create neuron 
						Neuron cN = new Neuron((randomGenerator.nextFloat() * INP.mutateMax) + INP.mutateMin ,INP.actFun);
						
					
						//connect neuron with all noeds in previous layer
						
						ArrayList<Neuron> holderLevelMOne = null ;
						
						if(BRAIN[aa].allHLayers.size() != 1){
							//the layer before the curretn layer
							 holderLevelMOne = BRAIN[aa].allHLayers.get(BRAIN[aa].allHLayers.size()-1);
						}
							
						
						//connect for if 1-5-1
						if(BRAIN[aa].allHLayers.size() == 1)
						{
							cN.connect(BRAIN[aa].first);
							BRAIN[aa].last.connect(cN);
						}
//						connect for multilayer
						else
						{
//							connect new node with each node from previous layer
							for(Neuron object:holderLevelMOne)
							{
								cN.connect(object);
							}
							BRAIN[aa].last.connect(cN);
						}
							@SuppressWarnings("unused")
							int size = BRAIN[aa].allHLayers.size();
						//add to last layer
										
								(BRAIN[aa].allHLayers.get(BRAIN[aa].allHLayers.size()-1)).add(cN);
						System.out.println("added new node");
						
					}
					else if(randomInt ==1)
					{
//						add a level with a new node
						Neuron cN = new Neuron((randomGenerator.nextFloat() * INP.mutateMax) + INP.mutateMin ,INP.actFun);
						
						//create new layer for neuron
						ArrayList<Neuron> newLevel = new ArrayList<Neuron>();
						
//						get last layer of network
						ArrayList<Neuron> temp = (BRAIN[aa].allHLayers.get(BRAIN[aa].allHLayers.size()-1));
						
//						connect last row to new neuron
						for(Neuron n:temp)
						{
							cN.connect(n);
						}
						
						BRAIN[aa].last.inputs.clear();
						BRAIN[aa].last.connect(cN);
						
						System.out.println("added new layer");
						
					}
					
//					
				}
			}
			
			}	
			
			
			
			
			
		}

	}



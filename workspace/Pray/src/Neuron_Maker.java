import java.util.ArrayList;
import java.util.Random;

public class Neuron_Maker {
	int max, min, activationFunction;
	Neuron first, c1, c2, c3, c4, c5, last;
	ArrayList<Neuron> hLayer1 = new ArrayList<Neuron>();
	ArrayList<ArrayList<Neuron>> allHLayers = new ArrayList<ArrayList<Neuron>>();
	public int hLayerDepth = 1;



	public Neuron_Maker(int Max, int Min, int af) {
		max = Max;
		min = Min;
		activationFunction = af;
	}

	void initialise_network() {

		// create random weight for neurons as taken in by user
		Random rand = new Random();
		// create random weight

		first = new Neuron((float) 0.1, activationFunction);
		hLayer1.add(c1 = new Neuron((rand.nextFloat() * max) + min,
				activationFunction));
		hLayer1.add(c2 = new Neuron((rand.nextFloat() * max) + min,
				activationFunction));
		hLayer1.add(c3 = new Neuron((rand.nextFloat() * max) + min,
				activationFunction));
		hLayer1.add(c4 = new Neuron((rand.nextFloat() * max) + min,
				activationFunction));
		hLayer1.add(c5 = new Neuron((rand.nextFloat() * max) + min,
				activationFunction));

		last = new Neuron((rand.nextFloat() * max) + min, activationFunction);
		
		allHLayers.add(hLayer1);
		

		/*
		 * left.setWeight(-1.0f); right.setWeight(1.0f); xor.connect(left,
		 * right);
		 */
		// connect all nurons up
		// f- > c1 ect

		for (Neuron object : hLayer1) {
			last.connect(object);
			object.connect(first);
		}

	}

	public void run_network() {
		first.fire();
		
		// System.out.println("first.weight :"+first.weight);
		for (ArrayList<Neuron> net : allHLayers) {
			for (Neuron n : net) {
				n.fire();
			}
		}
		last.fire();
		// System.out.println("last weight(running total) :"+last.runningTotal);

	}

}

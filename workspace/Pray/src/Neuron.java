import java.util.ArrayList;
import java.util.Random;

public class Neuron {
	ArrayList<Neuron> inputs = new ArrayList();
	public float weight = 0;
	public float runningTotal = 0;
	public int aFunction;
	public boolean fired = true;

	public Neuron(float t,int funct) {
		fired = true;
		inputs = new ArrayList();
		weight = t;
		aFunction = funct;

	}

	public void connect(Neuron... ns) {
		for (Neuron n : ns)
			inputs.add(n);

	}

	public float getWeight() {
		return weight;
	}
	
	public float getRunningTotal()
	{
		return runningTotal;
	}

	public void fire() {
		// insert activations function here

		//
		// get weight from inputs
		// total all weights from intputs + own weight
		// test if fires here if evolving activation function but not just now

		// run given equation on weight and stop

		 runningTotal = 0.0f;

		if (inputs.size() > 0) {

			// for each neuron input
			// get total
			for (int i = 0; i < inputs.size(); i++) {
				if (inputs.get(i).isFired() == true)
					runningTotal = +inputs.get(i).getRunningTotal();
			}

		}

		// total weight and running total
		runningTotal = weight + runningTotal;

		// run equation on running total
		//runningTotal is the variable that gets grabed by the next neuron in the line

		// test for activation function and set fired as per
		if (aFunction == 0)
			af_null();
		else if(aFunction == 1)
			af_sigmoid();
		else if(aFunction == 2)
			af_tan();
		else if(aFunction == 3)
			af_cos();
		else if(aFunction == 4)
			af_gaus();
		
			
			

		// calculate if the neuron firesfire

		// select function
	}

	void af_null() {
		fired = false;
	}

	void af_sigmoid() {
		if (1 / (1 + (Math.exp((double) runningTotal))) < 0)
			fired = false;
	}

	void af_tan() {
		if (Math.tanh(runningTotal) < 0)
			fired = false;
	}

	void af_cos() {
		if (Math.cos(runningTotal) < 0)
			fired = false;
	}

	void af_gaus() 
	{
		if (Math.exp(-((runningTotal * runningTotal) / 2)) < 0)
			fired = false;
	}
/*
	// linear
	float linear(float weight) {
		return weight;
	}

	// cubic
	float cubic(float weight) {
		return weight * weight * weight;
	}

	// sine
	float sine(float weight) {
		return (float) Math.sin(weight);
	}

	// tanh
	float tanh(float weight) {
		return (float) Math.tanh(weight);
	}

	float xor(int weight1, int weight2) {
		int n = 1, a = 1, c;
		c = a ^ n;
		return weight1 ^ weight2;
	}
*/
	public boolean isFired() {
		return fired;
	}
}
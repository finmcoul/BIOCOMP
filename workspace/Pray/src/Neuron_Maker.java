import java.util.Random;

public class Neuron_Maker {
int max,min,activationFunction;
Neuron first,c1,c2,c3,c4,c5,last;


public Neuron_Maker()
   {
   
    max = 1;
    min = 0;
    
    }

public Neuron_Maker(int Max,int Min,int af)
{
	max = Max;
	min = Min;
	activationFunction = af;
}
    
     void initialise_network() 
     {
		
    	//create random weight for neurons as taken in by user
    	Random rand = new Random();
        //create random weight
    	
    	first = new Neuron((float)0.1,activationFunction);
        c1 = new Neuron((rand.nextFloat() * max) + min,activationFunction);
        c2 = new Neuron((rand.nextFloat() * max) + min,activationFunction);
        c3 = new Neuron((rand.nextFloat() * max) + min,activationFunction);
        c4 = new Neuron((rand.nextFloat() * max) + min,activationFunction);
        c5 = new Neuron((rand.nextFloat() * max) + min,activationFunction);
        last = new Neuron((rand.nextFloat() * max) + min,activationFunction);
        
        /*left.setWeight(-1.0f);
        right.setWeight(1.0f);
        xor.connect(left, right);
*/
        //connect all nurons up
        //f- > c1 ect
        
       
                    
            c1.connect(first);
            c2.connect(first);
            c3.connect(first);
            c4.connect(first);
            c5.connect(first);
            
            last.connect(c1);
            last.connect(c2);
            last.connect(c3);
            last.connect(c4);
            last.connect(c5);
     }
            
   public void run_network()
    {
            first.fire();
//            System.out.println("first.weight :"+first.weight);
            c1.fire();
//            System.out.println("c1 :"+c1.runningTotal);
            c2.fire();
//            System.out.println("c2 :"+c2.runningTotal);
            c3.fire();
//            System.out.println("c3 :"+c3.runningTotal);
            c4.fire();
//            System.out.println("c4 :"+c4.runningTotal);
            c5.fire();
//            System.out.println("c5 :"+c5.runningTotal);
            last.fire();
//            System.out.println("last weight(running total) :"+last.runningTotal);
            
    }
   
}

 


    


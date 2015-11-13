
	//in this class you take in the input



	import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.annotation.processing.FilerException;

	public class inputer {
		
		public int function,actFun,evoDev,crossRate,popSize,fileLength,mutationRate,numOfIterations,mutateMin,mutateMax;
		String fileName = "temp.txt";
		float[][] IOS;
		
		public inputer()
		{
	        //threshhold = t;
	        function = 0;
	        actFun = 0;
	        evoDev = 0;
	        popSize = 0;
	        String IOS[][] = null;

	    }

	
			//THIS GETS THE DATA FROM THE FILE REQUIRED AND PUTS IN THE ARRAY IOS

		

		public void getUserInput() throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//error handling for getting user input
			int s = 10;
			do {
				System.out.print("Select function:\n 0 - Linear \n 1 - Cubic \n 2 - Sine \n 3 - Tanh\n" );//\n 4 - Xor\n" \n 5 - Complex \n");
			    try {
			     s = Integer.parseInt(br.readLine()); // reading in an integer
			    	if(s > 3 || s < 0)
			    		System.out.println("number not in range");
			    } catch(NumberFormatException e) {
			        System.out.println("Sorry that input is not valid");
			        // set the range outside the range so we go through the loop again.
			        
			    }
			} while((s > 3 || s < 0) );
			
			 // insert input to function
			function = s;

						 
			 
			 s = 10;
			 
			 do {
				 System.out.print("Select development: \n 0 - Weights\n 1 - Activations Function \n 2 - Both\n");
				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 3 || s < 0)
				    		System.out.println("number not in range");
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while((s > 3 || s < 0) );
				
				 // insetr input to what wanted to be evolved
			 evoDev = s;
			 
			 
			 	
 s = 10;
			 
			 do {
				 System.out.print("Select Activation function: \n 0 - Null \n 1 - Sigmoid \n 2 - Hyperbolic Tangent \n 3 - Cosine\n 4 - Gaussian\n");
				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 4 || s < 0)
				    		System.out.println("number not in range");
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while((s > 4 || s < 0) );
				
			 actFun = s;
			
			 
			
 s = 10;
			 
			 do {
				 System.out.print("Select crossover rate: 0-4\n");
				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 4 || s < 0)
				    		System.out.println("number not in range");
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while((s > 4 || s < 0) );
			 crossRate = s;
			 
 s = 100;
			 
			 do {
				 System.out.print("Select population size: 1-10\n");

				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 10 || s < 1)
				    		System.out.println("number not in range");
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while((s > 10 || s < 1) );
			 popSize = s;
			 
			 
 s = 10;
			 
			 do {
				 System.out.print("Select mutation rate: 0-5\n");

				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 5 || s < 0)
				    		System.out.println("number not in range");
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while(s > 5 || s < 0) ;
			 mutationRate = s;
			 
 s = 100;
			 
			 do {
				 System.out.print("Select number of iterations: 1-10\n");

				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 10 || s < 1)
				    		System.out.println("number not in range");
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while(s > 10 || s < 1) ;
			 numOfIterations =s;
			 
			 
 s = 10;
			 
			 do {
				 System.out.print("Select number for min weight: -5 - 4\n");

				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 4 || s < -5)
				    		System.out.println("number not in range");
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while(s > 4 || s < -5) ;
			 
			 mutateMin = s;
			 
 s = 10;
			 
			 do {
				 System.out.print("Select number for max weight: -5 - 4\n");

				    try {
				     s = Integer.parseInt(br.readLine()); // reading in an integer
				    	if(s > 5 || s < -4)
				    		System.out.println("number not in range");
				    	else if(s<mutateMin){
				    			s = 10;
				    			System.out.println("please select a number greater than "+mutateMin );}
				    } catch(NumberFormatException e) {
				        System.out.println("Sorry that input is not valid");
				        // set the range outside the range so we go through the loop again.
				        
				    }
				} while(s < mutateMin || s < -5|| s >9) ;
			 
			 mutateMax = s;
			 
			fileread();

		}

		void fileread()	throws IOException {
			// The name of the file to open.
			if (function == 0)// for linear
			{
				fileName = "1in_linear.txt";
			} else if (function == 1)// cubic
			{
				fileName = "1in_cubic.txt";
			} else if (function == 2)// 2 - sine
			{
				fileName = "1in_sine.txt";
			} else if (function == 3)// 3 -tahn
			{
				fileName = "1in_tahn.txt";
			} else if (function > 3)// 4 - xor
			{
				fileName = "";
//				fileName = "2in_xor.txt";
			} else if (function == 5)// 5 - complex
			{
				fileName = "2in_complex.txt";
			}

			// This will reference one line at a time
			String line = null;

			fileLength = countFileLength(fileName);
			

			if (fileName.equals("1in_linear.txt") || fileName.equals("1in_cubic.txt")||fileName.equals("1in_sine.txt")) 
			{
				IOS = new float[fileLength][2];
			} 
			else 
			{
				IOS = new float[fileLength][3];
			}

			// GET SHIZZLE FROM FILE

			try {
				// FileReader reads text files in the default encoding.
				FileReader fileReader = new FileReader(fileName);

				// Always wrap FileReader in BufferedReader.
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				StringTokenizer st = null;
				int y = 0;
				while ((line = bufferedReader.readLine()) != null) {
					
				
					st = new StringTokenizer(line);
					
					while (st.hasMoreTokens()) {
						// for 2 inputs

						for (int x = 0; x < IOS[0].length; x++) {
							//System.out.println("ios length:" + IOS[0].length + " x = "+x);
							IOS[y][x] = Float.parseFloat(st.nextToken());

						}
						
						if (y<IOS.length-1)
							y++;

					}

				}

				// Always close files.
				bufferedReader.close();
			} catch (FilerException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
				// Or we could just do this:
				ex.printStackTrace();
			}
		}

		public static int countFileLength(String filename) throws IOException {
			BufferedInputStream is = new BufferedInputStream(new FileInputStream(
					filename));
			try {
				byte[] c = new byte[1024];
				int count = 0;
				int readChars = 0;
				boolean empty = true;
				while ((readChars = is.read(c)) != -1) {
					empty = false;
					for (int i = 0; i < readChars; ++i) {
						if (c[i] == '\n') {
							++count;
						}
					}
				}
				return (count == 0 && !empty) ? 1 : count;
			} finally {
				System.out.println(filename + " read in sucessfully");
				is.close();
			}
		}
	}
	
	


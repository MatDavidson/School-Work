package practicalAI2;

public class NeuralNet{
    public static void main(String a[]){
        int training[] =new int[] {1,1};
        Net net = new Net(training);
      
        for(int n = 0; n < 10; n++) {
        	System.out.println("Epoch " + n);
        	for(int i = 0; i < 2; i++) {
        		for(int j = 0; j < 2; j++) {
        			net.testing(new int[]{i,j});
        		}
        	}
        	System.out.println("Training...");
            net.training();
        }
        
        net.updateInput(new int[] {0,0});
        for(int n = 0; n < 30; n++) {
        	System.out.println("Epoch " + n);
        	for(int i = 0; i < 2; i++) {
        		for(int j = 0; j < 2; j++) {
        			net.testing(new int[]{i,j});
        		}
        	}
        	System.out.println("Training...");
            net.training();
        }
    }
}
class Net {

    double alpha = 0.1;
    int training[];   

    double weights[][] = {{0.05,0.05}, 
    					  {0.99, 0.99}};
    Neuron output[] = new Neuron[2];
    double vals[];

    

    public Net(int trainingdata[]){
        training=trainingdata;
        double b = 0.115;
        output[0] = new Neuron(b);
        output[1] = new Neuron(b);
    }

    void training(){
    		for(int i  =0 ; i < 2; i++){
    			int inputs[]= training;
    			vals = getNeuralNetOutput(inputs);   
    			//Update all the neurons
    			for(int j = 0 ; j < 2; j++){
    				weights[i][j] += output[j].bias * vals[j] * ((alpha/output[j].bias) * inputs[i] - weights[i][j]);
    			}	
    	}
    }
    
    double sigmoid(double x){
        return 1 / (1 + Math.exp(-x));
    }

    public double[] getNeuralNetOutput(int inputs[]){            
        double vals[] = {0,0};
        for(int i = 0; i < 2; i++) {
        	for(int j = 0; j < 2; j++){
        		vals[j] += inputs[i] * weights[i][j] - output[j].bias;
        	}
        	vals[i] = sigmoid(vals[i]);
        }
        return vals;
    }

    public void testing (int[] inputs){
       double[] out = getNeuralNetOutput(inputs);
       
       System.out.println("Input: " + inputs[0] + ", " + inputs[1] + "\tOutput: " + out[0] + ", " + out[1]);
    }
    void updateInput(int[] in) {
    	training[0] = in[0];
    	training[1] = in[1];
    }
    
    class Neuron{
    	double bias; 
    	public Neuron(double bias) {
    		this.bias = bias;
    	}
    }
}

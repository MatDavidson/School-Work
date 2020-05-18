package practicalAI;

public class NeuralNet{
    public static void main(String a[]){
        Net net = new Net();
        double[] test = new double[4];
        
        double[][] X = {{0.0, 0.0, 0.0, 0.0, 0.0, 1.0},
        				{0.0, 0.0, 0.0, 1.0, 0.0, 1.0},
        				{0.0, 1.0, 1.0, 0.0, 1.0, 0.0},
        				{1.0, 0.0, 1.0, 1.0, 1.0, 0.0},
        				{0.0, 1.0, 0.0, 0.0, 1.0, 0.0},
        				{1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
        				{1.0, 1.0, 0.0, 0.0, 1.0, 0.0},
        				{1.0, 0.0, 1.0, 1.0, 0.0, 1.0},
        				{0.0, 1.0, 1.0, 0.0, 0.0, 0.0},
        				{1.0, 1.0, 1.0, 1.0, 1.0, 0.0}};
        
        double[][] y = {{1.0, 0.0, 0.0, 0.0},
						{0.0, 0.0, 1.0, 0.0},
						{0.0, 0.0, 0.0, 1.0},
						{0.0, 0.0, 0.0, 1.0},
						{0.0, 1.0, 0.0, 0.0},
						{0.0, 1.0, 0.0, 0.0},
						{0.0, 1.0, 0.0, 0.0},
						{1.0, 0.0, 0.0, 0.0},
						{0.0, 0.0, 1.0, 0.0},
						{0.0, 0.0, 0.0, 1.0}};;
        
		int choice;
        for(int j = 0; j < 100; j++) {
        	choice = (int)(Math.random() * 10);
        	System.out.print("X = " + choice + ": ");
        	net.updateInput(X[choice]);
        	System.out.print("\ty = ");
        	for(int u = 0; u < y[choice].length; u++) {
        		System.out.print(y[choice][u] + " ");
        	}
        	test = net.train();
        	System.out.println();
        	for(int i = 0; i < test.length; i++) {
        		System.out.println(test[i]);
        	}
        	System.out.println();
        }
        
        
    }
}
class Net {

    double n=0.1;
    double input[][] =new double[6][1]; 
    double[] target = new double[4];
    Neuron inLayer[]=new Neuron[6];
    double[] vals1 = new double[6];
    Neuron layer1[]=new Neuron[8];
    double[] vals2 = new double[8];
    Neuron outLayer[]=new Neuron[4];
    double[] out = new double[4];

    public Net(){
        for(int i = 0; i < 6; i++) {
        	inLayer[i] = new Neuron(1);
        	input[i][0] = 0;
        	inLayer[i].l1 = true;
        }
        for(int i = 0; i < 8; i++) {
        	layer1[i] = new Neuron(6);
        }
        
        for(int i = 0; i < 4; i++) {
        	outLayer[i] = new Neuron(8);
        }
    }
    
    void updateInput(double[] in){
    	for(int i = 0; i < in.length; i++) {
    		input[i][0] = in[i];
    		System.out.print(input[i][0] + " ");
    	}
    }

    public double[] train(){
        //get all the outputs and add them together     
        for(int i = 0 ; i < inLayer.length ; i++){
            vals1[i] = inLayer[i].getOutput(input[i]);
        }
        for(int i = 0 ; i < layer1.length ; i++){
            vals2[i] = layer1[i].getOutput(vals1);
        }
        for(int i = 0 ; i < layer1.length ; i++){
            layer1[i].updateWeight(inLayer);
        }
        for(int i = 0 ; i < outLayer.length ; i++){
            out[i] = outLayer[i].getOutput(vals2);
        }
        for(int i = 0 ; i < outLayer.length ; i++){
            outLayer[i].updateWeight(layer1);
        }
        
        return out;
    }


    class Neuron{
    	boolean l1;
        double[] weights;
        double value;

        public Neuron(int n){
        	//weights of the connections from the previous layer
        	weights = new double[n];
        	
        	for(int i = 0; i < n; i++) {
        		weights[i] = Math.random();
        	}
        }

        public double getOutput(double[] in){
        	double sum = 0;
        	
            for(int i = 0; i < in.length; i++) {
            	sum += weights[i]*in[i];
            }
            
            sum -= 1.5;

            	value = sigmoid(sum);
           
            	
            
            return value;
        }

        public void updateWeight(Neuron[] update){
            for(int i = 0; i < update.length; i++) {
            	weights[i] += 1.5*value*((0.1/1.5)*update[i].value - weights[i]);
            }
        }
        
        double sigmoid(double x){
            return 1 / (1 + Math.exp(-x));
        }
    }
}


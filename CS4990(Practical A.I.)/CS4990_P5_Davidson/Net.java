import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Net here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Net extends Actor
{
    double alpha = 0.1;
    int training[];   
    
    double weights[][] = {{0.2,0.2}, 
                          {0.9, 0.9}};
    Neuron output[] = new Neuron[2];
    ShyGuy shy;
    double vals[];

    

    public Net(int trainingdata[], ShyGuy shy){
        training=trainingdata;
        double b = 0.1;
        output[0] = new Neuron(b);
        output[1] = new Neuron(b);
        this.shy = shy;
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
       
       System.out.println("\nInput: " + inputs[0] + ", " + inputs[1] + "\tOutput: " + out[0] + ", " + out[1]);
       System.out.println("Weights: 00:" + weights[0][0] + ", 01: " + weights[0][1] + ", 10:" + weights[1][0] + ", 11: " + weights[1][1]);
       shy.confidence = (out[0] + out[1])/2;
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
    public void act(){
        
    }
}  


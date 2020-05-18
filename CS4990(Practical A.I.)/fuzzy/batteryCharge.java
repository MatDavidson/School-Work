
import java.io.*;

/*
 *  Battery charge simulation
 *
 *  batteryCharge.java
 *
 *
 */

public class batteryCharge{
    final int TRICKLE_CHARGE = 0;
    final int FAST_CHARGE = 1;

    double voltage;
    double temperature;
    int chargeMode;

    // Fill in: your variables ...
    static String type;

    // Simulator related variables
    double timer;
    final int MAX_LOADS = 5;
    final double load[] = {0.02, 0.04, 0.06, 0.08, 0.1};
    int curLoad;

    public batteryCharge (){
        voltage = 20.0;
        temperature = 12.0;
        chargeMode = TRICKLE_CHARGE;
        timer = 0.0;
        curLoad = 0;
       
    }

    private double charge( int t )
    {
      double result;

      result = Math.sin( (double)t/100.0 );

      if (result < 0.0) result = 0.0;

      return result;
    }


    private void simulate( int t )
    {
      timer = (timer + 1.0) % 10;

      /* First, update the loading if necessary */
      curLoad = (int)(Math.random()*MAX_LOADS);

      //System.out.println(curLoad);

      /* Affect the current battery voltage given the load */
      voltage -= load[curLoad];

      /* Next, update the battery voltage given input charge */
      if (chargeMode == FAST_CHARGE) {
        voltage += (charge(t) * Math.sqrt(timer));
      } else {
        voltage += ((charge(t) * Math.sqrt(timer)) / 10.0 );
      }

      if      (voltage < 0.0)  voltage = 0.0;
      else if (voltage > 35.0) voltage = 35.0;

      /* Update the temperature */
      if (chargeMode == FAST_CHARGE) {
        if        (voltage > 25) {
          temperature += ((load[curLoad] * (Math.sqrt(timer)/25.0)) * 10.0);
        } else if (voltage > 15) {
          temperature += ((load[curLoad] * (Math.sqrt(timer)/20.0)) * 10.0);
        } else {
          temperature += ((load[curLoad] * (Math.sqrt(timer)/15.0)) * 10.0);
        }
      } else {
        if        (temperature > 20.0) {
          temperature -= ((load[curLoad] * (Math.sqrt(timer)/20.0)) * 10.0);
        } else {
          temperature -= ((load[curLoad] * (Math.sqrt(timer)/100.0)) * 10.0);
        }
      }

      if      (temperature < 0.0) temperature = 0.0;
      else if (temperature > 60.0) temperature = 60.0;

    }

    public static void main(String[] args) throws IOException
    {
        batteryCharge bc = new batteryCharge();
        fuzzy fz = new fuzzy();
        
        //FileWriter fileWriter = new FileWriter("C:\\Users\\Mathieu Davidson\\Desktop\\Example_thread\\practicalAI\\src\\fuzzy\\charger.txt");
        FileWriter fileWriter = new FileWriter("charger.txt");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3000;) {


            bc.simulate(i);

            if ( i++ %10 == 0 ){

                bc.chargeMode = fz.chargeControl(bc.voltage, bc.temperature);
                type = "Fast";
                if(bc.chargeMode == 0)
                	type = "Trickle";
                sb.append(bc.voltage + "," + bc.temperature + "\n");
                System.out.println("Fuzzy Set " + (i/10) + ":\n\t" + fz.toString() + type + " charging...\n");
            }
            
        }
        fileWriter.write(sb.toString());
        fileWriter.close();
    }

}

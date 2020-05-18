
public class fuzzy {
	double voltage, temp, low, medium, high, cold, warm, hot;
	
	public fuzzy() {
		
	}
	int chargeControl(double voltage, double temp) {
		this.voltage = voltage;
		this.temp = temp;
		
		fuzzify();
		int charge = ruleEval();
		return charge;
	}
	
	//get the membership of both inputs
	void fuzzify() {
		voltageMem();
		tempMem();
	}
	
	void voltageMem() {
		double mem = 0.0;
		if(voltage < 5) {
			low = 1.0;
			medium = 0.0;
			high = 0.0;
		}		
		else if(voltage >= 5 && voltage < 10) {
			mem = membership(5, 10, voltage);
			low = 1 - mem;
			medium = mem;
			high = 0;
		}
		else if(voltage >= 10 && voltage < 20) {
			low = 0;
			medium = 1.0;
			high = 0;
		}
		else if(voltage >= 20 && voltage < 25) {
			mem = membership(20, 25, voltage);
			low = 0;
			medium = 1-mem;
			high = mem;
		}
		else {
			low = 0;
			medium = 0;
			high = 1.0;
		}
	}
	
	void tempMem() {
		double mem = 0.0;
		if(temp <= 15) {
			cold = 1.0;
			warm = 0.0;
			hot = 0.0;
		}		
		else if(temp > 15 && temp < 25) {
			mem = membership(15, 25, temp);
			cold= 1 - mem;
			warm = mem;
			hot = 0;
		}
		else if(temp >= 25 && temp <= 35) {
			cold = 0;
			warm = 1.0;
			hot = 0;
		}
		else if(temp > 35 && temp < 45) {
			mem = membership(35, 45, temp);
			cold = 0;
			warm = 1-mem;
			hot = mem;
		}
		else {
			cold = 0;
			warm = 0;
			hot = 1.0;
		}
	}
	
	//determine if the charger is in fast or trickle mode
	int ruleEval() {
		int i = 1;
		
		if((high > medium && high > low) || (hot > warm && hot > cold))
			i = 0;
		
		return i;
	}
	
	double membership(double low, double high, double actual) {
		double mem = (actual - low)/(high - low);
		return mem;
	}
	
	public String toString() {
		String s = String.format("\n    *Voltage\t|Low:  %.2f\t|Med:  %.2f\t|High: %.2f\t|\n\t\t"
				+ "|---------------|---------------|---------------|\n   *Temperature "
				+ "|Cold: %.2f\t|Warm: %.2f\t|Hot:  %.2f\t| - ", low, medium, high, cold, warm, hot);
		return s;
	}
}

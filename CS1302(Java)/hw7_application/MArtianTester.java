package application;
import martian_stuff.*;

public class MArtianTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MartianManager mm = new MartianManager();
		mm.addMartian(new GreenMartian(33,99,true,false));
		System.out.println(mm.groupSpeak());
		for(int i=0; i<mm.getNumMartians(); i++) {
			System.out.println(mm.getMartianAt(i));

		}	
	}
}


package prob2;

public class Blob {

	private int coolnessFactor;

	public Blob(int coolnessFactor) {
		this.coolnessFactor = coolnessFactor;
	}

	public int getCoolnessFactor() {
		return coolnessFactor;
	}

	@Override
	public String toString(){
		return "B(" + coolnessFactor + ")";
	}
}

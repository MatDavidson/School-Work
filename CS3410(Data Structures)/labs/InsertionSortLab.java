
public class InsertionSortLab {

	public static void main(String[] args) {
		int [] a = new int[6];
		
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 6);
		}
		for(int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}
		System.out.print("\n");

		incInsertion(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}
		System.out.print("\n");
		
		decInsertion(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print("\t" + a[i]);
		}
	}

	public static void incInsertion(int[] a) {
		for(int i=1; i < a.length; i++) {
			int key = a[i];
			int j = i-1;
			
			while(j >= 0 && a[j] > key) {
				a[j+1] = a[j];
				j -= 1;
			}
			a[j+1] = key;
		}
	}
	
	public static void decInsertion(int[] a) {
		for(int i=1; i < a.length; i++) {
			int key = a[i];
			int j = i-1;
			
			while(j >= 0 && a[j] < key) {
				a[j+1] = a[j];
				j -= 1;
			}
			a[j+1] = key;
		}
	}
}

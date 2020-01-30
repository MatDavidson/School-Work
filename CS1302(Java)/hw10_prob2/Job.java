package prob2;

public class Job {
	private int securityLevel;
	private int priority;
	public Job(int priority, int securityLevel) {
		this.priority = priority;
		this.securityLevel = securityLevel;
	}
	public int getSecurityLevel() {
		return securityLevel;
	}
	public int getPriority() {
		return priority;
	}
	@Override
	public String toString() {
		return "(p-" + priority + ",s-" + securityLevel + ")";
	}
}

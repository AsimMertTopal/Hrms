package Hrms.core.utilities.results;

public class DataResult <T> extends Result{
	private T data; 
	public DataResult (T data,String message,boolean success) {
		super(success,message);
		this.data=data;
		
	}
	public DataResult(T data,boolean success) {
		super(success);
		this.data=data;
		
	}
	
	public T data() {
		return this.data;
	}
}

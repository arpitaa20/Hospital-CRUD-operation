package jsp.SpringBoot;

public class ResponseStructure<T> {
	private int statusCode;
	private String message;
	private T data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public int getStatusCode() {
		return statusCode;
	}

}

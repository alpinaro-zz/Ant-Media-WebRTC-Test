package io.antmedia.webrtctest;

public abstract class StreamManager {
	protected WebRTCManager manager;
	long count = 0;
	long totalDt = 0;
	long last;
	boolean firstFrame = true;
	private boolean isRunning;
	private boolean isStarted = false;

	public void start() { 
		isStarted = true;
		isRunning = true; 
	}
	public void stop() { 
		isRunning = false; 
	}

	public void setManager(WebRTCManager manager) {
		this.manager = manager;
	}
	public int getFramePeriod() {
		if(count != 0) {
			return (int) (totalDt/count);
		} 
		else {
			return 40;
		}
	}

	protected void update() {
		long now = System.currentTimeMillis();
		if(firstFrame) {
			firstFrame = false;
			count = 0;
		}
		else {
			totalDt += (now - last);
			count++;
		}
		last = now;
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	
	public boolean isStarted() {
		return isStarted;
	}
}

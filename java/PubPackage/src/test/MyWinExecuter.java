package test;

import java.io.IOException;

public class MyWinExecuter {
	
	public synchronized void exeCute(String cmd) {
		Process process = null;
		try {
			process = java.lang.Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(process != null) {
				process.waitFor();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package ThreadsJava;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import ThreadsJava.Exeptions.ResourсeException;


public class Airport {
	
    private final static int TERMINALS = 3;
    private final static int GATES = 4;
    private final Semaphore semaphore = new Semaphore(TERMINALS * GATES, true);
    private final ArrayList<Gate> gates = new ArrayList<Gate>();
    
    public Airport() {
        for (int i = 0; i < TERMINALS; i++){
            for (int j = 0; j < GATES; j++){
                gates.add(new Gate(i,j));
            }
        }
    }

    public Gate getGate(long maxWaitMillis) throws ResourсeException {
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                for (int i = 0; i < gates.size(); i++){
                    if (gates.get(i).isFree()){
                        gates.get(i).occupy();
                        return gates.get(i);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new ResourсeException(e);
        }
        throw new ResourсeException(": too much time to waiting");
    }

    public void returnGate(Gate gate) {
        gate.release();
        semaphore.release();
    }
}

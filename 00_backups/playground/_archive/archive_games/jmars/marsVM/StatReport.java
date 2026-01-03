/*-
 * Copyright (c) 1998 Brian Haskin jr.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 */

// object returned by the mars vm to show what has been modified

package marsVM;

public class StatReport
{
	protected WarriorObj warrior;
	
	protected int readAddr[];
	protected int numRead;
	protected int indirReadAddr[];
	protected int numIndirRead;
	protected int writeAddr[];
	protected int numWrite;
	protected int decAddr[];
	protected int numDec;
	protected int incAddr[];
	protected int numInc;
	protected int execAddr;
	protected int pDieAddr;
	protected int numProc;
	protected boolean wDeath;
	
	public StatReport()
	{
		readAddr = new int[4];
		numRead = 0;
		indirReadAddr = new int[4];
		numIndirRead = 0;
		writeAddr = new int[4];
		numWrite = 0;
		decAddr = new int[5];
		numDec = 0;
		incAddr = new int[5];
		numInc = 0;
		execAddr = -1;
		pDieAddr = -1;
		
		return;
	}
	
	// Warrior ID
	public void warrior(WarriorObj warr)
	{
		warrior = warr;
		
		return;
	}
	
	// Read location
	public void read(int addr)
	{
		readAddr[numRead] = addr;
		numRead++;
		
		return;
	}
	
	// read from indirection
	public void indirRead(int addr)
	{
		indirReadAddr[numIndirRead] = addr;
		numIndirRead++;
		
		return;
	}
	
	// Write location
	public void write(int addr)
	{
		writeAddr[numWrite] = addr;
		numWrite++;
		
		return;
	}
	
	// Decrement location
	public void decrement(int addr)
	{
		decAddr[numDec] = addr;
		numDec++;
		
		return;
	}
		
	// Increment location
	public void increment(int addr)
	{
		incAddr[numInc] = addr;
		numInc++;
		
		return;
	}
	
	// Execute location
	public void execute(int addr)
	{
		execAddr = addr;
		
		return;
	}
	
	//set the number of processes
	public void numProc(int numP)
	{
		numProc = numP;
		
		return;
	}
	
	// Process die
	public void pDie(int addr)
	{
		pDieAddr = addr;
	
		return;
	}
	
	// Warrior die
	public void wDie()
	{
		wDeath = true;
		
		return;
	}
	
	// Get Warrior
	public WarriorObj warrior()
	{
		return warrior;
	}
	
	// Get addresses read
	public int[] addrRead()
	{
		int value[] = new int[numRead];
		
		for (int i=0; i<numRead; i++)
			value[i] = readAddr[i];
		
		return value;
	}
	
	// Get addresses read through indirection
	public int[] addrIndirRead()
	{
		int value[] = new int[numIndirRead];
		
		for (int i=0; i<numIndirRead; i++)
			value[i] = indirReadAddr[i];
			
		return value;
	}
	
	// Get addresses written to
	public int[] addrWrite()
	{
		int value[] = new int[numWrite];
		
		for (int i=0; i<numWrite; i++)
			value[i] = writeAddr[i];
		
		return value;
	}
	
	// Get addresses decremented
	public int[] addrDec()
	{
		int	value[] = new int[numDec];
		
		for (int i=0; i<numDec; i++)
			value[i] = decAddr[i];
		
		return value;
	}
	
	// Get addresses incremented
	public int[] addrInc()
	{
		int	value[] = new int[numInc];
		
		for (int i=0; i<numInc; i++)
			value[i] = incAddr[i];
		
		return value;
	}
	
	// Get addresses executed
	public int addrExec()
	{
		return execAddr;
	}
	
	// Get number of processes
	public int numProc()
	{
		return numProc;
	}
	
	// Get addresses of process death
	public int addrPDeath()
	{
		return pDieAddr;
	}
	
	// Check for warrior death
	public boolean wDeath()
	{
		return wDeath;
	}
}

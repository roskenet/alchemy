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

/**
 * jMARS is a corewars interpreter in which programs (warriors)
 * battle in the memory of a virtual machine (the MARS) and try to disable
 * the other program.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URL;
import java.io.*;

import marsVM.*;
import frontend.*;

public class jMARS extends java.applet.Applet implements Runnable, WindowListener
{
	// constants
	static final int num_def_colors = 4;
	static final Color wColors[][] = {{Color.green, Color.yellow},
									   {Color.red, Color.magenta},
									   {Color.cyan, Color.blue},
									   {Color.gray, Color.darkGray}};

	// static variables
	static boolean in_applet = true;
	
	// Application specific variables
	String args[];
	static Frame myFrame;
	static jMARS myApp;
	static Thread myThread;
	
	// Common variables
	int maxProc;
	int pspaceSize;
	int coreSize;
	int cycles;
	int rounds;
	int maxWarriorLength;
	int numWarriors;
	int minWarriors;
	
	WarriorObj warriors[];
	CoreDisplay coreDisplay;
	MarsVM MARS;
	Thread thisThread;
	
	int roundNum;
	int cycleNum;
	int warRun;
	int runWarriors;
	
	Date startTime;
	Date endTime;
	double totalTime;
	
	public static void main(String a[])
	{
		if (a.length == 0)
		{
			System.out.println("usage: jMARS warrior1.red [warrior2.red ...]");
			return;
		}
		
		in_applet = false;
		
		myFrame = new Frame("jMARS");
		myFrame.setSize(new Dimension(500, 300));
		
		myApp = new jMARS();
		myApp.args = a;
		
		myFrame.add(myApp);
		myFrame.addWindowListener(myApp);
		myFrame.show();
		
		myApp.application_init();
		
		myThread = new Thread(myApp);
		
		myThread.setPriority(Thread.NORM_PRIORITY-1); 
				
		myThread.start();
		
		return;
	}
	
	public void init()
	{
		// Set up various constants
		maxWarriorLength = 100;
		maxProc = 8000;
		coreSize = 8000;
		pspaceSize = coreSize / 16;
		cycles = 80000;
		rounds = 10;
		roundNum = 0;
		cycleNum = 0;
		int warRun = 0;
		
		numWarriors = Integer.parseInt(getParameter("num_warriors"));
		warriors = new WarriorObj[numWarriors];
		
		for (int i=0; i<numWarriors; i++)
		{
			try
			{
				URL wURL = new URL(getParameter("warrior" + i));
				
				BufferedReader warRead = new BufferedReader(new InputStreamReader(wURL.openStream()));
			
				warriors[i] = new WarriorObj(warRead, maxWarriorLength, Color.green, Color.yellow);
			} catch (IOException e)
			{
				System.out.println(e.toString());
				System.exit(0);
			}
		}
		
		coreDisplay = new CoreDisplay(coreSize, 401);
		
		add(coreDisplay);
		validate();
		update(getGraphics());
		
		MARS = new MarsVM(coreSize, maxProc, pspaceSize);
		if (!MARS.loadWarrior(warriors[0], 0))
		{
			System.out.println("ERROR: could not load warrior 1.");
		}
		
		
		numWarriors = 1;
		runWarriors = 1;
		minWarriors = 0;
		return;
	}
	
	void application_init()
	{
		boolean pspaceChanged = false;
		Vector wArgs = new Vector();

		// Set defaults for various constants
		maxWarriorLength = 100;
		maxProc = 8000;
		coreSize = 8000;
		cycles = 80000;
		rounds = 10;
		roundNum = 0;
		cycleNum = 0;
		int warRun = 0;
		
		for (int i=0; i<args.length; i++)
		{
			if (args[i].charAt(0) == '-')
			{
				if (args[i].equals("-r"))
				{
					rounds = Integer.parseInt(args[++i]);
				} else if (args[i].equals("-s"))
				{
					coreSize = Integer.parseInt(args[++i]);
				} else if (args[i].equals("-c"))
				{
					cycles = Integer.parseInt(args[++i]);
				} else if (args[i].equals("-p"))
				{
					maxProc = Integer.parseInt(args[++i]);
				} else if (args[i].equals("-l"))
				{
					maxWarriorLength = Integer.parseInt(args[++i]);
				} else if (args[i].equals("-S"))
				{
					pspaceSize = Integer.parseInt(args[++i]);
					pspaceChanged = true;
				}
			} else
			{
				numWarriors++;
				
				wArgs.addElement(new Integer(i));
			}
		}
		
		if (!pspaceChanged)
			pspaceSize = coreSize / 16;
		
		if (numWarriors == 0)
			System.out.println("ERROR: no warrior files specified");
		
		warriors = new WarriorObj[numWarriors];
		
		for (int i=0; i<numWarriors; i++)
		{
			try
			{
				FileReader wFile = new FileReader(args[(((Integer) wArgs.elementAt(i)).intValue())]);
				warriors[i] = new WarriorObj(wFile, maxWarriorLength, wColors[i % 4][0], wColors[i % 4][1]);
				warriors[i].initPSpace(pspaceSize);
				warriors[i].setPCell(0, -1);
			} catch (FileNotFoundException e)
			{
				System.out.println("Could not find warrior file " + args[i]);
				System.exit(0);
			}
		}
				
		coreDisplay = new CoreDisplay(coreSize, 402);
		
		add(coreDisplay);
		validate();
		update(getGraphics());
		
		MARS = new MarsVM(coreSize, maxProc, pspaceSize);
		
		loadWarriors();
		
		runWarriors = numWarriors;
		minWarriors = (numWarriors == 1) ? 0 : 1;
		return;
	}
	

	public void run()
	{
		startTime = new Date();

		for (; roundNum<rounds; roundNum++)
		{
			for (; cycleNum<cycles; cycleNum++)
			{
				for (; warRun < runWarriors; warRun++)
				{
					StatReport stats = MARS.executeInstr();
					
					WarriorObj war = stats.warrior();
					war.numProc = stats.numProc();
									
					if (stats.wDeath())
					{
						war.Alive = false;
						runWarriors--;
					}
					
					coreDisplay.wColor = war.myColor;
					coreDisplay.dColor = war.dColor;
				
					coreDisplay.proccess(stats); 
					
				}
				
				repaint();
				
				if (runWarriors <= minWarriors)
					break;
					
				warRun = 0;

			}
			
			endTime = new Date();
			totalTime = ((double) endTime.getTime() - (double) startTime.getTime()) / 1000;
			System.out.println("Total time = " + totalTime);
			startTime = new Date();
			
			MARS.reset();
			loadWarriors();
			runWarriors = numWarriors;
			coreDisplay.clear();
			
			
			cycleNum = 0;
		}
	}
	
	
	void loadWarriors()
	{
		if (!MARS.loadWarrior(warriors[0], 0))
		{
			System.out.println("ERROR: could not load warrior 1.");
		}
		
		for (int i=1, r=0; i<numWarriors; i++)
		{
			r = (int) (Math.random() * coreSize);
			
			if (!MARS.loadWarrior(warriors[i], r))
			{
				System.out.println("ERROR: could not load warrior " + (i+1) + ".");
			}
		}
	}
	
	
	public void update(Graphics g)
	{
		paintComponents(g);
		
		paint(g);
		
		return;
	}
	
	public void paint(Graphics g)
	{
		g.clearRect(0, 220, 200, 40);
		g.drawString("Round #" + roundNum + " Cycle #" + cycleNum, 0, 250);
		
		return;
	}
	

    /**
     * Invoked when a window is in the process of being closed.
     * The close operation can be overridden at this point.
     */

	public void windowClosing(WindowEvent e)
	{
		myApp.stop();
		System.exit(0);
	} 

    /**
     * Invoked when a window has been opened.
     */
    public void windowOpened(WindowEvent e)
    {
    	
    }

    /**
     * Invoked when a window has been closed.
     */
    public void windowClosed(WindowEvent e)
    {

    }

    /**
     * Invoked when a window is iconified.
     */
    public void windowIconified(WindowEvent e)
    {

    }

    /**
     * Invoked when a window is de-iconified.
     */
    public void windowDeiconified(WindowEvent e)
    {

    }

    /**
     * Invoked when a window is activated.
     */
    public void windowActivated(WindowEvent e)
	{
		
	}

    /**
     * Invoked when a window is de-activated.
     */
    public void windowDeactivated(WindowEvent e)
    {
    	
    }	
}


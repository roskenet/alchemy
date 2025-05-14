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

package frontend;

import java.awt.*;

import marsVM.StatReport;

public class CoreDisplay extends Canvas
{
	public Color wColor;
	public Color dColor;
	protected Color background;
	
	protected int coreSize;

	protected int width;
	protected int height;
	
	protected Image offScreen;
	protected Graphics buffer;
	
	public CoreDisplay(int coreS, int w)
	{
		coreSize = coreS;
		width = w;
		height = ((coreSize / (width /3)) +1) *3;

		
		background = Color.black;
	}
	
	public void proccess(StatReport report)
	{
		int x,y;
		int i;
		int addr[];
		
		if (offScreen == null)
			return;
		
		buffer.setColor(wColor);
		
		addr = report.addrRead();
		for (i=0; i < addr.length; i++)
		{
			y = (addr[i] / (width /3)) * 3;
			x = (addr[i] % (width /3)) * 3;
			
			buffer.drawLine(x, y, x, y);
		}
		
		addr = report.addrWrite();
		for (i=0; i < addr.length; i++)
		{
			y = (addr[i] / (width /3)) * 3;
			x = (addr[i] % (width /3)) * 3;
			
			buffer.drawLine(x+1, y, x, y+1);
		}

		addr = report.addrDec();
		for (i=0; i < addr.length; i++)
		{
			y = (addr[i] / (width /3)) * 3;
			x = (addr[i] % (width /3)) * 3;
			
			buffer.drawLine(x, y, x+1, y);
		}
		
		addr = report.addrInc();
		for (i=0; i < addr.length; i++)
		{
			y = (addr[i] / (width /3)) * 3;
			x = (addr[i] % (width /3)) * 3;
			
			buffer.drawLine(x, y, x+1, y);
		}
		
		if ((i = report.addrExec()) != -1)
		{
			y = (i / (width /3)) * 3;
			x = (i % (width /3)) * 3;
			
			buffer.drawLine(x, y, x+1, y);
			buffer.drawLine(x, y+1, x+1, y+1);
		}
		
		if ((i=report.addrPDeath()) != -1)
		{
			y = (i / (width /3)) * 3;
			x = (i % (width /3)) * 3;
			
			buffer.setColor(dColor);
			buffer.drawLine(x, y, x+1, y);
			buffer.drawLine(x, y+1, x+1, y+1);
		}
		
		return;
	}
	
	public void clear()
	{
		if (offScreen == null)
			return;
		
		buffer.setColor(background);
		buffer.fillRect(0, 0, width, height);
	}

	public void paint(Graphics screen)
	{
		if (offScreen == null)
		{
			offScreen = createImage(width, height);
			buffer = offScreen.getGraphics();
			buffer.setColor(background);
			buffer.fillRect(0, 0, width, height);
		}


		screen.drawImage(offScreen, 0, 0, this);
		
		return;
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension( width, height);
	}
	
	public Dimension getMinimumSize()
	{
		return new Dimension( width, height);
	}
	
	public float getAlignmentX()
	{
		return 0.5F;
	}
	
	public float getAlignmentY()
	{
		return 0.5F;
	}
}

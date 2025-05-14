/*
 * CuppaClock.h
 *
 *  Created on: Mar 18, 2024
 *      Author: felix
 */

#ifndef CUPPACLOCK_H_
#define CUPPACLOCK_H_

class CuppaClock {
public:
	CuppaClock();
	CuppaClock(int min, int sec);
	virtual ~CuppaClock();
private:
	int min;
	int sec;
};

#endif /* CUPPACLOCK_H_ */

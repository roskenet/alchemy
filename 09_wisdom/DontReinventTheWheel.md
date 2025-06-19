# Don't Reinvent the Wheel

"Never reinvent the wheel — especially not a security layer, a state machine, or an XML parser."

Sometimes people add others to that cursed list, like regex engines or database drivers — basically anything that’s:

Complex under the hood

Deceptively simple on the surface

Already been written, tested, and broken a thousand times

Why those three?
Security layer – Get it wrong, and you’re on the front page of Hacker News, and not in a good way.

State machines – Easy to start, turns into a nightmare spaghetti of states and transitions.

XML parsers – So many edge cases, encoding issues, and maliciously crafted documents that will ruin your day.

This little "rule of thumb" is often used to remind devs to use battle-tested libraries rather than rolling their own just for fun – unless it’s really justified (and it almost never is).


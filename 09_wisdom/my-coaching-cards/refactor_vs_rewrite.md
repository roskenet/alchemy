Joel Spolsky „Things You Should Never Do“

## 🛠️ Coaching Cards: Refactor vs. Rewrite

### 🔁 Refactoring: The Devil You Know
Legacy code may be ugly, but at least it works (most of the time).  
Refactoring means you're patching the boat while staying afloat.  
Not sexy, but way less likely to sink the whole ship.  
Don't burn it down just because the wallpaper is outdated.

---

### 🔄 Rewriting: The Siren Song
Starting from scratch feels clean and glorious—until you realize how much weird stuff the old system actually did.  
You will forget features, misinterpret edge cases, and reintroduce old bugs like a reunion tour.  
Most rewrites underestimate the cost by 300% (minimum).  
Ask yourself: are we solving real problems or just bored?

---

### 🌿 Strangler Pattern: Kill With Kindness
Want to rewrite, but safely? Strangle the old system bit by bit.  
Wrap, replace, repeat—until the old beast is gone.  
This way, you learn and clean up at the same time.  
Slow is smooth, smooth is fast.

---

### 💸 The Cost of "Clean"
"Let’s just rebuild it in Go, it'll be faster!" Famous last words.  
Clean code is a dream, but dreams cost time, money, and nerves.  
Measure the gain before diving headfirst into The Great Rewrite.  
Legacy is messy, but often it’s messy for a reason.

---

### 🧠 Tribal Knowledge Trap
You think the old code is garbage, but it's full of decisions someone made for reasons—good or bad.  
If no one remembers why things are the way they are, rewriting won't save you—it'll just give you new mysteries.  
Talk to the old devs, read the commits, sniff out those “WTFs”.  
Understanding beats assuming.

---

### 💣 Don't Blow Up Your Own Roadmap
Rewriting is exciting right up to the moment it blows your deadlines to smithereens.  
Refactoring lets you deliver value *while* improving things.  
If the business hears "18 months, no new features", you're toast.  
Be smart, not just ambitious.



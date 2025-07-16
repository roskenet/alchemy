# Advisory Locks
 
These are application-defined locks that allow you to coordinate access between sessions at the application level, rather than relying on table-level locks.

You can find the documentation for advisory locks in the PostgreSQL manual under "Explicit Locking":
https://www.postgresql.org/docs/current/explicit-locking.html#ADVISORY-LOCKS

The main functions are:
- `pg_advisory_lock(key)` - Obtain exclusive lock
- `pg_advisory_unlock(key)` - Release lock
- `pg_try_advisory_lock(key)` - Non-blocking attempt to obtain lock
- `pg_advisory_lock_shared(key)` - Obtain shared lock

There are also session-level variants that automatically release at the end of a session.
 
PostgreSQL advisory locks can serve as a replacement for tools like Java's ShedLock in certain scenarios.

Advisory locks offer advantages:
- They're built into PostgreSQL, so no additional libraries needed
- Low overhead and good performance
- Automatic cleanup if a client disconnects unexpectedly

However, there are considerations:
- They're PostgreSQL-specific, so you lose database portability
- They're best suited for applications already using PostgreSQL
- They require direct database access, which might not align with your architecture

Advisory locks are perfectly valid for non-database coordination tasks like:
- Distributed cron job deduplication
- Cluster leadership election
- Coordinating access to shared resources

There's no specific discouragement from PostgreSQL about using them for general coordination purposes. In fact, the documentation explicitly states they're designed for application-level locking strategies.

If you're already using PostgreSQL, advisory locks can be simpler and more efficient than bringing in a separate tool like ShedLock.


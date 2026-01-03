from builtins import print
from psycopg2 import connect

conn = connect(
    host="localhost",
    database="felix",
    user="felix",
    password="password")

cur = conn.cursor()

# execute a statement
cur.execute('SELECT * FROM test')

# display the PostgreSQL database server version
result = cur.fetchone()
print(result)
fetchone = cur.fetchone()
print(fetchone)
# Don't execute me: I am an infinite loop
# while cur:
#     print(result)
#     cur.fetchone()


# close the communication with the PostgreSQL
cur.close()

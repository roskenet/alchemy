# Apache Cassandra

## Found here:
https://vocon-it.com/2016/12/08/cassandra-hello-world-example/#Steps_to_install_a_Docker_Host_VirtualBox_VM

```bash
docker run -it --rm --name cassandra-node1 -p7000:7000 -p7001:7001 -p9042:9042 -p9160:9160 cassandra:3

docker inspect --format='{{ .NetworkSettings.IPAddress }}' cassandra-node1

sudo docker run -it --rm --entrypoint="bash" --name cassandra-node2 \
              -p27000:7000 -p27001:7001 -p29042:9042 -p29160:9160 \
              -e CASSANDRA_SEEDS="$(docker inspect --format='{{ .NetworkSettings.IPAddress }}' cassandra-node1)" \
              cassandra:3

/docker-entrypoint.sh cassandra -f

```

```bash
docker run -it --rm -e CQLSH_HOST=$(docker inspect --format='{{ .NetworkSettings.IPAddress }}' cassandra-node1) --name cassandra-client --entrypoint=cqlsh cassandra
```

```bash
create keyspace mykeyspace with replication = {'class':'SimpleStrategy','replication_factor' : 2};
```

```bash
cqlsh> use mykeyspace;
cqlsh:mykeyspace> create table usertable (userid int primary key, usergivenname varchar, userfamilyname varchar, userprofession varchar);
cqlsh:mykeyspace>

cqlsh:mykeyspace> insert into usertable (userid, usergivenname, userfamilyname, userprofession) values (1, 'Oliver', 'Veits', 'Freelancer');
cqlsh:mykeyspace>
```


```bash
docker run -it --rm -e CQLSH_HOST=$(docker inspect --format='{{ .NetworkSettings.IPAddress }}' cassandra-node1) --name cassandra-nodetool --entrypoint='/bin/bash' cassandra
```

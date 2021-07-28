# janusgraph-cassandra-elastic-docker

To run:

`docker compose -f docker-compose-cql-es.yml up`

This will initiate Janusgraph, Cassandra and Elastic containers.  It will copy the file `airRoutes.xml`
to the Janusgraph container.  Then the script `add_xml_grph.groovy` will be copied to
`/docker-entrypoint-initdb.d` and will therefore be run and load the xml as a graph.

*NB*: the default memory allocation in Docker Desktop is often not sufficient,
if this is the case the process will crash with a 137 error.  The memory allocation
can be increased in the Docker Desktop UI.

A different xml file can be loaded by adding it to the data folder before composing. The filename in the path in `add_xml_grph.groovy` must be updated to reflect the
new filename. 

To shutdown: 

`docker rm -f jce-janusgraph jce-elastic jce-cassandra`


####Connecting and Viewing data through Gremlin
It's easier to connect via Gremlin from inside the Janus docker container, as 
opposed to starting Gremlin on the host machine, due to issues with mismatching java versions

Start bash shell in the Janus container: 

`docker exec -it jce-janusgraph /bin/bash`

Start Gremlin:

`./bin/gremlin.sh`

connect to the existing instance remotely:

```
gremlin> :remote connect tinkerpop.server conf/remote.yaml
==>Configured localhost/127.0.0.1:8182
```

count the nodes as a test:

```
gremlin> :> g.V().count()
==>3619

```

#### Connecting and Viewing data with Python
There is a `connect_with_python.py` script and `requirements.txt` to show how to 
connect to the instance with Python.  Once the requirements are installed,
this can be run from the host machine and should output the number of nodes

####Viewing data visually with graphexp

Can use **graphexp** located at https://github.com/armandleopold/graphexp

just clone this locally:

`git clone https://github.com/armandleopold/graphexp.git`

and then open the file *graphexp.html* in a browser.  Then click on `search` in the top right
corner and the nodes should show up.





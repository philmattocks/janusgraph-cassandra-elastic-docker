# janusgraph-cassandra-elastic-docker

To run:

`docker compose -f docker-compose-cql-es.yml up`

This will initiate Janusgraph, Cassandra and Elastic.  It will copy the file `airRoutes.xml`
to the Janusgraph container.  Then the script `add_xml_grph.groovy` will be copied to
`/docker-entrypoint-initdb.d` and will therefore be run and load the xml as a graph.

A different xml file can be loaded by adding it to the data folder before composing.  
The filename in the path in `add_xml_grph.groovy` must be updated to reflect the
new filename. 

To shutdown: 

`docker rm -f jce-janusgraph jce-elastic jce-cassandra`


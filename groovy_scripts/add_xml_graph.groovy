g = traversal().withRemote('conf/remote-graph.properties')
// add a graph from an xml file.  The XML must be placed in the local data folder which will be synced to the container
g.io('data_from_host/airRoutes.xml').read().iterate()


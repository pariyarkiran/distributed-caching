This project is simple demo of distributed caching using Hazelcast.

Run multiple instance of project using following example commands.
  - ./gradlew bootRun --args='--server.port=8080'
  - ./gradlew bootRun --args='--server.port=8081'


Hit the post api in one port and you can the the data from another instance.

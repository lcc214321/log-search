FROM openjdk:10.0.2
ADD log-search-0.0.1-SNAPSHOT.jar /log-search.jar
CMD ["java","-Xms512m","-Xmx512m","-jar","log-search.jar"]

# 不要忘记了 暴露端口
# CMD ["java","-Dcom.sun.management.jmxremote.rmi.port=1099","-Dcom.sun.management.jmxremote=true","-Dcom.sun.management.jmxremote.port=1099","-Dcom.sun.management.jmxremote.ssl=false","-Dcom.sun.management.jmxremote.authenticate=false","-Dcom.sun.management.jmxremote.local.only=false","-Djava.rmi.server.hostname=10.138.12.12","-jar","application.jar"]
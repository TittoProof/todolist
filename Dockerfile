FROM relateiq/oracle-java8

COPY ToDoList-0.1.jar ToDoList.jar

CMD java -jar ToDoList.jar
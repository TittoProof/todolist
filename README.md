# todolist
a very simply ToDo list

how to run
mvn spring-boot:run

for swagger http://localhost:8080/swagger-ui.html

for ping http://localhost:8080/ping


actuator
/health – Shows application health information (a simple ‘status’ when accessed over an unauthenticated connection or full message details when authenticated); it’s not sensitive by default
/info – Displays arbitrary application info; not sensitive by default
/metrics – Shows ‘metrics’ information for the current application; it’s also sensitive by default
/trace – Displays trace information (by default the last few HTTP requests)
more here: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints
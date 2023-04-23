# Patient Data Manager
Application with which you can manage the information about the patients and record their visits.

In order to start the application you have to create directory 'profiles/local' in project root and 
add there the 'config.properties', then you need add next configurations to this file:

* datasource.url=db url(for example: jdbc:mysql://127.0.0.1:3306/patients_data_manager_db)
* datasource.username=db username
* datasource.password=db password

After that just build the maven project for 'local' profile and that it, you can start the application.

When application is started, REST Api documentation is available under:
http://localhost:8080/swagger-ui.html

At the moment the project uses MySql RDBMS, but can be extended to use any other RDBMS as well in future releases.
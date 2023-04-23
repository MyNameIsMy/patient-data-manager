# Patient Data Manager
Application with which you can manage the information about the patients and record their visits.

In order to start the application you have to create directory 'profiles/local' and add 
there the 'config.properties', then you need add next configurations to this file:

datasource.url=db url(for example: jdbc:mysql://127.0.0.1:3306/patients_data_manager_db)
datasource.username=db username
datasource.password=db password

At the moment the project uses MySql RDBMS, but can be extended to use any other RDBMS.
psql -q -U hibernate -d community -h localhost -p 5432 -f create_tables.sql
javac -cp postgresql-42.2.15.jar InitializeDefaultTableValues.java
java -cp postgresql-42.2.15.jar: InitializeDefaultTableValues
rm InitializeDefaultTableValues.class
psql -U hibernate -d community -h localhost -p 5432 -f create_tables.sql
psql -U hibernate -d community -h localhost -p 5432 -c "\copy country(name) FROM 'country.txt';"
psql -U hibernate -d community -h localhost -p 5432 -c "\copy programming_language(name) FROM 'programming_language.txt';"
psql -U hibernate -d community -h localhost -p 5432 -c "\copy spoken_language(name) FROM 'spoken_language.txt';"

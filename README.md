# coleta-lixo-api

<h3>Build</h3>
docker build -t api .

<h3>Run</h3>
docker run -p 8080:8080 \                                 
-e PROFILE=prd \
-e DATABASE_URL=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL \
-e DATABASE_USER={YourDBUserName} \
-e DATABASE_PWD={YourDBPassword} \
api

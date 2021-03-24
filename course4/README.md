## Database access

Do not forget to add to “context.xml” file in %apache tomcat%/conf or to %app%/src/main/webapp/META-INF/context.xml

    <Context>
         <Resource name="jdbc/TestDB" auth="Container" type="javax.sql.DataSource"
                   maxTotal="100" maxIdle="30" maxWaitMillis="10000"
                   username="root" password="root" driverClassName="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/jdbcex"/>
    </Context>

Also take a look at web.xml

Interaction is the following:
ProductController gets the request, calls ProductService which calls JDBCProductDao to get the 
products from the database. Then ProductController adds the products in the request scope 
and forwards the request to ProductView. ProductView retrieves the products from the
request scope and writes them in the response.



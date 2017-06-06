package me.breh;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&useTimezone=false");

        Configuration conf = new DefaultConfiguration().set(SQLDialect.MYSQL).set(conn);

        new MyTable().createTable(DSL.using(conf));
        // Expected:
        // create table `mytablename`(`id` int not null auto_increment, `name` varchar(64) not null)

        // Generates:
        // create table `mytablename`(`id` int not null auto_increment, `name` varchar not null)
    }
}

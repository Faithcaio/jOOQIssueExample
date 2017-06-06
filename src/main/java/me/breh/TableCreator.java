package me.breh;

import org.jooq.*;

import java.sql.SQLException;

public interface TableCreator<T extends Record> extends org.jooq.Table<T>
{
    void createTable(DSLContext dsl) throws SQLException;
}

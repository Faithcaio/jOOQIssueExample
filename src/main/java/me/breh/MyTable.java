package me.breh;

import static org.jooq.impl.SQLDataType.INTEGER;
import static org.jooq.impl.SQLDataType.VARCHAR;

import org.jooq.DSLContext;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;

import java.sql.SQLException;

public class MyTable extends TableImpl<MyRecord> implements TableCreator<MyRecord>
{
    public final TableField<MyRecord, Integer> ID = createField("id", INTEGER.identity(true), this);
    public final TableField<MyRecord, Player> NAME = createField("name",
            VARCHAR(64).asConvertedDataType(new PlayerConverter()).nullable(false), this);

    public MyTable()
    {
        super("mytablename");
    }

    public void createTable(DSLContext dsl) throws SQLException
    {
        dsl.createTable(this).columns(ID, NAME).execute();
    }
}

package me.breh;

import org.jooq.impl.UpdatableRecordImpl;

public class MyRecord extends UpdatableRecordImpl<MyRecord>
{
    public MyRecord()
    {
        super(new MyTable());
    }
}

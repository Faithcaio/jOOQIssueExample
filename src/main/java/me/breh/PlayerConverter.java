package me.breh;

import org.jooq.impl.AbstractConverter;

public class PlayerConverter extends AbstractConverter<String, Player>
{
    public PlayerConverter() {
        super(String.class, Player.class);
    }

    public Player from(String databaseObject) {
        return new Player(databaseObject);
    }

    public String to(Player userObject) {
        return userObject.getName();
    }
}

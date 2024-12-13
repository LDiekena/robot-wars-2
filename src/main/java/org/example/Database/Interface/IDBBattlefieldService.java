package org.example.Database.Interface;

import org.hibernate.Session;

public interface IDBBattlefieldService {

    void createBattlefield(Session session, int battlefieldRow, int battlefieldColumn, String[] mapItems);
}

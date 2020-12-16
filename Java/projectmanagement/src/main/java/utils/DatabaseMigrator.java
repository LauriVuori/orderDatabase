package utils;

import io.ebean.annotation.DbMigration;
import io.ebeaninternal.dbmigration.migration.Migration;
import org.flywaydb.core.Flyway;

public class DatabaseMigrator {


    public static void doMigrations() {
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/projectmanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password").load();
        flyway.migrate();
    }

}
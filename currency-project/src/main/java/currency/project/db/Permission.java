package currency.project.db;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    public static final List<String> adminPermission = new ArrayList<>();

    static {
        adminPermission.add("/currency/add");
        adminPermission.add("/currency/delete");
        adminPermission.add("/rate/add");
        adminPermission.add("/rate/delete");
    }
}

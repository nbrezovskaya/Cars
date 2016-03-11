package demo.test.menus;

import java.util.HashMap;
import java.util.Map;

public enum Menu {
    BUY,
    REVIEW_A_CAR;

    private static final Map<Menu, String> MAPPING = new HashMap<>();

    static {
        MAPPING.put(BUY, "Buy");
        MAPPING.put(REVIEW_A_CAR, "Review a Car");
    }

    public String getName() {
        return MAPPING.get(this);
    }
}

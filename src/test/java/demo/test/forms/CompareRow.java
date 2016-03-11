package demo.test.forms;

import java.util.HashMap;
import java.util.Map;

public enum CompareRow {
    ENGINES, TRANSMISSIONS;

    private static final Map<CompareRow, String> MAPPING = new HashMap<>();

    static {
        MAPPING.put(ENGINES, "Available Engines");
        MAPPING.put(TRANSMISSIONS, "Available Transmissions");
    }

    public String getName() {
        return MAPPING.get(this);
    }
}

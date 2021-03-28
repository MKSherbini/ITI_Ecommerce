package utilities;

public class SafeConverter {
    public static int safeIntParse(String str, int defaultValue) {
        int param = defaultValue;
        try {
            param = Integer.parseInt(str);
            if (param < 0)
                param = defaultValue;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return param;
    }

    public static Long safeLongParse(String str, Long defaultValue) {
        Long param = defaultValue;
        try {
            param = Long.parseLong(str);
            if (param < 0)
                param = defaultValue;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return param;
    }

}


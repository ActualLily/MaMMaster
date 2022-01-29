package lily.structures;

public class GeneratorSettings {
    public static class SettingConstants {
        private static final Double DEFAULT_LEFTBOUND_X = 0.025;
        private static final Double DEFAULT_RIGHTBOUND_X = 1 - DEFAULT_LEFTBOUND_X;
        private static final Integer SIZE_LARGE = 52;
        private static final Integer SIZE_MEDIUM = 42;
        private static final Integer SIZE_SMALL = 32;

        public static final Double ART_X = 0.01;
        public static final Double ART_Y = 0.093;
        public static final Double ART_HEIGHT = 0.4;
        public static final boolean SCALEART = true;

        // Reflected in IParameterized
        public static final String DEFAULT_PREFIX = "[";
        public static final String DEFAULT_SEPERATOR = "/";
        public static final String DEFAULT_SUFFIX = "]";
        public static final String COST_PREFIX = "(";
        public static final String COST_SEPERATOR = DEFAULT_SEPERATOR;
        public static final String COST_SUFFIX = ")";
        public static final String TYPE_PREFIX = "";
        public static final String TYPE_SEPERATOR = DEFAULT_SEPERATOR;
        public static final String TYPE_SUFFIX = "";
        public static final String STATS_PREFIX = DEFAULT_PREFIX;
        public static final String STATS_SEPERATOR = DEFAULT_SEPERATOR;
        public static final String STATS_SUFFIX = DEFAULT_SUFFIX;

        // Special case
        public static final String RANGE_PREFIX = DEFAULT_PREFIX;
        public static final String RANGE_SUFFIX = DEFAULT_SUFFIX;

        public static final Double NAME_Y = 0.068;
        public static final Double COST_Y = NAME_Y;
        public static final Double TYPE_Y = 0.972;
        public static final Double DESC_Y_START = 0.54;
        public static final Double STATS_Y = TYPE_Y;

        public static final Double NAME_X = DEFAULT_LEFTBOUND_X;
        public static final Double TYPE_X = DEFAULT_LEFTBOUND_X;
        public static final Double DESC_X = DEFAULT_LEFTBOUND_X;
        public static final Double COST_X = DEFAULT_RIGHTBOUND_X;
        public static final Double RANGE_X = DEFAULT_RIGHTBOUND_X;
        public static final Double STATS_X = DEFAULT_RIGHTBOUND_X;

        public static final Integer NAME_SIZE = SIZE_LARGE;
        public static final Integer TYPE_SIZE = SIZE_LARGE;
        public static final Integer COST_SIZE = SIZE_MEDIUM;
        public static final Integer DESC_SIZE = SIZE_SMALL;
        public static final Integer RANGE_SIZE = SIZE_MEDIUM;
        public static final Integer STATS_SIZE = SIZE_LARGE;
    }
}
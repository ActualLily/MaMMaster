package lily.structures;

public class GeneratorSettings {
    public static class SettingConstants {

        public static final Double NAME_Y = 0.068;
        public static final Double COST_Y = NAME_Y;
        public static final Double TYPE_Y = 0.972;
        public static final Double DESC_Y = 0.42;
        private static final Double DEFAULT_LEFTBOUND_X = 0.025;
        public static final Double NAME_X = DEFAULT_LEFTBOUND_X;
        public static final Double TYPE_X = DEFAULT_LEFTBOUND_X;
        public static final Double DESC_X = DEFAULT_LEFTBOUND_X;
        private static final Double DEFAULT_RIGHTBOUND_X = 1 - DEFAULT_LEFTBOUND_X;
        public static final Double COST_X = DEFAULT_RIGHTBOUND_X;
        private static final Integer SIZE_LARGE = 52;
        public static final Integer NAME_SIZE = SIZE_LARGE;
        public static final Integer TYPE_SIZE = SIZE_LARGE;
        private static final Integer SIZE_MEDIUM = 42;
        public static final Integer COST_SIZE = SIZE_MEDIUM;
        private static final Integer SIZE_SMALL = 32;
        public static final Integer DESC_SIZE = SIZE_SMALL;
    }
}
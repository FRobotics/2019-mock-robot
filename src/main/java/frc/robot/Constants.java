package frc.robot;

// TODO: copied

public class Constants {

    public static final boolean PRACTICE_ROBOT = true;

    public class Drive {
        /**
         * in inches
         */
        public static final double WHEEL_RADIUS = 2.0625;
        public static final double COUNTS_PER_REVOLUTION = 360 * 4;

        /**
         * in feet
         */
        public static final double WHEEL_CIRCUMFERENCE = (WHEEL_RADIUS / 12) * 2 * Math.PI;

        public static final int PID_LOOP_INDEX = 0;
        public static final int TIMEOUT_MS = 30;
        public static final double F = 0.92*1.8;
        public static final double P = 0.8;
        public static final double I = 0.0012;
        public static final double D = 0.01;
        public static final int INTEGRAL_ZONE = 150;
        public static final double OUTPUT_MULTIPLIER = 1 / (WHEEL_CIRCUMFERENCE / COUNTS_PER_REVOLUTION * 10);
        public static final double INPUT_MULTIPLIER = 1 / OUTPUT_MULTIPLIER;
    }
}

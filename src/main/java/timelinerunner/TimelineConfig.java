package timelinerunner;

import lombok.experimental.UtilityClass;

import java.time.Duration;

@UtilityClass
public class TimelineConfig {

    public static final Duration SKIRMISH_TTL = Duration.ofHours(2);
}

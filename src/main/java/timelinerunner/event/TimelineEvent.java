package timelinerunner.event;

import java.time.Instant;

public interface TimelineEvent {

    /**
     * All events occur at a time, and must publicize this.
     */
    Instant getTimeOfOccurrence();

    /**
     * Fairly open-ended. When an timelinerunner.event occurs, it can change timelinerunner.state, and it can schedule more events.
     */
    void occur();
}

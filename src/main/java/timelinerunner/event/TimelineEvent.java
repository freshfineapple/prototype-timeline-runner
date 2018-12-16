package timelinerunner.event;

import timelinerunner.state.Town;

import java.time.Instant;

public interface TimelineEvent {
    Instant getTimeOfOccurrence();

    Town happenToTown(Town town);
}

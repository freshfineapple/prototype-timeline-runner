package timelinerunner.event;

import lombok.Value;
import timelinerunner.state.Town;

import java.time.Instant;

@Value
public class ReachesTime implements TimelineEvent {
    private final Instant timeToReach;

    @Override
    public Instant getTimeOfOccurrence() {
        return timeToReach;
    }

    @Override
    public Town happenToTown(Town town) {
        return town.withCurrentTime(timeToReach);
    }

}

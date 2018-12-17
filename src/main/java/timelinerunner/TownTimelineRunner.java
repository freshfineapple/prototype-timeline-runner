package timelinerunner;

import java.time.Instant;
import java.util.Collections;
import java.util.Set;

import timelinerunner.occurrence.Occurrence;
import timelinerunner.state.Town;

// Note: This may not need to be its own class. It's possible this is just a static method of Town.
public class TownTimelineRunner {

    public Town advanceTownToTime(final Town town, Instant fromTime, Instant targetTime) {
        Instant currentTime = fromTime;
        Town currentTown = town;
        while (currentTime.isBefore(targetTime)) {
            Set<Occurrence> occurrences = currentTown.getOccurrences();

            Occurrence soonestOccurrence = Collections.min(occurrences);
            if (soonestOccurrence.getWhenToOccur().isAfter(targetTime)) {
                currentTime = targetTime;
            } else {
                currentTown = soonestOccurrence.occur(town);
                currentTime = soonestOccurrence.getWhenToOccur();
            }
        }

        return currentTown;
    }

}
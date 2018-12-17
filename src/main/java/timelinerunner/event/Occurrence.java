package timelinerunner.event;

import timelinerunner.state.Town;

import java.time.Instant;

/**
 * Something that happens to a Town, at a time.
 */
public interface TownOccurrence extends Comparable<TownOccurrence>{

    Instant getTimeOfOccurrence();

    /**
     * Returns a copy of the passed-in Town with the effects of this occurrence applied.
     * (Town is immutable.)
     */
    Town occur(Town town);

    @Override
    default int compareTo(TownOccurrence o) {
        return this.getTimeOfOccurrence().compareTo(o.getTimeOfOccurrence());
    }
}

package timelinerunner.occurrence;

import java.time.Instant;

import timelinerunner.state.Town;

/**
 *  Something that happens to a Town, at a time.
 */
public interface Occurrence extends Comparable<Occurrence>{

    Instant getWhenToOccur();

    /**
     *  Returns a copy of the passed-in Town with the effects of this occurrence applied.
     */
    Town occur(final Town town);

    @Override
    default int compareTo(Occurrence o) {
        return this.getWhenToOccur().compareTo(o.getWhenToOccur());
    }
}
package timelinerunner.state;

import java.util.Set;

import timelinerunner.occurrence.Occurrence;

/**
 *  Something in the town that causes things to happen over time.
 */
public interface CausesOccurrences {

    /**
     *  All the occurrences that will happen because of this object.
     */
    Set<Occurrence> getOccurrences();
}

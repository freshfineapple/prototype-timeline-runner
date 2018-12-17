package timelinerunner.state;

import timelinerunner.Timeline;

/**
 * Something in the town that implies changes to the town over time.
 */
public interface EvolvesWithTime {
    /**
     * All the events that will happen because of this object.
     */
    Timeline getForeseeableFuture();
}

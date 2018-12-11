package timelinerunner.state;

import timelinerunner.event.TimelineEvent;

import java.util.List;

public interface EvolvesWithTime {

    List<TimelineEvent> getDestiny();

}

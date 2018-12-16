package timelinerunner.state;

import lombok.Value;
import lombok.experimental.Wither;
import timelinerunner.event.TimelineEvent;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Value
public class Town implements EvolvesWithTime{
    @Wither private final Instant currentTime;


    @Override
    public List<TimelineEvent> getDestiny() {
        // TODO
        return new ArrayList<>();
    }

}

package timelinerunner;

import TheOutsideWorld.TownRepository;
import timelinerunner.event.ReachesTime;
import timelinerunner.event.TimelineEvent;
import timelinerunner.state.Town;

import java.time.Instant;
import java.util.List;

public class TownTimeline {
    private TownRepository townRepository = new TownRepository(); // TODO: We would inject this

    public Town getCurrentTimeVersionOfTown(String playerId) {
        final Instant timeToReach = Instant.now(); // TODO: Provide via timeProvider.

        Town town = townRepository.getTown(playerId);

        while (town.getCurrentTime().isBefore(timeToReach)) {
            List<TimelineEvent> events = town.getDestiny();
            events.add(new ReachesTime(timeToReach));

            // Sort the events by time.

            // Apply the results of that event to the town
            TimelineEvent nextEvent = events.stream().findFirst().get();
            town = nextEvent.happenToTown(town);

            // Set the currentTime of the town to the time of that event.
            // TODO: Does the event do this by happening to the town? Or is that too obscure?
            // TODO: We should probably see in this loop how time is advancing.
        }

        return town;
    }

}

package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    //repo.find(createdTimeEntry.getId());
    // repo.list()
    // TimeEntry updatedEntry = repo.update(
    //         created.getId(),
    //       new TimeEntry(321L, 654L, LocalDate.parse("2017-01-09"), 5));


    private List<TimeEntry> timeEntryList = new ArrayList<>();
    private int countEntries = 0;

    //Not a list just a single ob
    public TimeEntry create(TimeEntry timeEntry) {
        //int size = timeEntryList.size();
        //timeEntry.setId(timeEntryList.size() + 1L);
        if (timeEntry.getId() == 0) {

            timeEntry.setId(++this.countEntries);

        }
        timeEntryList.add(timeEntry);
        return find(timeEntry.getId());
    }

    public TimeEntry find(long id) {
        for (TimeEntry timeEntry : timeEntryList) {
            if (timeEntry.getId() == id)
                return timeEntry;
        }
        return null;
    }

    public List<TimeEntry> list() {
        return this.timeEntryList;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry entry = this.find(id);
//        entry.setProjectId(timeEntry.getProjectId());
//        entry.setUserId(timeEntry.getUserId());
//        entry.setHours(timeEntry.getHours());
//        entry.setDate(timeEntry.getDate());
        if (entry != null) {
            timeEntryList.remove(entry);
            timeEntry.setId(id);
            timeEntryList.add(timeEntry);
            return timeEntry;
        }
        else
            return null;



    }

    public void delete(long id) {
        TimeEntry timeEntry = this.find(id);
        if (timeEntry != null)
            timeEntryList.remove(timeEntry);
    }
}

package pl.mariuszkarpinski.homebudget.adapter.api;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataRangeResolver {

    public Pair<LocalDate, LocalDate> resolve(DataRange range, LocalDate fromDate, LocalDate toDate) {
        LocalDate now = LocalDate.now();
        if(DataRange.CURRENT_MONTH == range) {
            return Pair.of(now.withDayOfMonth(1), now);
        }
        if(DataRange.PREVIOUS_MONTH == range) {
            return Pair.of(now.withDayOfMonth(1).minusMonths(1), now.withDayOfMonth(1).minusDays(1));
        }
        if(DataRange.LAST_30_DAYS == range) {
            return Pair.of(now.minusDays(30), now);
        }
        if(DataRange.CUSTOM == range) {
            if(fromDate == null || toDate == null) {
                throw new IllegalStateException();
            }
            return Pair.of(fromDate, toDate);

        }
        return null;
    }

}

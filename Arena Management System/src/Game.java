

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;
import java.util.Objects;


public abstract class Game {

    private final String id;
    private String name;
    private int totalSlots;

    private final Set<Integer> bookedSlots = new HashSet<>();
    private double pricePerHour;

    public Game(String id, String name, int totalSlots, double pricePerHour) {
        this.id = Objects.requireNonNull(id, "id cannot be null");
        this.name = Objects.requireNonNull(name, "name cannot be null");
        if (totalSlots < 0) throw new IllegalArgumentException("totalSlots must be >= 0");
        this.totalSlots = totalSlots;
        this.pricePerHour = pricePerHour;
    }

    // ---------- basic getters/setters (encapsulation) ----------
    public String getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = Objects.requireNonNull(name); }

    public int getTotalSlots() { return totalSlots; }
    public void setTotalSlots(int totalSlots) {
        if (totalSlots < 0) throw new IllegalArgumentException("totalSlots must be >= 0");

        this.totalSlots = totalSlots;
        bookedSlots.removeIf(slot -> slot > totalSlots);
    }

    public double getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(double pricePerHour) {
        if (pricePerHour < 0) throw new IllegalArgumentException("pricePerHour must be >= 0");
        this.pricePerHour = pricePerHour;
    }


    public Set<Integer> getBookedSlots() {
        return Collections.unmodifiableSet(bookedSlots);
    }


    public int getAvailableSlotsCount() {
        return totalSlots - bookedSlots.size();
    }


    public List<Integer> getAvailableSlotIds() {
        return IntStream.rangeClosed(1, totalSlots)
                .filter(i -> !bookedSlots.contains(i))
                .boxed()
                .collect(Collectors.toList());
    }


    public boolean bookSlot(int slotId) {
        validateSlotId(slotId);
        if (bookedSlots.contains(slotId)) return false;
        return bookedSlots.add(slotId);
    }

    public boolean releaseSlot(int slotId) {
        validateSlotId(slotId);
        return bookedSlots.remove(slotId);
    }

    private void validateSlotId(int slotId) {
        if (slotId < 1 || slotId > totalSlots) {
            throw new IllegalArgumentException("slotId must be between 1 and totalSlots");
        }
    }

    public abstract String getGameCategory();

    public abstract double calculateFinalPrice(int hours);


    public static <T extends Game> List<T> findAvailableGames(List<T> games) {
        return games.stream()
                .filter(g -> g != null && g.getAvailableSlotsCount() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("Game{id='%s', name='%s', category='%s', pricePerHour=%.2f, totalSlots=%d, booked=%d, available=%d}",
                id, name, getGameCategory(), pricePerHour, totalSlots, bookedSlots.size(), getAvailableSlotsCount());
    }
}

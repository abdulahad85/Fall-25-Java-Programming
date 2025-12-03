

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericRepositry<T> {

    protected final List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public void remove(T item) {
        data.remove(item);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(data);
    }

    public List<T> find(Predicate<T> filter) {
        return data.stream().filter(filter).collect(Collectors.toList());
    }

    public Optional<T> findOne(Predicate<T> filter) {
        return data.stream().filter(filter).findFirst();
    }
}

package com.p4square.ccbapi.model;

import java.util.*;

/**
 * A collection of CustomField derivatives with indexes to find a custom field and value by either name or label.
 *
 * This collection will only ever contain one value for any given name or label.
 */
public class CustomFieldCollection<T extends CustomField> implements Collection<T> {

    private final List<T> values;
    private final Map<String, T> fieldLabelToValue;
    private final Map<String, T> fieldNameToValue;

    public CustomFieldCollection() {
        this.values = new ArrayList<>();
        this.fieldLabelToValue = new HashMap<>();
        this.fieldNameToValue = new HashMap<>();
    }

    /**
     * Return the entry with given name (e.g. "udf_text_1").
     *
     * @param name A CCB field name.
     * @return The entry associated with the field.
     */
    public T getByName(final String name) {
        return fieldNameToValue.get(name.toLowerCase());
    }

    /**
     * Return the entry with given label (e.g. "Favorite Book").
     *
     * @param label A CCB field label.
     * @return The entry associated with the field.
     */
    public T getByLabel(final String label) {
        return fieldLabelToValue.get(label.toLowerCase());
    }

    public List<T> asList() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return values.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return values.iterator();
    }

    @Override
    public Object[] toArray() {
        return values.toArray();
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        return values.toArray(a);
    }

    @Override
    public boolean add(final T t) {
        // Clean up overwritten indexes.
        final T previousValueByName = fieldNameToValue.get(t.getName().toLowerCase());
        if (previousValueByName != null) {
            remove(previousValueByName);
        }

        final T previousValueByLabel = fieldLabelToValue.get(t.getLabel().toLowerCase());
        if (previousValueByLabel != null) {
            remove(previousValueByLabel);
        }

        fieldNameToValue.put(t.getName().toLowerCase(), t);
        fieldLabelToValue.put(t.getLabel().toLowerCase(), t);
        return values.add(t);
    }

    @Override
    public boolean remove(final Object o) {
        if (values.remove(o)) {
            final T entry = (T) o;
            fieldNameToValue.remove(entry.getName().toLowerCase());
            fieldLabelToValue.remove(entry.getLabel().toLowerCase());
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return values.containsAll(c);
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        boolean result = false;
        for (T obj : c) {
            result |= add(obj);
        }
        return result;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        boolean result = false;
        for (Object obj : c) {
            result |= remove(obj);
        }
        return result;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        fieldNameToValue.clear();
        fieldLabelToValue.clear();
        values.clear();
    }
}

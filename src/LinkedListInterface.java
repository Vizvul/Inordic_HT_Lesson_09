public interface LinkedListInterface<T> {

    int size();
    void add(T value);
    void add(T value, int position);
    void replace(T value, int position);
    void removeByIndex(int position);
    boolean removeFirstByValue(T value);
    boolean contains(T value);
    T get(int position);
    int getPosition(T value);

}

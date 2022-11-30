public class SingleLinkedListGeneric<T> implements LinkedListInterface<T> {
    LinkedListGeneric<T> start;
    LinkedListGeneric<T> next;

    public int size = 0;

    public SingleLinkedListGeneric() {
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void add(T value) {
        LinkedListGeneric<T> addNewValue = new LinkedListGeneric(value);
        addNewValue.setPositionLink(null);
        if (start == null) {
            start = addNewValue;
        } else {
            next.setPositionLink(addNewValue);
        }
        next = addNewValue;
        size++;
    }

    @Override
    public void add(T value, int position) {
        add(value);
        LinkedListGeneric<T> addNewPozition = start;
        T nextValue = null;

        if (size() <= position) {
            return;
        }
        int i = 0;
        while (addNewPozition != null) {
            i++;
            if (i > position) {
                value = addNewPozition.getValue();
                addNewPozition.setValue(nextValue);
                position = i + 1;
            } else if (i == position) {
                nextValue = addNewPozition.getValue();
                addNewPozition.setValue(value);
            }
            addNewPozition = addNewPozition.getPositionLink();
        }
    }

    @Override
    public void replace(T value, int position) {
        int posToDelete = getPosition(value);
        if (position == posToDelete) { return; }
        removeByIndex(posToDelete);
        add(value, position);
    }

    @Override
    public int getPosition(T value) {
        LinkedListGeneric<T> getPosition = start;
        int k = 0;
        do {
            k++;
        if (getPosition.getValue() == value) { return k;}
        getPosition = getPosition.getPositionLink();
    } while (getPosition != null);
        return k;
    }

    @Override
    public void removeByIndex(int position) {
        LinkedListGeneric<T> removeByIndex = start;
        LinkedListGeneric<T> back = null;
        int j = 0;

        while (removeByIndex.getPositionLink() != null) {
            j++;
            if (j == position) {
                back.setPositionLink(removeByIndex.getPositionLink());
                size--;
            }
            back = removeByIndex;
            removeByIndex = removeByIndex.getPositionLink();
        }
    }

    @Override
    public boolean removeFirstByValue(T value) {
        if (getPosition(value) >= 0 ) {
            removeByIndex(getPosition(value));
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        LinkedListGeneric<T> contains = start;
        while (contains != null) {
            if (contains.getValue() == value) {
                return true;
            } else {
                contains = contains.getPositionLink();
            }
        }
        return false;
    }

    @Override
    public T get(int position) {
        LinkedListGeneric getNewPozition = start;
        int t = 0;
        while (getNewPozition != null) {
            t++;
            if (t == position) {
                return (T) getNewPozition.getValue();
            } else {
                getNewPozition = getNewPozition.getPositionLink();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinkedListGeneric<T> test = start;
        int j = 0;
        while (test != null ) {
            j++;
            result.append(j + " element = " + test.getPositionLink() + " - " + test.getValue() + '\n');
            test = test.getPositionLink();
        }
        return result.toString();
    }
}

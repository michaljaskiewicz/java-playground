package customlist;

import java.util.Optional;

public class CustomList {

    private Element firstElement = null;
    int size = 0;

    public void add(int number) {
        if (firstElement == null) {
            firstElement = new Element(number);
        } else {
            getLastElement().setNextElement(new Element(number));
        }
        size++;
    }

    private Element getLastElement() {
        Element lastElement = firstElement;
        while (lastElement.hasNext()) {
            lastElement = lastElement.getNextElement();
        }
        return lastElement;
    }

    public int size() {
        return size;
    }

    public Optional<Integer> removeFIFO() {
        if (firstElement == null) {
            return Optional.empty();
        }
        Element elementToRemove = firstElement;
        firstElement = firstElement.nextElement;
        size--;
        return Optional.of(elementToRemove.getValue());
    }

    public int[] getAllInOrderFIFO() {
        int[] elements = new int[size];
        Element nextElement = firstElement;
        for (int i = 0; i < size; i++) {
            elements[i] = nextElement.value;
            nextElement = nextElement.nextElement;
        }
        return elements;
    }

    private static class Element {
        int value;
        Element nextElement;

        public Element(int value) {
            this.value = value;
        }

        public void setNextElement(Element nextElement) {
            this.nextElement = nextElement;
        }

        public Element getNextElement() {
            return nextElement;
        }

        public int getValue() {
            return value;
        }

        public boolean hasNext() {
            return nextElement != null;
        }
    }

}

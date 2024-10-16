package myClasses.TripletDeque;

import java.util.*;


public class TripletDeque<T> implements Deque<T>, Containerable {


    private int maxSize;
    private int size = 0;
    private Container<T> first;
    private Container<T> last;

    private boolean isNotFull(){
        return this.size < this.maxSize;
    }
    private void addLastCont(){
        if(!isNotFull()) return;

        Container<T> newLastCont = new Container<>(this.last.getIndex() + 1);
        this.size++;
        this.last.setRight(newLastCont);
        newLastCont.setLeft(this.last);
        this.last = newLastCont;
    }
    private void addFirstCont(){
        if (!this.isNotFull()) return;
        Container<T> newFirstCont = new Container<>(this.first.getIndex() - 1);
        this.size++;
        this.first.setLeft(newFirstCont);
        newFirstCont.setRight(this.first);
        this.first = newFirstCont;
        this.reIndex();
    }
    private void delFirstCont(){
        if (!this.first.isEmpty()) return;

        Container <T> oldFirst = this.first;
        this.first = this.first.getRight();
        size--;
        this.first.deleteLeft();
        oldFirst.delete();
        this.reIndex();
    }
    private void delLastCont(){
        if (!this.last.isEmpty()) return;

        Container <T> oldLast = this.last;
        this.last = this.last.getLeft();
        size--;
        this.last.deleteRight();
        oldLast.delete();
    }
    private void reIndex(){
        Container<T> current = this.last;
        for (int i = size - 1; i >= 0; i--){
            current.setIndex(i);
            current = current.getLeft();
        }
    }
    private void delFirst(){
        this.first.delBeginElem();
        if (this.size == 1) return;
        this.delFirstCont();

    }
    private void delLast(){
        this.last.delLastElem();
        if (this.size == 1) return;
        this.delLastCont();
    }

    public TripletDeque (int maxSize) {
        this.maxSize = maxSize;
        this.first = new Container<T>(0);
        this.last = this.first;
        this.size++;
    }
    public TripletDeque () {
        this.maxSize = 1000;
        this.first = new Container<T>(0);
        this.last = this.first;
        this.size++;
    }

    @Override
    public void addFirst(T t) {
        this.offerFirst(t);
    }

    @Override
    public void addLast(T t) {
        this.offerLast(t);
    }

    @Override
    public boolean offerFirst(T t) {
        if (t == null) throw new NullPointerException("Введеный элемент пуст");
        if (!this.isNotFull()) return false;
        if (!this.first.isNotFullBegin()){
            this.addFirstCont();
        }
        this.first.setBeginElement(t);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        if (t == null) throw new NullPointerException("Введеный элемент пуст");
        if (!this.isNotFull()) return false;
        if (!this.last.isNotFullLast()){
            this.addLastCont();
        }
        this.last.setLastElement(t);
        return true;
    }

    @Override
    public T removeFirst() {
        T elem = this.pollFirst();
        if (elem == null) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return elem;
    }

    @Override
    public T removeLast() {
        T elem = this.pollLast();
        if (elem == null) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return elem;
    }

    @Override
    public T pollFirst() {
        if (this.isEmpty()) return null;
        T element = this.peekFirst();
        this.delFirst();
        return element;
    }

    @Override
    public T pollLast() {
        if (this.isEmpty()) return null;
        T element = this.peekLast();
        this.delLast();
        return element;
    }

    @Override
    public T getFirst() {
        if (this.isEmpty()) throw new NoSuchElementException("Очередь пуста");
        return this.first.getBeginElement();
    }

    @Override
    public T getLast() {
        if (this.isEmpty()) throw new NoSuchElementException("Очередь пуста");
        return this.last.getLastElement();
    }

    @Override
    public T peekFirst() {
        if (this.isEmpty()) return null;
        return this.first.getBeginElement();
    }

    @Override
    public T peekLast() {
        if (this.isEmpty()) return null;
        return this.last.getLastElement();
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (!this.contains(o)) return false;
        ArrayList<T> list = new ArrayList<>();
        Container<T> current = this.first;
        boolean flag = true;
        int cursor = 0;

        for (int i = 0; i < this.size; i++) {
            T[] elem = current.getValues();
            for (int j = 0; j < current.getVolume(); j++){
                if (elem[j] == null) continue;
                if (flag && elem[j].equals(o)) {
                    elem[j] = null;
                    flag = false;
                    continue;
                }
                if (!flag) {
                    list.add(elem[j]);
                    elem[j] = null;
                }
            }
            current = current.getRight();
        }

        current = this.first;
        for (int i = 0; i < this.size; i++) {
            while (current.isNotFullLast() && cursor < list.size()){
                current.setLastElement(list.get(cursor));
                cursor++;
            }
            current = current.getRight();
        }
        this.delLastCont();
        return true;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        if (!this.contains(o)) return false;
        ArrayList<T> list = new ArrayList<>();
        Container<T> current = this.last;
        boolean flag = true;


        for (int i = this.size - 1; i >= 0; i--) {
            T[] elem = current.getValues();
            for (int j = current.getVolume() - 1; j >= 0 ; j--){
                if (elem[j] == null) continue;
                if (flag && elem[j].equals(o)) {
                    elem[j] = null;
                    flag = false;
                    continue;
                }
                if (!flag) {
                    list.add(elem[j]);
                    elem[j] = null;
                }
            }
            current = current.getLeft();
        }

        int cursor = 0;
        current = this.last;
        for (int i = this.size -1; i >= 0; i--) {
            while (current.isNotFullBegin() && cursor < list.size()){
                current.setBeginElement(list.get(cursor));
                cursor++;
            }
            current = current.getLeft();
        }
        this.delFirstCont();
        return true;
    }

    @Override
    public boolean add(T t) {
        return this.offer(t);
    }

    @Override
    public boolean offer(T t) {
        return this.offerLast(t);
    }

    @Override
    public T remove() {
        return this.removeFirst();
    }

    @Override
    public T poll() {
        return this.pollFirst();
    }

    @Override
    public T element() {
        if (this.isEmpty()){
            throw new NoSuchElementException("Очередь пуста");
        }
        return this.peek();
    }

    @Override
    public T peek() {
        return this.peekFirst();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] arr = c.toArray();
        for (Object o : arr){
            this.add((T) o);
        }
        return true;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.last = null;
        this.first = null;

    }

    @Override
    public void push(T t) {
        this.addFirst(t);
    }

    @Override
    public T pop() {
        return this.removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        return this.removeFirstOccurrence(o);
    }

    @Override
    public boolean contains(Object o) {
        Container <T> current = this.first;
        for (int i = 0; i < this.size; i++){
            if (current.contains(o)) return true;
            current = current.getRight();
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size < 1 || (this.size == 1 && this.first.isEmpty());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            T[] els = (T[]) toArray();
            int cursor = -1;
            @Override
            public boolean hasNext() {
                if (cursor + 1 == els.length) return false;
                return (els[cursor + 1] != null);
            }

            @Override
            public T next() {
                cursor++;
                if (els[cursor] == null) throw new NoSuchElementException();
                return els[cursor];
            }
        };
    }

    @Override
    public Object[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        Container<T> current = this.first;
        for (int i = 0; i < this.size; i++) {
            T[] elem = current.getValues();
            for (int j = 0; j < current.getVolume(); j++){
                list.add(elem[j]);
            }
            current = current.getRight();
            if (current == null) continue;
        }
        Object[] arr = new Object[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    @Override
    public Object[] getContainerByIndex(int cIndex) {
        Container<T> current = this.first;
        for (int i = 0; i < size; i++){
            int index = current.getIndex();
            if (index == cIndex) {
                return current.getValues();
            }
            current = current.getRight();
        }
        return null;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) throw new NullPointerException("Может добавить сначала элементы?..");
        StringBuilder stringDeq = new StringBuilder();
        for (int i = 0; i < size; i ++){
            stringDeq.append(Arrays.toString(this.getContainerByIndex(i)));
            if (i != this.size - 1) stringDeq.append(" <-> ");
        }
        return stringDeq.toString();
    }

    // --------------------------------------------------------------------------------------------

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not realized!");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not realized!");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Not realized!");
    }

    @Override
    public Iterator<T> descendingIterator() {
        throw new UnsupportedOperationException("Not realized!");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not realized!");
    }

}

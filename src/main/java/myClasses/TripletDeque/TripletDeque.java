package myClasses.TripletDeque;

import java.util.*;


public class TripletDeque<T> implements Deque<T>, Containerable {


    private int size;
    private int fulledSize = 0;
    private Container<T> first;
    private Container<T> last;

    private boolean isNotFull(){
        return this.fulledSize < this.size;
    }
    private void addLastCont(){
        if(!isNotFull()) return;

        Container<T> newLastCont = new Container<>(this.last.getIndex() + 1);
        this.fulledSize++;
        this.last.setRight(newLastCont);
        newLastCont.setLeft(this.last);
        this.last = newLastCont;
    }
    private void addFirstCont(){
        if (!this.isNotFull()) return;
        Container<T> newFirstCont = new Container<>(this.first.getIndex() - 1);
        this.fulledSize++;
        this.first.setLeft(newFirstCont);
        newFirstCont.setRight(this.first);
        this.first = newFirstCont;
        this.reIndex();
    }
    private void delFirstCont(){
        Container <T> oldFirst = this.first;
        this.first = this.first.getRight();
        fulledSize--;
        this.first.deleteLeft();
        oldFirst.delete();
        this.reIndex();
    }
    private void delLastCont(){
        Container <T> oldLast = this.last;
        this.last = this.last.getLeft();
        fulledSize--;
        this.last.deleteRight();
        oldLast.delete();
    }
    private void reIndex(){
        Container<T> current = this.last;
        for (int i = fulledSize - 1; i >= 0; i--){
            current.setIndex(i);
            current = current.getLeft();
        }
    }
    private void delFirst(){
        this.first.delBeginElem();
        if (this.first.isEmpty()){
            this.delFirstCont();
        }
    }
    private void delLast(){
        this.first.delLastElem();
        if (this.last.isEmpty()){
            this.delLastCont();
        }
    }
    private Container<T> get1ContainerByIndex(int cIndex) {
        Container<T> current = this.first;
        for (int i = 0; i < fulledSize; i++){
            int index = current.getIndex();
            if (index == cIndex) {
                return current;
            }
            current = current.getRight();
        }
        return null;
    }


    public TripletDeque (int size) {
        this.size = size;
        this.first = new Container<T>(0);
        this.last = this.first;
        this.fulledSize++;
    }
    public TripletDeque () {
        this.size = 1000;
        this.first = new Container<T>(0);
        this.last = this.first;
        this.fulledSize++;
    }

    @Override
    public void addFirst(T t) {
        this.offerFirst(t);
    }

    @Override
    public void addLast(T t) {
        this.offer(t);
    }

    @Override
    public boolean offerFirst(T t) {
        if (!this.isNotFull()) return false;
        if (!this.first.isNotFullBegin()){
            this.addFirstCont();
        }
        this.first.setBeginElement(t);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        return this.offer(t);
    }

    @Override
    public T removeFirst() {
        if (this.pollFirst() == null) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return this.pollFirst();
    }

    @Override
    public T removeLast() {
        if (this.pollLast() == null) {
            throw new NoSuchElementException("Очередь пуста");
        }
        return this.pollLast();
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
        if (this.isEmpty()){
            throw new NoSuchElementException("Очередь пуста");
        }
        return this.peekFirst();
    }

    @Override
    public T getLast() {
        return this.element();
    }

    @Override
    public T peekFirst() {
        if (this.isEmpty()) return null;
        return this.peek();
    }

    @Override
    public T peekLast() {
        if (this.isEmpty()) return null;
        return (this.last.getLastElement());
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (!this.contains(o)) return false;
        ArrayList<T> list = new ArrayList<>();
        Container<T> current = this.first;
        boolean flag = true;
        for (int i = 0; i < this.fulledSize; i++) {
            T[] elem = current.getValues();
            for (int j = 0; j < current.getVolume(); j++){
                if (flag && elem[j].equals(0)) {
                    flag = false;
                    continue;
                }
                list.add(elem[j]);
            }
            current = current.getRight();
        }
        this.clear();
        for (T t : list) {
            if (t != null) {
                this.add(t);
            }
        }
        return true;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        if (!this.contains(o)) return false;
        ArrayList<T> list = new ArrayList<>();
        Container<T> current = this.last;
        boolean flag = true;
        for (int i = this.fulledSize - 1; i >= 0; i--) {
            T[] elem = current.getValues();
            for (int j = current.getVolume(); j >= 0 ; j--){
                if (flag && elem[j].equals(0)) {
                    flag = false;
                    continue;
                }
                list.add(elem[j]);
            }
            current = current.getLeft();
        }
        this.clear();
        for (T t : list) {
            if (t != null) {
                this.addFirst(t);
            }
        }
        return true;
    }

    @Override
    public boolean add(T t) {

        if (this.last.isNotFullLast()){
            this.last.setLastElement(t);
            return true;
        } else {
            if (!this.isNotFull()) return false;
            this.addLastCont();
            this.last.setLastElement(t);
            return true;
        }
    }

    @Override
    public boolean offer(T t) {
        return this.add(t);
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
        if (this.isEmpty()) return null;
        return this.first.getBeginElement();
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
        this.fulledSize = 0;
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
        for (int i = 0; i < this.fulledSize; i++){
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
        return this.fulledSize < 1 || (this.fulledSize == 1 && this.first.isEmpty());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            T[] els = (T[]) toArray();
            int cursor = -1;
            @Override
            public boolean hasNext() {
                return (els[cursor + 1] != null);
            }

            @Override
            public T next() {
                cursor++;
                return els[cursor];
            }
        };
    }
// --------------------------------------------------------------------------------------------
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not realized!");
    }

    @Override
    public Object[] toArray() {
        ArrayList<T> list = new ArrayList<>();
        Container<T> current = this.first;
        for (int i = 0; i < this.fulledSize; i++) {
            T[] elem = current.getValues();
            for (int j = 0; j < current.getVolume(); j++){
               list.add(elem[j]);
            }
            current = current.getRight();
        }
        Object[] arr = new Object[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
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

    @Override
    public Object[] getContainerByIndex(int cIndex) {
        Container<T> current = this.first;
        for (int i = 0; i < fulledSize; i++){
            int index = current.getIndex();
            if (index == cIndex) {
                return current.getValues();
            }
            current = current.getRight();
        }
        return null;
    }

}

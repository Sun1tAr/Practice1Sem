package myClasses.TripletDeque;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private boolean addFirstCont(){
        if (!this.isNotFull()) return false;
        Container<T> newFirstCont = new Container<>(this.first.getIndex() - 1);
        this.fulledSize++;
        this.first.setLeft(newFirstCont);
        newFirstCont.setRight(this.first);
        this.first = newFirstCont;
        this.reIndex();
        return true;
    }
    private void reIndex(){
        Container<T> current = this.last;
        for (int i = fulledSize - 1; i >= 0; i--){
            current.setIndex(i);
            current = current.getLeft();
        }
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

    }

    @Override
    public void addLast(T t) {
        this.offer(t);
    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return this.offer(t);
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return this.element();
    }

    @Override
    public T peekFirst() {
        return this.peek();
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
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
        return null;
    }

    @Override
    public T poll() {
        return null;
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
        return this.first.getBeginElement();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
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
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
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

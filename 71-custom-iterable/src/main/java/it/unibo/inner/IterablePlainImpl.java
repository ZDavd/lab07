package it.unibo.inner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterablePlainImpl<T> implements IterableWithPolicy<T>{

    final private T[] array;
    private Predicate<T> predicate;

    public IterablePlainImpl(T[] array){
        this(array, new Predicate<T>() {

            @Override
            public boolean test(T elem) {
                return true;
            }
            
        });
    }
    public IterablePlainImpl(T[] array, Predicate<T> filter){
        this.array = array;
        setIterationPolicy(filter);
    }

    @Override
    public Iterator<T> iterator() {
        return new PlainIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.predicate = filter;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    class PlainIterator implements Iterator<T> {
        int index;

        public PlainIterator(){
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < array.length; i++) {
                if (predicate.test(array[i])) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements available");
            }

            while(!predicate.test(array[index])){
                index += 1;
            }

            T elem = array[index];
            index += 1;
            return elem;
        }
        
    }

}

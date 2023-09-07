package csci2320;

public class ArraySeq<E> implements Seq<E> {
    private int numElems = 0;
    @SuppressWarnings("unchecked")
    private E[] data = (E[]) new Object[10];

    @Override
    public E get(int index) {
        if (index < 0 || index > numElems)
          throw new IndexOutOfBoundsException("Insert out of bounds at " + index + " of " + numElems);
        return data[index];
    }


    @Override
    public void set(int index, E elem){
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }


    @Override
    public void add(E elem) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }


    @Override
    public void insert(int index, E elem) {
        if (index < 0 || index > numElems)
          throw new IndexOutOfBoundsException("Insert out of bounds at " + index + " of " + numElems);
        if(numElems >= data.length) {
            @SuppressWarnings("unchecked")
            E[] tmp = (E[]) new Object[data.length * 2];
            for (int i = 0; i < data.length; ++i) {
                tmp[i] = data[i];
            }
            data = tmp;
        }
        for (int i = numElems; i > index; --i) {
            data[i] = data[i-1];
        }
        data[index] = elem;
        numElems++;
    }


    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }


    @Override
    public int size() {
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }


    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
    
}

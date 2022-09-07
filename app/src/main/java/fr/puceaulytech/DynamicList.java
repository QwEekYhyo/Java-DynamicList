package fr.puceaulytech;

import java.util.Arrays;

public class DynamicList {
    private int capacity;
    private int size;
    private int[] list;

    public DynamicList() {this(5);}

    public DynamicList(int capac) {
        this.capacity = capac;
        this.size = 0;
        this.list = new int[this.capacity];
    }

    private void ensure(boolean back) {
        if (this.size >= this.capacity) {
            int[] n = new int[this.capacity+1];
            for (int i = 0; i<this.size; i++) {
                if (back) {n[i+1] = this.list[i];}
                else {n[i] = this.list[i];}
            }
            this.list = n;
            this.capacity++;
        }
    }

    public void append(int x) {
        this.ensure(false);
        this.list[this.size] = x;
        this.size++;
    }

    public void pushback(int x) {
        this.ensure(true);
        if (this.capacity != 0 && this.list[0] != 0) {
            int[] n = new int[this.capacity];
            for (int i = 0; i<this.size; i++) {n[i+1] = this.list[i];}
            this.list = n;
        }
        this.list[0] = x;
        this.size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.list);
    }
}

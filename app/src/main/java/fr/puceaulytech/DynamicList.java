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

    private void ensure() {
        if (this.size >= this.capacity) {
            int[] n = new int[this.capacity+1];
            for (int i = 0; i<this.size; i++) {n[i] = this.list[i];}
            this.list = n;
            this.capacity++;
        }
    }

    public void append(int x) {
        this.ensure();
        this.list[this.size] = x;
        this.size++;
    }

    public void insert(int x, int index) {
        if (this.capacity <= this.size) {
            int[] n = new int[this.capacity+1];
            for (int i = 0; i<index; i++) {n[i] = this.list[i];}
            for (int i = index+1; i<=this.size; i++) {n[i] = this.list[i-1];}
            this.list = n;
            this.capacity++;
        }
        this.list[index] = x;
        this.size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.list);
    }

    private static void shiftDown(int[] list, int node, int index) {
        int k = node;
        int j = 2 * k;
        while (j <= index) {
            if (j < index && list[j] < list[j+1]) {j++;}
            if (list[k] < list[j]) {
                int temp = list[k];
                list[k] = list[j];
                list[j] = temp;
                k = j;
                j = 2 * k;
            }
            else {j = index + 1;}
        }
    }

    public void sort() {
        int length = this.capacity - 1;
        for (int i = length/2; i>=0; i--) {shiftDown(this.list, i, length);}
        for (int i = length; i>=1; i--) {
            int temp = this.list[i];
            this.list[i] = this.list[0];
            this.list[0] = temp;
            shiftDown(this.list, 0, i-1);
        }
    }
}

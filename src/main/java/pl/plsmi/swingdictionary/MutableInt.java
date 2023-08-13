package pl.plsmi.swingdictionary;

class MutableInt {
    int value;

    MutableInt() {
        this.value = 0;
    }

    MutableInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
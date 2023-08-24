package pl.plsmi.swingdictionary;

public class DictionaryEntry implements Comparable<DictionaryEntry>{
    public String word;
    public String definition;

    DictionaryEntry(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    @Override
    public int compareTo(DictionaryEntry otherDictionaryEntry) {
        return this.word.compareTo(otherDictionaryEntry.word);
    }

    public String toString() {
        return this.word;
    }

}

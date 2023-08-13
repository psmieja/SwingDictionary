package pl.plsmi.swingdictionary;

public class DictionaryEntry {
    public String word;
    public String definition;

    DictionaryEntry(String word, String definition)  {
        this.word = word;
        this.definition = definition;
    }

    public String toString() {
        return this.word;
    }
}



public abstract class DocumentFactory {

    // The factory method â€” subclasses decide which concrete class to instantiate
    public abstract Document createDocument();

    // Template-style method that uses the factory method
    public Document openNewDocument() {
        Document doc = createDocument();
        doc.open();
        return doc;
    }
}

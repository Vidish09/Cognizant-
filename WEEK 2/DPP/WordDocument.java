

public class WordDocument extends Document {
    @Override
    public void open() {
        System.out.println("Opening Word document (.docx)...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document.");
    }
}

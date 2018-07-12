//
//  Android PDF Writer
//  http://coderesearchlabs.com/androidpdfwriter
//
//  by Javier Santo Domingo (j-a-s-d@coderesearchlabs.com)
//

package crl.android.pdfwriter;

public class IndirectObject extends Base {

    private EnclosedContent mContent;
    private Dictionary mDictionaryContent;
    private Stream mStreamContent;
    private IndirectIdentifier mID;
    private int mByteOffset;
    private boolean mInUse;

    public IndirectObject() {
        clear();
    }

    public int getNumberID() {
        return mID.getNumber();
    }

    public void setNumberID(int Value) {
        mID.setNumber(Value);
    }

    public int getGeneration() {
        return mID.getGeneration();
    }

    public void setGeneration(int Value) {
        mID.setGeneration(Value);
    }

    public String getIndirectReference() {
        return mID.toPDFString() + " R";
    }

    public int getByteOffset() {
        return mByteOffset;
    }

    public void setByteOffset(int Value) {
        mByteOffset = Value;
    }

    public boolean getInUse() {
        return mInUse;
    }

    public void setInUse(boolean Value) {
        mInUse = Value;
    }

    public void addContent(String Value) {
        mContent.addContent(Value);
    }

    public String getContent() {
        return mContent.getContent();
    }

    public void setContent(String Value) {
        mContent.setContent(Value);
    }

    public void addDictionaryContent(String Value) {
        mDictionaryContent.addContent(Value);
    }

    public String getDictionaryContent() {
        return mDictionaryContent.getContent();
    }

    public void setDictionaryContent(String Value) {
        mDictionaryContent.setContent(Value);
    }

    public void addStreamContent(String Value) {
        mStreamContent.addContent(Value);
    }

    public String getStreamContent() {
        return mStreamContent.getContent();
    }

    public void setStreamContent(String Value) {
        mStreamContent.setContent(Value);
    }

    protected String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(mID.toPDFString());
        sb.append(" ");
        // j-a-s-d: this can be performed in inherited classes DictionaryObject and StreamObject
        if (mDictionaryContent.hasContent()) {
            mContent.setContent(mDictionaryContent.toPDFString());
            if (mStreamContent.hasContent())
                mContent.addContent(mStreamContent.toPDFString());
        }
        sb.append(mContent.toPDFString());
        return sb.toString();
    }

    @Override
    public void clear() {
        mID = new IndirectIdentifier();
        mByteOffset = 0;
        mInUse = false;
        mContent = new EnclosedContent();
        mContent.setBeginKeyword("obj", false, true);
        mContent.setEndKeyword("endobj", false, true);
        mDictionaryContent = new Dictionary();
        mStreamContent = new Stream();
    }

    @Override
    public String toPDFString() {
        return render();
    }

}

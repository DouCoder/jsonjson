package pack02;

import java.util.ArrayList;

public class JsonClass {
    public ArrayList<ArrayList<String>> relation;
    public String pageTitle;
    public String title;
    public String url;
    public boolean hasHeader;
    public String headerPosition;
    public String tableType;
    public int tableNum;
    public String s3Link;
    public int recordEndOffset;
    public int recordOffset;
    public String tableOrientation;
    public String TableContextTimeStampBeforeTable;
    public String TableContextTimeStampAfterTable;
    public String lastModified;
    public String textBeforeTable;
    public String textAfterTable;
    public boolean hasKeyColumn;
    public int keyColumnIndex;
    public int headerRowIndex;

    public ArrayList<ArrayList<String>> getRelation() {
        return relation;
    }

    public void setRelation(ArrayList<ArrayList<String>> relation) {
        this.relation = relation;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }

    public String getHeaderPosition() {
        return headerPosition;
    }

    public void setHeaderPosition(String headerPosition) {
        this.headerPosition = headerPosition;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public String getS3Link() {
        return s3Link;
    }

    public void setS3Link(String s3Link) {
        this.s3Link = s3Link;
    }

    public int getRecordEndOffset() {
        return recordEndOffset;
    }

    public void setRecordEndOffset(int recordEndOffset) {
        this.recordEndOffset = recordEndOffset;
    }

    public int getRecordOffset() {
        return recordOffset;
    }

    public void setRecordOffset(int recordOffset) {
        this.recordOffset = recordOffset;
    }

    public String getTableOrientation() {
        return tableOrientation;
    }

    public void setTableOrientation(String tableOrientation) {
        this.tableOrientation = tableOrientation;
    }

    public String getTableContextTimeStampBeforeTable() {
        return TableContextTimeStampBeforeTable;
    }

    public void setTableContextTimeStampBeforeTable(String tableContextTimeStampBeforeTable) {
        TableContextTimeStampBeforeTable = tableContextTimeStampBeforeTable;
    }

    public String getTableContextTimeStampAfterTable() {
        return TableContextTimeStampAfterTable;
    }

    public void setTableContextTimeStampAfterTable(String tableContextTimeStampAfterTable) {
        TableContextTimeStampAfterTable = tableContextTimeStampAfterTable;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getTextBeforeTable() {
        return textBeforeTable;
    }

    public void setTextBeforeTable(String textBeforeTable) {
        this.textBeforeTable = textBeforeTable;
    }

    public String getTextAfterTable() {
        return textAfterTable;
    }

    public void setTextAfterTable(String textAfterTable) {
        this.textAfterTable = textAfterTable;
    }

    public boolean isHasKeyColumn() {
        return hasKeyColumn;
    }

    public void setHasKeyColumn(boolean hasKeyColumn) {
        this.hasKeyColumn = hasKeyColumn;
    }

    public int getKeyColumnIndex() {
        return keyColumnIndex;
    }

    public void setKeyColumnIndex(int keyColumnIndex) {
        this.keyColumnIndex = keyColumnIndex;
    }

    public int getHeaderRowIndex() {
        return headerRowIndex;
    }

    public void setHeaderRowIndex(int headerRowIndex) {
        this.headerRowIndex = headerRowIndex;
    }

    @Override
    public String toString() {
        return "JsonClassWithoutFileName{" +
                "relation=" + relation +
                ", pageTitle='" + pageTitle + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", hasHeader=" + hasHeader +
                ", headerPosition='" + headerPosition + '\'' +
                ", tableType='" + tableType + '\'' +
                ", tableNum=" + tableNum +
                ", s3Link='" + s3Link + '\'' +
                ", recordEndOffset=" + recordEndOffset +
                ", recordOffset=" + recordOffset +
                ", tableOrientation='" + tableOrientation + '\'' +
                ", TableContextTimeStampBeforeTable='" + TableContextTimeStampBeforeTable + '\'' +
                ", TableContextTimeStampAfterTable='" + TableContextTimeStampAfterTable + '\'' +
                ", lastModified='" + lastModified + '\'' +
                ", textBeforeTable='" + textBeforeTable + '\'' +
                ", textAfterTable='" + textAfterTable + '\'' +
                ", hasKeyColumn=" + hasKeyColumn +
                ", keyColumnIndex=" + keyColumnIndex +
                ", headerRowIndex=" + headerRowIndex +
                '}';
    }
}

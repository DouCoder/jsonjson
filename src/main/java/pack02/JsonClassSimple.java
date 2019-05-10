package pack02;

import pack_relation.IsNumeric;
import pack_relation.StringProcess;

import java.util.ArrayList;
//其中的get方法已经对获取的pagetitle和
public class JsonClassSimple {
    public ArrayList<ArrayList<String>> relation;
    public String tableOrientation;
    public String pageTitle;

    public String getPageTitle() {
        pageTitle=StringProcess.stringProcess(pageTitle);
        if(pageTitle.length()>50){
            return pageTitle.substring(0,50);
        }else if(IsNumeric.isNumeric(pageTitle)) {
            return pageTitle+"_";
        }else {
            return pageTitle;
        }
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public ArrayList<ArrayList<String>> getRelation() {
        ArrayList<ArrayList<String>> newrelation=new ArrayList<ArrayList<String>>();
        for (int i = 0; i < relation.size(); i++) {
            ArrayList<String> arow=new ArrayList<String>();
            for (int j = 0; j < relation.get(0).size(); j++) {
                arow.add(StringProcess.stringProcess(relation.get(i).get(j)));
            }
            newrelation.add(arow);
        }
        return newrelation;
    }

    public void setRelation(ArrayList<ArrayList<String>> relation) {
        this.relation = relation;
    }

    public String getTableOrientation() {
        return tableOrientation;
    }

    public void setTableOrientation(String tableOrientation) {
        this.tableOrientation = tableOrientation;
    }
}

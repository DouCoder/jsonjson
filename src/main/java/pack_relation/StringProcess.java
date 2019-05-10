package pack_relation;

import java.util.ArrayList;

public class StringProcess {

    public static ArrayList<String> someDisgustingAttName=new ArrayList<String>(); //专门存一些比较奇葩的列名，遇到这种列名，需要给他加个后缀
    static {
        someDisgustingAttName.add("int");
        someDisgustingAttName.add("final");
        someDisgustingAttName.add("index");
        someDisgustingAttName.add("change");
        someDisgustingAttName.add("dec");
        someDisgustingAttName.add("to");
        someDisgustingAttName.add("as");
        someDisgustingAttName.add("by");
        someDisgustingAttName.add("on");
        someDisgustingAttName.add("add"  );
        someDisgustingAttName.add("analyze "  );
        someDisgustingAttName.add("asc"  );
        someDisgustingAttName.add("add");
        someDisgustingAttName.add("analyze");
        someDisgustingAttName.add("asc");
        someDisgustingAttName.add("between");
        someDisgustingAttName.add("blob");
        someDisgustingAttName.add("call");
        someDisgustingAttName.add("change");
        someDisgustingAttName.add("check");
        someDisgustingAttName.add("condition");
        someDisgustingAttName.add("continue");
        someDisgustingAttName.add("cross");
        someDisgustingAttName.add("current_timestamp");
        someDisgustingAttName.add("database");
        someDisgustingAttName.add("day_microsecond");
        someDisgustingAttName.add("dec");
        someDisgustingAttName.add("default");
        someDisgustingAttName.add("desc");
        someDisgustingAttName.add("distinct");
        someDisgustingAttName.add("double");
        someDisgustingAttName.add("each");
        someDisgustingAttName.add("enclosed");
        someDisgustingAttName.add("exit");
        someDisgustingAttName.add("fetch");
        someDisgustingAttName.add("float8");
        someDisgustingAttName.add("foreign");
        someDisgustingAttName.add("goto");
        someDisgustingAttName.add("having");
        someDisgustingAttName.add("hour_minute");
        someDisgustingAttName.add("ignore");
        someDisgustingAttName.add("infile");
        someDisgustingAttName.add("insensitive");
        someDisgustingAttName.add("int1");
        someDisgustingAttName.add("int4");
        someDisgustingAttName.add("interval");
        someDisgustingAttName.add("iterate");
        someDisgustingAttName.add("keys");
        someDisgustingAttName.add("leading");
        someDisgustingAttName.add("like");
        someDisgustingAttName.add("lines");
        someDisgustingAttName.add("localtimestamp");
        someDisgustingAttName.add("longblob");
        someDisgustingAttName.add("low_priority");
        someDisgustingAttName.add("mediumint");
        someDisgustingAttName.add("minute_microsecond");
        someDisgustingAttName.add("modifies");
        someDisgustingAttName.add("no_write_to_binlog");
        someDisgustingAttName.add("on");
        someDisgustingAttName.add("optionally");
        someDisgustingAttName.add("out");
        someDisgustingAttName.add("precision");
        someDisgustingAttName.add("purge");
        someDisgustingAttName.add("read");
        someDisgustingAttName.add("references");
        someDisgustingAttName.add("rename");
        someDisgustingAttName.add("require");
        someDisgustingAttName.add("revoke");
        someDisgustingAttName.add("schema");
        someDisgustingAttName.add("select");
        someDisgustingAttName.add("set");
        someDisgustingAttName.add("spatial");
        someDisgustingAttName.add("sqlexception");
        someDisgustingAttName.add("sql_big_result");
        someDisgustingAttName.add("ssl");
        someDisgustingAttName.add("table");
        someDisgustingAttName.add("tinyblob");
        someDisgustingAttName.add("to");
        someDisgustingAttName.add("true");
        someDisgustingAttName.add("unique");
        someDisgustingAttName.add("update");
        someDisgustingAttName.add("using");
        someDisgustingAttName.add("utc_timestamp");
        someDisgustingAttName.add("varchar");
        someDisgustingAttName.add("when");
        someDisgustingAttName.add("with");
        someDisgustingAttName.add("xor");
        someDisgustingAttName.add("all");
        someDisgustingAttName.add("and");
        someDisgustingAttName.add("asensitive");
        someDisgustingAttName.add("bigint");
        someDisgustingAttName.add("both");
        someDisgustingAttName.add("cascade");
        someDisgustingAttName.add("char");
        someDisgustingAttName.add("collate");
        someDisgustingAttName.add("connection");
        someDisgustingAttName.add("convert");
        someDisgustingAttName.add("current_date");
        someDisgustingAttName.add("current_user");
        someDisgustingAttName.add("databases");
        someDisgustingAttName.add("day_minute");
        someDisgustingAttName.add("decimal");
        someDisgustingAttName.add("delayed");
        someDisgustingAttName.add("describe");
        someDisgustingAttName.add("distinctrow");
        someDisgustingAttName.add("drop");
        someDisgustingAttName.add("else");
        someDisgustingAttName.add("escaped");
        someDisgustingAttName.add("explain");
        someDisgustingAttName.add("float");
        someDisgustingAttName.add("for");
        someDisgustingAttName.add("from");
        someDisgustingAttName.add("grant");
        someDisgustingAttName.add("high_priority");
        someDisgustingAttName.add("hour_second");
        someDisgustingAttName.add("in");
        someDisgustingAttName.add("inner");
        someDisgustingAttName.add("insert");
        someDisgustingAttName.add("int2");
        someDisgustingAttName.add("int8");
        someDisgustingAttName.add("into");
        someDisgustingAttName.add("join");
        someDisgustingAttName.add("kill");
        someDisgustingAttName.add("leave");
        someDisgustingAttName.add("limit");
        someDisgustingAttName.add("load");
        someDisgustingAttName.add("lock");
        someDisgustingAttName.add("longtext");
        someDisgustingAttName.add("match");
        someDisgustingAttName.add("mediumtext");
        someDisgustingAttName.add("minute_second");
        someDisgustingAttName.add("natural");
        someDisgustingAttName.add("null");
        someDisgustingAttName.add("optimize");
        someDisgustingAttName.add("or");
        someDisgustingAttName.add("outer");
        someDisgustingAttName.add("primary");
        someDisgustingAttName.add("raid0");
        someDisgustingAttName.add("reads");
        someDisgustingAttName.add("regexp");
        someDisgustingAttName.add("repeat");
        someDisgustingAttName.add("restrict");
        someDisgustingAttName.add("right");
        someDisgustingAttName.add("schemas");
        someDisgustingAttName.add("sensitive");
        someDisgustingAttName.add("show");
        someDisgustingAttName.add("specific");
        someDisgustingAttName.add("sqlstate");
        someDisgustingAttName.add("sql_calc_found_rows");
        someDisgustingAttName.add("starting");
        someDisgustingAttName.add("terminated");
        someDisgustingAttName.add("tinyint");
        someDisgustingAttName.add("trailing");
        someDisgustingAttName.add("undo");
        someDisgustingAttName.add("unlock");
        someDisgustingAttName.add("usage");
        someDisgustingAttName.add("utc_date");
        someDisgustingAttName.add("values");
        someDisgustingAttName.add("varcharacter");
        someDisgustingAttName.add("where");
        someDisgustingAttName.add("write");
        someDisgustingAttName.add("year_month");
        someDisgustingAttName.add("alter");
        someDisgustingAttName.add("as");
        someDisgustingAttName.add("before");
        someDisgustingAttName.add("binary");
        someDisgustingAttName.add("by");
        someDisgustingAttName.add("case");
        someDisgustingAttName.add("character");
        someDisgustingAttName.add("column");
        someDisgustingAttName.add("constraint");
        someDisgustingAttName.add("create");
        someDisgustingAttName.add("current_time");
        someDisgustingAttName.add("cursor");
        someDisgustingAttName.add("day_hour");
        someDisgustingAttName.add("day_second");
        someDisgustingAttName.add("declare");
        someDisgustingAttName.add("delete");
        someDisgustingAttName.add("deterministic");
        someDisgustingAttName.add("div");
        someDisgustingAttName.add("dual");
        someDisgustingAttName.add("elseif");
        someDisgustingAttName.add("exists");
        someDisgustingAttName.add("false");
        someDisgustingAttName.add("float4");
        someDisgustingAttName.add("force");
        someDisgustingAttName.add("fulltext");
        someDisgustingAttName.add("group");
        someDisgustingAttName.add("hour_microsecond");
        someDisgustingAttName.add("if");
        someDisgustingAttName.add("index");
        someDisgustingAttName.add("inout");
        someDisgustingAttName.add("int");
        someDisgustingAttName.add("int3");
        someDisgustingAttName.add("integer");
        someDisgustingAttName.add("is");
        someDisgustingAttName.add("key");
        someDisgustingAttName.add("label");
        someDisgustingAttName.add("left");
        someDisgustingAttName.add("linear");
        someDisgustingAttName.add("localtime");
        someDisgustingAttName.add("long");
        someDisgustingAttName.add("loop");
        someDisgustingAttName.add("mediumblob");
        someDisgustingAttName.add("middleint");
        someDisgustingAttName.add("mod");
        someDisgustingAttName.add("not");
        someDisgustingAttName.add("numeric");
        someDisgustingAttName.add("option");
        someDisgustingAttName.add("order");
        someDisgustingAttName.add("outfile");
        someDisgustingAttName.add("procedure");
        someDisgustingAttName.add("range");
        someDisgustingAttName.add("real");
        someDisgustingAttName.add("release");
        someDisgustingAttName.add("replace");
        someDisgustingAttName.add("return");
        someDisgustingAttName.add("rlike");
        someDisgustingAttName.add("second_microsecond");
        someDisgustingAttName.add("separator");
        someDisgustingAttName.add("smallint");
        someDisgustingAttName.add("sql");
        someDisgustingAttName.add("sqlwarning");
        someDisgustingAttName.add("sql_small_result");
        someDisgustingAttName.add("straight_join");
        someDisgustingAttName.add("then");
        someDisgustingAttName.add("tinytext");
        someDisgustingAttName.add("trigger");
        someDisgustingAttName.add("union");
        someDisgustingAttName.add("unsigned");
        someDisgustingAttName.add("use");
        someDisgustingAttName.add("utc_time");
        someDisgustingAttName.add("varbinary");
        someDisgustingAttName.add("varying");
        someDisgustingAttName.add("while");
        someDisgustingAttName.add("x509");
        someDisgustingAttName.add("zerofill");



    }

    public static String stringProcess(String s){//静态方法：只选其中的大小写数字，其他(包括空值)全改成下划线，大写改成小写
        String newString=new String();
        char[] chars=s.toCharArray();



        if(s.equals("")){
            return "_";
        }

        if(someDisgustingAttName.contains(s)){
            return s+"_";
        }

        for (char c:chars
             ) {
            if(c>='a'&&c<='z'){
                newString+=c;
            }else if (c>='A'&&c<='Z'){
                c= (char) (c+32);
                newString+=c;
            }else if (c>='0'&&c<='9'){
                newString+=c;
            }else if (c==' '){
                newString+='_';
            }else if(c=='\0'){
                newString+='_';
            }else{//其他字符全部替换为下划线(_是可以作为列名的)
                newString+='_';
            }
        }
        return newString;
    }

    public static String stringAddDoubleQuotes(String s){ //数据库insert字符串的时候需要加双引号！！！
        return "\""+s+"\"";
    }

    public static String attrRename(String s){//对于属性名为空，要给它一个自定义的名字_
        if(s.equals("")){
            return "_";
        }else {
            return s;
        }
    }
}

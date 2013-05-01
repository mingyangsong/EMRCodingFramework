package edu.cmu.lti.uima.rules.hieratical;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mapReader {
  String filePath = null;
  BufferedReader br = null;
  int numOfColum = 9;
  int numOfColumWhenInValid = 7;
  String excludeSnowMed = "445518008";
  mapReader(String path) throws IOException {
    filePath = path;
    br = new BufferedReader(new FileReader(filePath));
  }

  public static void main(String[] args) throws Exception{
    mapReader tmp = new mapReader("infile.txt");
    oneRowRule oneRow = new oneRowRule();
    while(tmp.readOneLine(oneRow)){};
      
    
  }
  boolean readOneLine(oneRowRule oneRow){
    String line;
    String[] fields = null;
    Pattern findIFA  = Pattern.compile("IFA ([0-9]*) \\| ([^//|]*) \\|");
    Pattern higherDayBound  = Pattern.compile("< ([.0-9]*) day");
    Pattern higherYearBound  = Pattern.compile("< ([.0-9]*) year");
    Pattern lowerDayBound  = Pattern.compile(">= ([.0-9]*) day");
    Pattern lowerYearBound  = Pattern.compile(">= ([.0-9]*) year");
    oneRow.extraleftside.clear();
    oneRow.extraleftDesc.clear();
    try {
      boolean goon = true;
      while(goon){
        line = br.readLine();
        if (line==null)
          return false;
        fields = line.split("\t");
        //System.out.println(fields.length);
        if(fields.length==numOfColum||fields.length==numOfColumWhenInValid)
          goon = false;
      }
      oneRow.ruleId = fields[0];
      oneRow.conceptId = fields[1];
      oneRow.conceptDesc = fields[2];
      oneRow.group = Integer.parseInt(fields[3]);
      oneRow.priority = Integer.parseInt(fields[4]);
      if(fields.length == this.numOfColum){
        oneRow.ruleDesc = fields[6];
        oneRow.rightside = fields[7];
        oneRow.rightDesc = fields[8];
      }else{
        oneRow.ruleDesc = fields[6];
        oneRow.rightside = "";
        oneRow.rightDesc = "";
      }

      Matcher matcher = findIFA.matcher(fields[5]);
      boolean needToFindTime = false;
      while(matcher.find()){        
        if(!matcher.group(1).equals(this.excludeSnowMed)){
          //System.out.println(matcher.group(1));
          //System.out.println(matcher.group(2));
          oneRow.extraleftside.add(matcher.group(1));
          oneRow.extraleftDesc.add(matcher.group(2));      
        }else{
          needToFindTime = true;
        }
      }
      if(needToFindTime){
        oneRow.onset = new period();
        matcher = higherDayBound.matcher(fields[5]);
        if(matcher.find()){
          oneRow.onset.higherBound = (int) Double.parseDouble(matcher.group(1));
        }else{
          matcher = higherYearBound.matcher(fields[5]);
          if(matcher.find()){
            oneRow.onset.higherBound = (int) (Double.parseDouble(matcher.group(1))*365);
          }
        }
        matcher = lowerDayBound.matcher(fields[5]);
        if(matcher.find()){
          oneRow.onset.lowerBound = (int) Double.parseDouble(matcher.group(1));
        }else{
          matcher = lowerYearBound.matcher(fields[5]);
          if(matcher.find()){
            oneRow.onset.lowerBound = (int) (Double.parseDouble(matcher.group(1))*365);
          }
        }
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    
    return true;
  }
}

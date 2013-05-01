package edu.cmu.lti.uima.tools;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import com.sun.tools.javac.util.List;

public class readTabFile {
	int numOfSnowMedOnLeftSide;
	Document dom;
	Element rootEle;
	public static void main(String[] args) throws Exception{
		readTabFile reading = new readTabFile();
		reading.read("tabfile.in",4);
        reading.finish("tabfile.xml");
	}
	  public readTabFile() throws Exception {
		    // instance of a DocumentBuilderFactory
		   
		  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    try {
		        // use factory to get an instance of document builder
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        // create instance of DOM
		        dom = db.newDocument();
		        // create the root element
		        rootEle = dom.createElement("rules");
		        // create data elements and place them under root

		    } catch (ParserConfigurationException pce) {
		        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
		    }
	  }
	  public void finish(String outputFile){
		  dom.appendChild(rootEle);
		  try {
	            Transformer tr = TransformerFactory.newInstance().newTransformer();
	            tr.setOutputProperty(OutputKeys.INDENT, "yes");
	            tr.setOutputProperty(OutputKeys.METHOD, "xml");
	            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	            tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

	            String xml = outputFile;
				// send DOM to file
	            tr.transform(new DOMSource(dom), 
	                                 new StreamResult(new FileOutputStream(xml )));
	        } catch (TransformerException te) {
	            System.out.println(te.getMessage());
	        } catch (IOException ioe) {
	            System.out.println(ioe.getMessage());
	        } 
	  }
	  public void read(String fileName,int lhsSnowMed) throws IOException{
		   numOfSnowMedOnLeftSide = lhsSnowMed;
		    BufferedReader br = new BufferedReader(new FileReader(fileName));
		    Pattern findIFA  = Pattern.compile("IFA ([0-9]*)");;
		    rule tmpRule = new rule();
		    int numOfRulespRrocessed = 0;
		    try {
		    	boolean end = false;
		    	while(!end){
			        String line = br.readLine();
			        if(line == null){
			        	end = true;
			        	continue;
			        }
			        String[] fields = line.split("\t");
			        if(fields.length!=3)
			        	continue;
			          
		        	tmpRule.snoMedCodes[0] = fields[0];
		        	tmpRule.snoMedDescs[0] = "null";
		        	tmpRule.ICD10Code = fields[2];
		        	tmpRule.ICD10Desc = "null";
		        	//tmpRule.priority = 1;
		        	Matcher matcher = findIFA.matcher(fields[1]);
		        	int numOfIFA = 0;
		        	ArrayList<String> snowCodes = new ArrayList<String>();
		        	while(matcher.find()){
		        		numOfIFA++;	
		        		snowCodes.add(matcher.group(1));
		        	}
			        if (numOfIFA!=(numOfSnowMedOnLeftSide-1))
			        	continue;
			        
			        for(int i=0;i<snowCodes.size();i++){		        		
				        	tmpRule.snoMedCodes[i+1] = snowCodes.get(i);
				        	tmpRule.snoMedDescs[i+1] = "null";				        	       	
			        }
			        numOfRulespRrocessed++;
			        addnew(tmpRule); 
		    	}
		    } finally {
		        br.close();
		    }
		    System.out.println(numOfRulespRrocessed+" rule processed.");
	  }
	  public void addnew(rule oneRule){
	        Element e = dom.createElement("rule");
	        Element lhs = dom.createElement("LHS");
	        Element snow;
	        for(int i=0;i<numOfSnowMedOnLeftSide;i++){
	        	snow = dom.createElement("SNOMEDCode");
		        snow.setAttribute("Descrption",oneRule.snoMedDescs[i]);
		        snow.setAttribute("ID", oneRule.snoMedCodes[i]);
		        lhs.appendChild(snow); 	
	        }
	        e.appendChild(lhs);
	        Element rhs = dom.createElement("RHS");
	        Element icd10 = dom.createElement("ICD10Code");
	        icd10.setAttribute("ID", oneRule.ICD10Code);
	        icd10.setAttribute("Descrption",oneRule.ICD10Desc);  
	        rhs.appendChild(icd10);
	        e.appendChild(rhs);
	        if(oneRule.priority!=-1)
	        	e.setAttribute("priority",String.valueOf(oneRule.priority));
	        //e.appendChild(dom.createTextNode(role1));
	        rootEle.appendChild(e);
	  }
	  
	  public class rule{
		  public  rule(){
			  snoMedCodes = new String[numOfSnowMedOnLeftSide];
			  snoMedDescs = new String[numOfSnowMedOnLeftSide];
			  priority = -1;
		  }
		  String[] snoMedCodes;
		  String[] snoMedDescs;
		  String ICD10Code;
		  String ICD10Desc;
		  int priority;
	  }
	  
	}




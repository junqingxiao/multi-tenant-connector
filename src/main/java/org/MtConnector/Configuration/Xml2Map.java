package org.MtConnector.Configuration;

/**
 * Created by mk on 16/3/9.
 * 将xml转化为HashMap
 */

import org.MtConnector.Log.MtLog;
import org.MtConnector.Exception.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public class Xml2Map
{
    //解析xml
    public HashMap parserXml(String fileName)
    {
        File inputXml=new File(fileName);
        SAXReader saxReader = new SAXReader();
        HashMap<String,String> returnMap=new HashMap<String, String>();
        try
        {
            Document document = saxReader.read(inputXml);
            Element employees=document.getRootElement();
            for(Iterator i = employees.elementIterator(); i.hasNext();)
            {
                Element node=(Element) i.next();
                //System.out.println(node.attributeValue("name"));
                returnMap.put(node.attributeValue("name"), node.getText());

            }
        }
        catch (DocumentException e)
        {
            if (e.getNestedException() instanceof java.io.FileNotFoundException)
            {
                new MtLog().error(e.getMessage());
                throw new InvalidCfgPathException("Could not resolve xml path",e);
            }
            else
            {
                new MtLog().error(e.getMessage());
                throw new MtException("org.MtConnector.Exception occurred in dom4j", e);
            }
        }
        return returnMap;
    }
}

package org.techbooster.sample.createxml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class CreateXMLActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
            Document document = dbuilder.newDocument();
            Element root = document.createElement("members");
        
            //要素を作成
       Element name = document.createElement("name");
            Text text = document.createTextNode("furusin");
            name.appendChild(text);
        
            Element twitterID = document.createElement("twitterID");
            text = document.createTextNode("@furusin_oriver");
            twitterID.appendChild(text);
        
            //各要素を親ノードへ追加
            root.appendChild(name);
            root.appendChild(twitterID);
            document.appendChild(root);
        
            TransformerFactory tffactory = TransformerFactory.newInstance();
            Transformer transformer = tffactory.newTransformer();
            String path = Environment.getExternalStorageDirectory().toString() + "/xml/";   //XML保存先ディレクトリ
            File dir = new File(path);
            if(!dir.exists()){
                dir.mkdir();
            }
            File file = new File(path + "sample.xml");
            if(!file.exists()){
                file.createNewFile();
            }
            transformer.transform(new DOMSource(document), new StreamResult(file));
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }
}
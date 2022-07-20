/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo;

import com.apicatalog.jsonld.JsonLd;
import com.apicatalog.jsonld.JsonLdError;
import com.apicatalog.jsonld.document.Document;
import com.apicatalog.jsonld.document.JsonDocument;
import com.apicatalog.jsonld.uri.UriResolver;
import com.apicatalog.rdf.RdfDataset;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.system.JenaTitanium;

/**
 *
 * @author erich
 */
public class Titanium2a {
    
    public static void main(String[] args) throws FileNotFoundException, JsonLdError {
        FileInputStream fos = new FileInputStream("demo3.jsonld");
        Document document = JsonDocument.of(fos);
        RdfDataset rdf = JsonLd.toRdf(document)
            .base("https://demo.com/")
            //.base("file:///D:/HalcyonStorage/demo2/coad_CM-5348/Ttumor_heatmap_TCGA-CM-5348-01Z-00-DX1.2ad0b8f6-684a-41a7-b568-26e97675cce9.zip/")
            .get();
        rdf.toList().forEach(q->{
            System.out.println("QUAD : "+q);
        });
        Model m = ModelFactory.createModelForGraph(JenaTitanium.convert(rdf).getDefaultGraph());
        RDFDataMgr.write(System.out, m, Lang.TTL);
        UriResolver ha;
    }
    
}

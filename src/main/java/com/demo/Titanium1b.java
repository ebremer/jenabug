/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo;

import com.apicatalog.jsonld.JsonLd;
import com.apicatalog.jsonld.JsonLdError;
import com.apicatalog.jsonld.document.Document;
import com.apicatalog.jsonld.document.JsonDocument;
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
public class Titanium1b {
    
    public static void main(String[] args) throws FileNotFoundException, JsonLdError {
        FileInputStream fos = new FileInputStream("demo.jsonld");
        Document document = JsonDocument.of(fos);
        RdfDataset rdf = JsonLd.toRdf(document)
            .base("https://demo.com/")
            .get();
        Model m = ModelFactory.createModelForGraph(JenaTitanium.convert(rdf).getDefaultGraph());
        RDFDataMgr.write(System.out, m, Lang.TTL);
    }
    
}

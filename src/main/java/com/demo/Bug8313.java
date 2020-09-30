package com.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFLanguages;
import org.apache.jena.riot.RDFParser;

/**
 *
 * @author erich
 */
public class Bug8313 {
    
    public static void main(String[] args) throws FileNotFoundException {
        Model m = ModelFactory.createDefaultModel();
        InputStream inputStream = new FileInputStream("demo.jsonld");
        RDFParser.create()
                .base("https://demo.com/")
                .source(inputStream)
                .lang(RDFLanguages.JSONLD)
                .parse(m);
        System.out.println("Number of triples : "+m.size());
        RDFDataMgr.write(System.out, m, Lang.TTL);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo;

import com.github.jsonldjava.core.JsonLdOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringWriter;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.JsonLDWriteContext;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFFormat;
import org.apache.jena.riot.RDFWriter;

/**
 *
 * @author erich
 */
public class JSONLDBUG {
    
    public static void main(String[] args) throws FileNotFoundException {
        Model m = ModelFactory.createDefaultModel();
        InputStream inputStream = new FileInputStream("demo.ttl");
        
        m.read(inputStream, "", "TTL");
        //m.write(System.out,"TTL");
        StringWriter out = new StringWriter();
        JsonLdOptions opts = new JsonLdOptions(null);
        opts.setCompactArrays(true);
        opts.setPruneBlankNodeIdentifiers(true);
        opts.setUseNativeTypes(Boolean.TRUE);
        JsonLDWriteContext ctx = new JsonLDWriteContext();        
        ctx.setOptions(opts);
        RDFWriter w =
            RDFWriter.create()
            .format(RDFFormat.JSONLD_COMPACT_PRETTY)
            .source(m)
            .context(ctx)
            .build();
        w.output(out);

        
        System.out.println(out.toString());
    }
    
}

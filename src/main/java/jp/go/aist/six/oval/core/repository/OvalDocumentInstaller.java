package jp.go.aist.six.oval.core.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalRepository;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.xml.XmlMapper;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDocumentInstaller
{

    public static void main(
                    final String[] args
                    )
    throws Exception
    {
        final OvalDocumentInstaller  ovaldi = new OvalDocumentInstaller();
        ovaldi.execute( args );
    }



    private final PrintStream  _msg_stream = System.out;

    private final MongoOvalRepository  _oval_repository;
    private final XmlMapper  _xml_mapper;



    /**
     */
    public OvalDocumentInstaller()
    throws Exception
    {
        OvalContext  context = OvalContext.getServerInstance();
        _oval_repository = context.getBean( MongoOvalRepository.class );
        _xml_mapper = context.getXmlMapper();
    }



    /**
     *
     * @throws Exception
     */
    public void execute(
                    final String[] documents
                    )
    throws Exception
    {
        for (String  doc_path : documents) {
            _printMessage( "*** install: " + doc_path );
            try {
                _install( doc_path );
            } catch (Exception ex) {
                _printMessage( "@@@ ERROR: " + doc_path
                                + " - " + ex.getMessage() );
                _printMessage( "...skip" );
            }
        }
    }



    private void _install(
                    final String doc_path
                    )
    throws Exception
    {
        URL  url = null;
        try {
            url = new URL( doc_path );
        } catch (MalformedURLException ex) {
            url = null;
        }

        if (url == null) {
            //local filepath
            File  file = new File( doc_path );
            _install( file );
        } else {
            _install( url );
        }
    }



    private void _install(
                    final File file
                    )
    throws Exception
    {
        _printMessage( "install OVAL document from file: " + file );
        _install( file.getCanonicalPath(), new FileInputStream( file ) );
    }



    private void _install(
                    final URL url
                    )
    throws Exception
    {
        _printMessage( "install OVAL document from URL: " + url );
        _install( url.toString(), url.openStream() );
    }



    private void _install(
                    final String source,
                    final InputStream stream
                    )
    throws Exception
    {
        _printMessage( "unmarshalling OVAL document...: " + source );
        Object  obj = _xml_mapper.unmarshal( stream );
        _printMessage( "...unmarshalling DONE: " + source );

        _printMessage( "document type=" +  obj.getClass() );
        if (obj instanceof OvalDefinitions) {
            _oval_repository.saveOvalDefinitions( OvalDefinitions.class.cast( obj ) );
        } else if (obj instanceof OvalResults) {
            _oval_repository.saveOvalResults( OvalResults.class.cast( obj ) );
        } else if (obj instanceof OvalResults) {
            _oval_repository.saveOvalSystemCharacteristics( OvalSystemCharacteristics.class.cast( obj ) );
        }

        _printMessage( "...installation of OVAL document COMPLETED: " + source );
    }



    /**
     */
    private void _printMessage(
                    final String message
                    )
    {
        _msg_stream.println( message );
        _msg_stream.flush();
    }



    /**
     */
    private void _printMessage(
                    final String[] lines
                    )
    {
        for (String  line : lines) {
            _printMessage( line);
        }
    }



}
//

package jp.go.aist.six.oval.core;

import java.io.File;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.oval.xml.OvalXmlMapper;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalTestBase
{

    private final SixOvalContext  _context;
    private final OvalXmlMapper  _xmlMapper;
    private OvalRepository  _repository;
    private File  _tmpDir = null;



    protected OvalTestBase(
                    final SixOvalContext context
                    )
    {
        _context = context;

        _xmlMapper = context.getXmlMapper();

        String  tmp_dirpath = System.getProperty( "java.io.tmpdir" );
        _tmpDir = new File( tmp_dirpath, "six-oval" );
        _tmpDir.mkdirs();
    }



    protected OvalXmlMapper _getXmlMapper()
    {
        return _xmlMapper;
    }



    protected OvalRepository _getRepository()
    {
        if (_repository == null) {
            _repository = _context.getRepository();
        }

        return _repository;
    }



    protected File _getTmpDir()
    {
        return _tmpDir;
    }



    protected File[] _listXmlFiles(
                    final String input_rootdir_path,
                    final String input_subdir_path
                    )
    throws Exception
    {
        File  dir = new File( input_rootdir_path, input_subdir_path );
        File[]  xml_files = TestUtil.listXmlFiles( dir );

        return xml_files;
    }

}
//

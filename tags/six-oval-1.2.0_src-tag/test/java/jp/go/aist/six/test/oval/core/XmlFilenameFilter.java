package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.io.FilenameFilter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class XmlFilenameFilter
    implements FilenameFilter
{

    public XmlFilenameFilter()
    {
    }


    @Override
    public boolean accept(
                    final File dir,
                    final String name
                    )
    {
        return name.endsWith( ".xml" );
    }

}
//

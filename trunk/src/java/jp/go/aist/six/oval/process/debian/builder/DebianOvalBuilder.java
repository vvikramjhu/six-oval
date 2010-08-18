/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jp.go.aist.six.oval.process.debian.builder;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.definitions.StateRef;
import jp.go.aist.six.oval.model.definitions.States;
import jp.go.aist.six.oval.model.definitions.SystemObjectRef;
import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.DebianBugReference;
import jp.go.aist.six.oval.model.linux.DpkgInfoObject;
import jp.go.aist.six.oval.model.linux.DpkgInfoState;
import jp.go.aist.six.oval.model.linux.DpkgInfoTest;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.oval.process.OvalProcessException;
import jp.go.aist.six.oval.process.debian.dsa.Dsa;
import jp.go.aist.six.oval.process.debian.dsa.FixedIn;
import jp.go.aist.six.oval.process.debian.dsa.FixedInArchitecture;
import jp.go.aist.six.oval.service.OvalConfig;
import jp.go.aist.six.util.IsoDate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Map;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DebianOvalBuilder
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( DebianOvalBuilder.class );


    /**
     * If the property "six.oval.debian.dsc" is specified,
     * the dsc files of packages are retrieved from that location.
     * The location may be a directory or URL.
     * If the specified dsc file is not found in this location,
     * it is read from the Debian site:
     * "http://security.debian.org/pool/updates/main/x/xxx/".
     */
    public static final String  PROP_DEBIAN_DSC_LOCATION = "six.oval.debian.dsc";



    public static final String  OVAL_ID_PREFIX = "oval:jp.go.aist.six.oval.debian.dsa:";



//    public static final String GENERATOR  = "oval:generator";
//
//    private static Map<String,DebianOvalElementBuilder> _createElementBuilderMapping()
//    {
//        Map<String,DebianOvalElementBuilder>  map =
//            new HashMap<String,DebianOvalElementBuilder>();
//
//        map.put(GENERATOR,  new GeneratorBuilder());
//
//        return map;
//    }
//
//    private Map<String,DebianOvalElementBuilder>  _elementHandlerMapping =
//        _createElementBuilderMapping();



    /**
     * Constructor.
     */
    public DebianOvalBuilder()
    {
    }



    /**
     */
    public OvalDefinitions createOvalDefinitions(
                    final Dsa dsa
                    )
    throws OvalProcessException
    {
        OvalDefinitions  oval = new OvalDefinitions();

//        DebianOvalElementBuilder  builder = _elementHandlerMapping.get( GENERATOR );
//        builder.build( oval, dsa );

        _build( oval, dsa );

        return oval;
    }



    /**
     * OVAL definition ID.
     */
    private String _createDefinitionID(
                    final String dsaID
                    )
    {
        return OVAL_ID_PREFIX + "def:" + dsaID;
    }



    /**
     * OVAL object ID.
     */
    private String _createSystemObjectID(
                    final String dsaID,
                    final int seq )
    {
        return OVAL_ID_PREFIX + "obj:" + dsaID + _createEntitySequenceString( seq );
    }


    /**
     * OVAL state ID.
     */
    private String _createStateID(
                    final String dsaID,
                    final int seq )
    {
        return OVAL_ID_PREFIX + "ste:" + dsaID + _createEntitySequenceString( seq );
    }



    /**
     * OVAL test ID.
     */
    private String _createTestID(
                    final String dsaID,
                    final int seq )
    {
        return OVAL_ID_PREFIX + "tst:" + dsaID + _createEntitySequenceString( seq );
    }



    private static final String[]  _ZERO_PADDING_ = new String[] {
        "0000",
        "000",
        "00",
        "0",
        ""
    };


    private String _createEntitySequenceString(
                    final int seq
                    )
    {
        String  s = String.valueOf( seq );
        return _ZERO_PADDING_[s.length()] + s;
    }



   /**
     * If the title of the DSA is "DSA-1974-1 gzip -- several vulnerabilities",
     * the ID is "1974".
     */
    private String _getDsaID(
                    final Dsa dsa
                    )
    throws OvalProcessException
    {
        String  title = dsa.getTitle();
        if (title == null) {
            throw new OvalProcessException( "unable to get DSA ID: title=null" );
        }

        String[]  tokens = title.split( "-" );
        if (tokens.length < 3) {
            throw new OvalProcessException( "unable to get DSA ID: title=" + title );
        }

        return tokens[1];
    }



    /**
     * If the title of the DSA is "DSA-1974-1 gzip -- several vulnerabilities",
     * the version is 1.
     */
    private int _getDsaVersion(
                    final Dsa dsa
                    )
    throws OvalProcessException
    {
        String  title = dsa.getTitle();
        if (title == null) {
            throw new OvalProcessException( "unable to get DSA version: title=null" );
        }

        String[]  tokens = title.split( "-" );
        if (tokens.length < 3) {
            throw new OvalProcessException( "unable to get DSA version: title=" + title );
        }

        String[]  tokens2 = tokens[2].split( " " );
        int  version = 0;
        try {
            version = Integer.valueOf( tokens2[0] ).intValue();
        } catch (NumberFormatException ex) {
            throw new OvalProcessException( "unable to get DSA version: title=" + title );
        }

        return version;
    }



    /**
     */
    private void _build(
                    final OvalDefinitions oval,
                    final Dsa dsa
                    )
    throws OvalProcessException
    {

        final String  dsaID      = _getDsaID( dsa );
        final int     dsaVersion = _getDsaVersion( dsa );

        _buildGenerator( oval, dsa );
        _buildDefinition( oval, dsa, dsaID, dsaVersion );
    }



    /**
     */
    private void _buildGenerator(
                    final OvalDefinitions oval,
                    final Dsa dsa
                    )
    {
        Generator  generator = new Generator();
        generator.setSchemaVersion( "5.6" );
        generator.setTimestamp( new Date() );
        generator.setProductName( "SIX OVAL" );
        generator.setProductVersion( "0.4.0" );

        oval.setGenerator( generator );
    }



    /**
     * definition.
     */
    private void _buildDefinition(
                    final OvalDefinitions oval,
                    final Dsa dsa,
                    final String dsaID,
                    final int dsaVersion
                    )
    throws OvalProcessException
    {
        final String  defID = _createDefinitionID( dsaID );
        final int  defVersion = dsaVersion;
        Definition  def = new Definition( defID, defVersion, DefinitionClass.PATCH );
        oval.getDefinitions().add( def );

        // TODO: metadata //
        Metadata  metadata = new Metadata();
        metadata.setTitle( dsa.getTitle() );
        metadata.setDescription( dsa.getMoreInformation() );
        Affected  affected = new Affected();
        affected.setFamily( Family.UNIX );
        for (String  debianVersion : dsa.getFixedInDebianVersions()) {
            affected.addPlatform( new Platform( debianVersion ) );
        }
        for (String  pkg : dsa.getAffectedPackages()) {
            affected.addProduct( new Product( pkg ) );
        }
        metadata.setAffected( affected );
        metadata.addReference( _createDsaReference( dsa, dsaID ) );
        def.setMetadata( metadata );

        _buildAdvisory( def, dsa );


        // objects, states, tests, and criteria //
        Map<String,FixedIn>  fixedinMapping = dsa.getFixedInMapping();
        for (String  debianVersion : fixedinMapping.keySet()) {
            if (! debianVersion.equals( "Debian GNU/Linux 5.0 (lenny)" )) {
                continue;
                //TODO: Debian version
            }

            FixedIn  fixedin = fixedinMapping.get( debianVersion );
            FixedInArchitecture  sourceFixedin =
                fixedin.getArchitectureMapping().get( "Source:" );
            String  dscURL = null;
            for (String  url : sourceFixedin.getPackageURLs()) {
                if (url.endsWith( ".dsc" )) {
                    dscURL = url;
                    break;
                }
            }

            if (dscURL == null) {
                throw new OvalProcessException( "unable to find '.dsc' URL: Debian version="
                                + debianVersion );
            }

            // evr: consults to .dsc //
            PackageDsc  dsc = null;
            try {
                dsc = _readPackageDsc( dscURL );
            } catch (Exception ex) {
                throw new OvalProcessException( "unable to read '.dsc': URL=" + dscURL );

            }
            final String  pkgEvr = _dpkgVersion2Evr( dsc.version );
            if (_LOG.isDebugEnabled()) {
                _LOG.debug( "deb evr: " + pkgEvr );
            }

            // state: dpkginfo evr //
            States  stateCollection = new States();
            final String  stateID = _createStateID( dsaID, 1 );
            DpkgInfoState  ovalState = new DpkgInfoState( stateID, defVersion );
            ovalState.setEvr( new EntityStateString( pkgEvr ) );
            if (_LOG.isDebugEnabled()) {
                _LOG.debug( "state created: " + ovalState );
            }
            stateCollection.add( ovalState );
            oval.setStates( stateCollection );

            Criteria  criteria = new Criteria();
            criteria.setOperator( Operator.OR );
            int  seq = 1;
            for (String  pkgName : dsc.binary) {
                if (_LOG.isDebugEnabled()) {
                    _LOG.debug( "processing dpkg...: " + pkgName );
                }

                final String  objectID = _createSystemObjectID( dsaID, seq );
                DpkgInfoObject  ovalObject = new DpkgInfoObject( objectID, defVersion, pkgName );
                if (_LOG.isDebugEnabled()) {
                    _LOG.debug( "object created: " + ovalObject );
                }

                final String  testID = _createTestID( dsaID, seq );
                DpkgInfoTest  ovalTest = new DpkgInfoTest( testID, defVersion );
                ovalTest.setObject( new SystemObjectRef( objectID ) );
                ovalTest.addState( new StateRef( stateID ) );
                ovalTest.setCheck( Check.AT_LEAST_ONE );
                ovalTest.setComment( pkgName + " is earlier than " + pkgEvr );
                if (_LOG.isDebugEnabled()) {
                    _LOG.debug( "test created: " + ovalTest );
                }

                oval.getObjects().add( ovalObject );
                oval.getTests().add( ovalTest );

                criteria.addElement( new Criterion( testID ) );

                seq++;
            }

            def.setCriteria( criteria );
        }
    }



    /**
     * TODO: Complete this!!!
     */
    private void _buildAdvisory(
                    final Definition def,
                    final Dsa dsa
                    )
    throws OvalProcessException
    {
        LinuxSecurityAdvisory  advisory = new LinuxSecurityAdvisory();
        advisory.setFrom( "security@debian.org" );
        advisory.setIssued( IsoDate.dateValueOf( dsa.getDateReported() ) );

        _buildAdvisoryReferences( advisory, dsa );

        def.getMetadata().addAdditionalMetadata( advisory );
    }



    /**
     *
     */
    private void _buildAdvisoryReferences(
                    final LinuxSecurityAdvisory advisory,
                    final Dsa dsa
                    )
    throws OvalProcessException
    {
        Map<String,String>  dsaRefs = dsa.getSecurityDatabaseReferences();
        for (String  refID :  dsaRefs.keySet()) {
            String  refURL = dsaRefs.get( refID );

            if (refURL.startsWith( "http://bugs.debian.org/cgi-bin/bugreport.cgi?bug=" )) {
                advisory.addBug( new DebianBugReference( refID, refURL ) );
            } else if (refURL.startsWith( "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-" )) {
                advisory.addCve( new CveReference( refID, refURL ) );
            } else {
                throw new OvalProcessException( "unknown DSA reference: " + refID
                                + ", " + refURL );
            }
        }
    }



    /**
     * e.g. http://www.debian.org/security/2010/dsa-2016.en.html
     */
    private Reference _createDsaReference(
                    final Dsa dsa,
                    final String dsaID
                    )
    {
        String[]  dateTokens = dsa.getDateReported().split( "-" );

        Reference  ref = new Reference();
        ref.setSource( "DSA" );
        ref.setRefID( "DSA-" + dsaID );
        ref.setRefURL( "http://www.debian.org/security/"
                        + dateTokens[0] + "/dsa-" + dsaID + ".en.html" );

        return ref;
    }



    /**
     * Canonicalizes the deb package version to evr string.
     * If the epoch part is not included in the version string,
     * it is added, i.e. "0:".
     * Otherwise, the given version string is returned as it is.
     */
    private String _dpkgVersion2Evr(
                    final String version
                    )
    {
        String  evr = version;
        if (version.indexOf( ':' ) == -1) {
            evr = "0:" + version;
        }

        return evr;
    }



    /**
     * If the property PROP_DEBIAN_DSC_LOCATION is specified,
     * the dsc file is first retrieved from that location.
     * If it is not found, it is read from the given URL, i.e the Debian site.
     */
    private PackageDsc _readPackageDsc(
                    final String dscURL
                    )
    throws IOException, MalformedURLException
    {
        final String  optionalLocation = OvalConfig.getProperty( PROP_DEBIAN_DSC_LOCATION );
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "optional Debian package dsc location: " + optionalLocation );
        }

        InputStream  inStream = null;
        if (optionalLocation != null) {
            final String[]  frags = dscURL.split( "/" );
            final String  dscFilename = frags[frags.length - 1];
            if (_isURL( optionalLocation )) {
                final StringBuilder  optionalURLLocation = new StringBuilder( optionalLocation );
                if (!optionalLocation.endsWith( "/" )) {
                    optionalURLLocation.append( "/" );
                }
                optionalURLLocation.append( dscFilename );
                final String  optionalDscURL = optionalURLLocation.toString();
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "Debian package dsc read from: " + optionalDscURL );
                }

                inStream = (new URL( optionalDscURL )).openStream();
            } else {
                File  optionalDirLocation = new File( optionalLocation );
                if (optionalDirLocation.exists()  &&  optionalDirLocation.isDirectory()) {
                    final File  optionalDscFile = new File( optionalDirLocation, dscFilename );
                    if (optionalDscFile.exists()) {
                        if (_LOG.isTraceEnabled()) {
                            _LOG.trace( "Debian package dsc read from: "
                                            + optionalDscFile.getAbsolutePath() );
                        }
                        inStream = new FileInputStream( optionalDscFile );
                    }
                }
            }
        }

        if (inStream == null) {
            if (_LOG.isTraceEnabled()) {
                _LOG.trace( "Debian package dsc read from: " + dscURL );
            }
            inStream = (new URL( dscURL )).openStream();
        }

        PackageDsc  dsc = PackageDsc.parse( inStream );
                                     //@throws IOException

        return dsc;
    }



    /**
     *
     */
    private boolean _isURL( final String location )
    {
        if (location.startsWith( "http:/")
                        ||  location.startsWith( "https:/" )
                        ||  location.startsWith( "file:/" )
                        ) {
            return true;
        }

        return false;
    }



    /**
     * The Debian package description.
     */
    private static class PackageDsc
    {
        private static final String  _DSC_BINARY_  = "Binary: ";
        private static final String  _DSC_VERSION_ = "Version: ";


        public String  version = null;
        public String[]  binary = null;


        public PackageDsc()
        {
        }


        public boolean isValid()
        {
            return (version != null  &&  binary != null);
        }


        /**
         */
        public static PackageDsc parse(
                        final InputStream stream
                        )
        throws IOException
        {
            final BufferedReader  reader =
                new BufferedReader( new InputStreamReader( stream ) );

            PackageDsc  dsc = new PackageDsc();
            try {
                while (true) {
                    String  line = reader.readLine();
                    if (line == null) {
                        break;
                    }

                    if (line.startsWith( _DSC_BINARY_ )) {
                        line = line.substring( _DSC_BINARY_.length() ).trim();
                        dsc.binary = line.split( ", " );
                        if (_LOG.isDebugEnabled()) {
                            _LOG.debug( "package dsc Binary: " + line );
                        }
                    } else if (line.startsWith( _DSC_VERSION_ )) {
                        line = line.substring( _DSC_VERSION_.length() ).trim();
                        dsc.version = line;
                        if (_LOG.isDebugEnabled()) {
                            _LOG.debug( "package dsc Version: " + line );
                        }
                    }

                    if (dsc.isValid()) {
                        break;
                    }
                }
            } finally {
                try {
                    reader.close();
                } catch (Exception ex) {
                    //negligible
                }
            }

            return dsc;
        }
    }
    // PackageDsc

}
// DebianOvalBuilder

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */


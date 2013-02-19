/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.windows;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The fileeffectiverights object is used by a file effective rights test
 * to define the objects used to evalutate against the specified state.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.3:
 *             Replaced by the fileeffectiverights53 object and
 *             will be removed in version 6.0 of the language.
 */
@Deprecated
public class FileEffectiveRightsObject
    extends SystemObjectType
{

    //TODO: XSD model.
	// choice(
	//    set
    //    sequence(
    //           behaviors
    //           path
    //           filename
    //           trustee_name
    //   )

    private Set  set;
    //{1..1}


    private FileEffectiveRightsBehaviors  behaviors;
    //{0..1}

    private EntityObjectStringType  path;
    //{1..1}

    private EntityObjectStringType  filename;
//    private EntityObjectStringType  filename = new EntityObjectStringType();
    //{1..1, nillable="true"}

    private EntityObjectStringType  trustee_name;
    //{1..1}



    /**
     * Constructor.
     */
    public FileEffectiveRightsObject()
    {
        this( null, 0 );
    }


    public FileEffectiveRightsObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.fileeffectiverights;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.FILEEFFECTIVERIGHTS;
    }


//    public FileObject(
//                    final String id,
//                    final int version,
//                    final String comment
//                    )
//    {
//        super( id, version, comment );
//    }
//
//
//    public FileObject(
//                    final String id,
//                    final int version,
//                    final String path,
//                    final String filename
//                    )
//    {
//        this( id, version,
//                        new EntityObjectStringType( path ),
//                        new EntityObjectStringType( filename )
//        );
//    }
//
//
//    public FileObject(
//                    final String id,
//                    final int version,
//                    final EntityObjectStringType path,
//                    final EntityObjectStringType filename
//                    )
//    {
//        super( id, version );
//        setPath( path );
//        setFilename( filename );
//    }



    /**
     */
    public void setSet(
                    final Set set
                    )
    {
        this.set = set;
    }


    public Set getSet()
    {
        return set;
    }



    /**
     */
    public void setBehaviors(
                    final FileEffectiveRightsBehaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public FileEffectiveRightsBehaviors getBehaviors()
    {
        return behaviors;
    }



    /**
     */
    public void setPath(
                    final EntityObjectStringType path
                    )
    {
        this.path = path;
    }


    public EntityObjectStringType getPath()
    {
        return path;
    }



    /**
     */
    public void setFilename(
                    final EntityObjectStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityObjectStringType getFilename()
    {
        return filename;
    }



    /**
     */
    public void setTrusteeName(
                    final EntityObjectStringType trustee_name
                    )
    {
        this.trustee_name = trustee_name;
    }


    public EntityObjectStringType getTrusteeName()
    {
        return trustee_name;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getPath() );
        ref_list.add( getFilename() );
        ref_list.add( getTrusteeName() );

        return ref_list;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }


    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FileEffectiveRightsObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "fileeffectiverights_object[" + super.toString()
                        + ", set=" 			+ getSet()
                        + ", behaviors="	+ getBehaviors()
                        + ", path=" 		+ getPath()
                        + ", filename=" 	+ getFilename()
                        + ", trustee_name="	+ getTrusteeName()
                        + "]";
    }

}
//FileEffectiveRightsObject

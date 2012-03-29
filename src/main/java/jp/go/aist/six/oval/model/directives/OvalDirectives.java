/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.model.directives;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.common.AbstractDocument;
import jp.go.aist.six.oval.model.common.GeneratorType;
import jp.go.aist.six.oval.model.results.ClassDirectivesType;
import jp.go.aist.six.oval.model.results.DefaultDirectivesType;
import com.google.code.morphia.annotations.Entity;



/**
 * The OvalDirectives is an OVAL Directive Document.
 * Its purpose is to bind together the generator and the set of directives contained in the document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.directives.oval_directives" )
public class OvalDirectives
    extends AbstractDocument
{

    private DefaultDirectivesType  directives;
    //{1..1}


    private final Collection<ClassDirectivesType>  class_directives = new ArrayList<ClassDirectivesType>();
    //{1..5}



    /**
     * Constructor.
     */
    public OvalDirectives()
    {
    }


    public OvalDirectives(
                    final GeneratorType generator
                    )
    {
        super( generator );
    }



    /**
     */
    public void setDirectives(
                    final DefaultDirectivesType variables
                    )
    {
        this.directives = variables;
    }


    public DefaultDirectivesType getDirectives()
    {
        return this.directives;
    }



    /**
     */
    public void setClassDirectives(
                    final Collection<? extends ClassDirectivesType> classDirectives
                    )
    {
        if (classDirectives != this.class_directives) {
            this.class_directives.clear();
            if (classDirectives != null  &&  classDirectives.size() > 0) {
                this.class_directives.addAll( classDirectives );
            }
        }
    }


    public Collection<ClassDirectivesType> getClassDirectives()
    {
        return this.class_directives;
    }


    public Iterator<ClassDirectivesType> iterateClassDirectives()
    {
        return this.class_directives.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "oval_directives[generator=" + getGenerator()
                        + ", directives=" + getDirectives()
                        + ", class_directives=" + getDirectives()
                        + "]";
    }

}
//OvalDirectives

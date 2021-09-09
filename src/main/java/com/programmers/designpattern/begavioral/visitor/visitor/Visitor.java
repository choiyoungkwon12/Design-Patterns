package com.programmers.designpattern.begavioral.visitor.visitor;

import com.programmers.designpattern.begavioral.visitor.shapes.Circle;
import com.programmers.designpattern.begavioral.visitor.shapes.CompoundShape;
import com.programmers.designpattern.begavioral.visitor.shapes.Dot;
import com.programmers.designpattern.begavioral.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
package com.example.library.myeditor.client;

import com.google.gwt.dom.client.Style.Cursor;
import com.hydro4ge.raphaelgwt.client.Attr;
import com.hydro4ge.raphaelgwt.client.DragCallback;
import com.hydro4ge.raphaelgwt.client.Raphael;

public class ShapeDragCallback implements DragCallback {

  String origFill;
  double origX;
  double origY;
  double rotation;
  Raphael.Shape shape;
  String xAttr;
  String yAttr;

  public ShapeDragCallback(Raphael.Shape s) {
    this(s, 60, "cx", "cy");
  }

  public ShapeDragCallback(Raphael.Rect r) {
    this(r, 360, "x", "y");
  }

  private ShapeDragCallback(Raphael.Shape s, double rotation, String xAttr, String yAttr) {
    shape = s;
    this.rotation = rotation;
    this.origFill = shape.attrAsString("fill");
    this.xAttr = xAttr;
    this.yAttr = yAttr;
    shape.attr(new Attr().cursor(Cursor.POINTER));
  }

  @Override
  public void onStart(double x, double y) {
    origX = shape.attrAsDouble(xAttr);
    origY = shape.attrAsDouble(yAttr);
    shape.attr(new Attr().cursor(Cursor.MOVE));
    shape.toFront();
    shape.animate(new Attr().rotation(rotation).fill("#415899").opacity(0.85), 400, "bounce");
  }

  @Override
  public void onMove(double dx, double dy, double x, double y) {
    shape.attr(xAttr, origX + dx);
    shape.attr(yAttr, origY + dy);
  }

  @Override
  public void onEnd() {
    shape.animate(new Attr().rotation(-rotation).fill(origFill).opacity(1), 400, "bounce");
    shape.attr(new Attr().cursor(Cursor.POINTER));
  }

}

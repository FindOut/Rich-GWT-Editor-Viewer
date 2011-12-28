package com.example.library.myeditor.client;

import com.google.gwt.dom.client.Style.Cursor;
import com.hydro4ge.raphaelgwt.client.Attr;
import com.hydro4ge.raphaelgwt.client.DragCallback;
import com.hydro4ge.raphaelgwt.client.Raphael;

public class PathDragCallback implements DragCallback {

  String origFill;
  double origX;
  double origY;
  Raphael.Path path;

  public PathDragCallback(Raphael.Path p) {
    this.path = p;
    this.origFill = p.attrAsString("fill");
    path.attr(new Attr().cursor(Cursor.POINTER));
  }

  @Override
  public void onStart(double x, double y) {
    origX = 0;
    origY = 0;
    path.attr(new Attr().cursor(Cursor.MOVE));
    path.toFront();
    path.animate(new Attr().opacity(0.50), 400, ">");
  }

  @Override
  public void onMove(double dx, double dy, double x, double y) {
    path.translate(dx - origX, dy - origY);
    origX = dx;
    origY = dy;
  }

  @Override
  public void onEnd() {
    path.animate(new Attr().opacity(1), 400, ">");
    path.attr(new Attr().cursor(Cursor.POINTER));
  }

}

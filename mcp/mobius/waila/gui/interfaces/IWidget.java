package mcp.mobius.waila.gui.interfaces;

import mcp.mobius.waila.gui.events.MouseEvent;
import mcp.mobius.waila.gui.widgets.WidgetGeometry;

import org.lwjgl.util.Point;

public interface IWidget {
	// Should all the coordinates, sizes, etc be % or absolute values ?
	// Should we allow 2 methods for an absolute referencing (screen pos) and relative one (parent pos) ?
	
	IWidget getParent();
	void    setParent(IWidget parent);
	
	void setGeometry(WidgetGeometry geom);
	WidgetGeometry getGeometry();
	
	Point getPos();
	Point getSize();
	int   getRight();
	int   getLeft();
	int   getTop();
	int   getBottom();
	
	void  draw();
	void  draw(Point pos);
	void  show();
	void  hide();
	boolean shouldRender();
	
	IWidget addWidget(String name, IWidget widget);
	IWidget getWidget(String name);
	IWidget delWidget(String name);	
	IWidget getWidgetAtCoordinates(int posX, int posY);
	
	void handleMouseInput();
	
	void onMouseClick(MouseEvent event);
	void onMouseDrag(MouseEvent event);
	void onMouseMove(MouseEvent event);
	void onMouseRelease(MouseEvent event);
	void onMouseWheel(MouseEvent event);
	void onMouseEnter(MouseEvent event);
	void onMouseLeave(MouseEvent event);
	
	void emit(String eventname, Object... params);
	void attach(IWidget trgwidget, String eventname, String slotname);
	void onWidgetEvent(IWidget srcwidget, String eventname, String slotname, Object... params);
	
	//boolean  onMouseEnter();
	//boolean  onMouseMoved();
	//boolean  onMouseLeave();
	
}
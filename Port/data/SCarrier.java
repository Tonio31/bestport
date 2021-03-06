package data;

import java.awt.Point;

import control.JITController;


public class SCarrier extends Carrier {

	private int containerIDSensor;
	private LeafPortLocation destination;
	private JITController controller;
	private Container loadedContainer;

	
	
	/**
	 * Constructor of the classe
	 * @param id : id of the straddle carrier
	 * @param name : name of the straddle carrier
	 * @param position : original position of the straddle carrier
	 */
	public SCarrier(int id, String name, Point position, JITController controller) {
		super(id, name, position);
		this.containerIDSensor = -1;
		this.controller = controller;
	}

	public void unloadContainer(LeafPortLocation location) {
		loadedContainer.setLocation(location);
		loadedContainer=null;
	}

	/**
	 * loadContainer : set the location of the container
	 */
	public void loadContainer(Container c) {
			loadedContainer = c;
			c.setLocation(this);
	}

	/**
	 * DestinationReachedEventSensor : call the destinationReached Method of the Controller
	 */
	public void destinationReachedEventSensor() {
		this.controller.destinationReached(this);
	}

	public boolean isMoving() {
		return getPosition().equals(destination) && !isContainerLoaded();
	}

	public LeafPortLocation getDestination() {
		return destination;
	}

	public void setDestination(LeafPortLocation property1) {
		this.destination = property1;
	}

	public int getContainerIDSensor() {
			return containerIDSensor;
		}

	public void setContainerIDSensor(int property1) {
			this.containerIDSensor = property1;
		}

	public boolean isContainerLoaded() {
		return loadedContainer!=null;
	}

	public Container getLoadedContainer() {
		return loadedContainer;
	}

}

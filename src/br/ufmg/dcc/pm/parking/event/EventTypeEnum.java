package br.ufmg.dcc.pm.parking.event;

/**
 * An enum containing all events that can happen in a Parking Lot
 * @author Alexandre Alphonsos Rodrigues Pereira
 * @author Jeronimo Nunes Rocha
 *
 */
public enum EventTypeEnum {
	
	E ( EnterEvent.class ),
	S ( ExitEvent.class  );
	
	private Class<? extends AbstractEvent> eventClass;
	
	private EventTypeEnum(Class<? extends AbstractEvent> eventClass) {
		this.eventClass = eventClass;
	}

	/**
	 * @return Which class is associated with the {@link EventTypeEnum}
	 */
	public Class<? extends AbstractEvent> getEventClass() {
		return eventClass;
	}

}

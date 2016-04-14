package br.ufmg.dcc.pm.parking.event;

public enum EventTypeEnum {
	
	E ( EnterEvent.class ),
	S  ( ExitEvent.class  );
	
	private Class<? extends AbstractEvent> eventClass;
	
	private EventTypeEnum(Class<? extends AbstractEvent> eventClass) {
		this.eventClass = eventClass;
	}

	public Class<? extends AbstractEvent> getEventClass() {
		return eventClass;
	}

}

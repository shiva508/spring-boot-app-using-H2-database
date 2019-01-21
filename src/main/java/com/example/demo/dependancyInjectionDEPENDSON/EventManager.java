package com.example.demo.dependancyInjectionDEPENDSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventManager {
private final List<Consumer<String>> listeners=new ArrayList<>();

public EventManager() {
	super();
}
private static class SingletonHolder {
	private static final EventManager INSTANCE = new EventManager();	
}

}

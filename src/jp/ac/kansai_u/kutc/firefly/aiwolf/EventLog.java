package jp.ac.kansai_u.kutc.firefly.aiwolf;

import java.util.ArrayList;
import java.util.List;

import org.aiwolf.client.lib.Topic;
import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Judge;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Species;

/**
 * This class records events, and extracts them by conditions.
 *
 * @author kosuke
 */
public class EventLog {
	private List<Event> allEvents = new ArrayList<Event>(); // a list of all events
	
	// add an event to the list
	public void addEvent(Event event){
		allEvents.add(event);
	}
	
	// return a copy of the list
	public List<Event> getAllEvents(){
		return new ArrayList<Event>(allEvents);
	}
	
	// extract events by conditions, and return a new list
	public List<Event> getEventsByDay(int day){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getDay() == day){
				events.add(event);
			}
		}
		return events;
	}
	public List<Event> getEventsByType(String type){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getType().equals(type)){
				events.add(event);
			}
		}
		return events;
	}
	public List<Event> getEventsByAgent(Agent agent){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getAgent().equals(agent)){
				events.add(event);
			}
		}
		return events;
	}
	public List<Event> getEventsByTarget(Agent target){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getTarget().equals(target)){
				events.add(event);
			}
		}
		return events;
	}
	public List<Event> getEventsByJudge(Judge judge){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getJudge().equals(judge)){
				events.add(event);
			}
		}
		return events;
	}
	public List<Event> getEventsByRole(Role role){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getRole().equals(role)){
				events.add(event);
			}
		}
		return events;
	}
	public List<Event> getEventsBySpecies(Species species){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getSpecies().equals(species)){
				events.add(event);
			}
		}
		return events;
	}
	public List<Event> getEventsByTopic(Topic topic){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(event.getTopic().equals(topic)){
				events.add(event);
			}
		}
		return events;
	}
}

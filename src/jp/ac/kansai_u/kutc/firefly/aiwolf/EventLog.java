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
	private List<Event> allEvents; // a list of events
	
	// constructors
	public EventLog(){
		allEvents = new ArrayList<Event>();
	}
	private EventLog(List<Event> sourceEvents){
		allEvents = sourceEvents;
	}
	
	// add an event to the list
	public void addEvent(Event event){
		allEvents.add(event);
	}
	// return a copy of the list
	public List<Event> getList(){
		return new ArrayList<Event>(allEvents);
	}
	
	// extract events by conditions, and return a new EventLog instance
	public EventLog selectByDay(int day){
		List<Event> events = new ArrayList<Event>();
		for(Event event: allEvents){
			if(day == event.getDay()){
				events.add(event);
			}
		}
		return new EventLog(events);
	}
	public EventLog selectByType(String type){
		List<Event> events = new ArrayList<Event>();
		if(type != null){
			for(Event event: allEvents){
				if(type.equals(event.getType())){
					events.add(event);
				}
			}
		}
		return new EventLog(events);
	}
	public EventLog selectByAgent(Agent agent){
		List<Event> events = new ArrayList<Event>();
		if(agent != null){
			for(Event event: allEvents){
				if(agent.equals(event.getAgent())){
					events.add(event);
				}
			}
		}
		return new EventLog(events);
	}
	public EventLog selectByTarget(Agent target){
		List<Event> events = new ArrayList<Event>();
		if(target != null){
			for(Event event: allEvents){
				if(target.equals(event.getTarget())){
					events.add(event);
				}
			}
		}
		return new EventLog(events);
	}
	public EventLog selectByJudge(Judge judge){
		List<Event> events = new ArrayList<Event>();
		if(judge != null){
			for(Event event: allEvents){
				if(judge.equals(event.getJudge())){
					events.add(event);
				}
			}
		}
		return new EventLog(events);
	}
	public EventLog selectByRole(Role role){
		List<Event> events = new ArrayList<Event>();
		if(role != null){
			for(Event event: allEvents){
				if(role.equals(event.getRole())){
					events.add(event);
				}
			}
		}
		return new EventLog(events);
	}
	public EventLog selectBySpecies(Species species){
		List<Event> events = new ArrayList<Event>();
		if(species != null){
			for(Event event: allEvents){
				if(species.equals(event.getSpecies())){
					events.add(event);
				}
			}
		}
		return new EventLog(events);
	}
	public EventLog selectByTopic(Topic topic){
		List<Event> events = new ArrayList<Event>();
		if(topic != null){
			for(Event event: allEvents){
				if(topic.equals(event.getTopic())){
					events.add(event);
				}
			}
		}
		return new EventLog(events);
	}
}

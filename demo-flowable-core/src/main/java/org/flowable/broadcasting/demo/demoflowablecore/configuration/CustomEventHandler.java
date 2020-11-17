package org.flowable.broadcasting.demo.demoflowablecore.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.engine.delegate.event.impl.FlowableEntityEventImpl;

public class CustomEventHandler implements FlowableEventListener {
	
    private static final Logger log = LogManager.getLogger(CustomEventHandler.class);
	
	@Override
	public void onEvent(FlowableEvent event) {
		switch ((FlowableEngineEventType) event.getType()) {
			case ENGINE_CREATED:
				/**
				 * The process-engine that dispatched this event has been created and is ready for use.
				 * The process-engine this listener is attached to, has been created and is ready for API-calls.
				 **/
				log.info(event.toString());
				break;

			case ENGINE_CLOSED:
				/**
				 * The process-engine that dispatched this event has been closed and cannot be used anymore.
				 * The process-engine this listener is attached to, has been closed. API-calls to the engine are no longer possible.
				 **/
				log.info(event.toString());
				break;
				
			case ENTITY_CREATED:
				/**
				 * New entity is created. A new entity is created. The new entity is contained in the event.
				 **/
				log.info(event.toString());
				break;

			case ENTITY_INITIALIZED:
				/**
				 * New entity has been created and all child-entities that are created as a result of the creation of this particular 
				 * entity are also created and initialized.
				 * A new entity has been created and is fully initialized. If any children are created as part of the creation of an 
				 * entity, this event will be fired AFTER the create/initialization of the child entities as opposed to the ENTITY_CREATE event.
				 **/
				log.info(event.toString());
				break;

			case ENTITY_UPDATED:
				/**
				 * Existing entity us updated. An existing is updated. The updated entity is contained in the event.
				 **/
				log.info(event.toString());
				break;

			case ENTITY_DELETED:
				/**
				 * Existing entity is deleted. An existing entity is deleted. The deleted entity is contained in the event.
				 **/
				log.info(event.toString());
				break;

			case ENTITY_SUSPENDED:
				/**
				 * Existing entity has been suspended. An existing entity is suspended. The suspended entity is contained in the event. 
				 * Will be dispatched for ProcessDefinitions, ProcessInstances and Tasks.
				 **/
				log.info(event.toString());
				break;

			case ENTITY_ACTIVATED:
				/**
				 * Existing entity has been activated. An existing entity is activated. The activated entity is contained in the event. 
				 * Will be dispatched for ProcessDefinitions, ProcessInstances and Tasks.
				 **/
				log.info(event.toString());
				break;

			case JOB_EXECUTION_SUCCESS:
				/**
				 * A job has been successfully executed. A job has been executed successfully. The event contains the job that was executed.
				 **/
				log.info(event.toString());
				break;

			case JOB_EXECUTION_FAILURE:
				/**
				 * A job has been executed, but failed. Event should be an instance of a {@link ActivitiExceptionEvent}.
				 * The execution of a job has failed. The event contains the job that was executed and the exception.
				 **/
				log.info(event.toString());
				break;

			case JOB_RETRIES_DECREMENTED:
				/**
				 * The retry-count on a job has been decremented. The number of job retries have been decremented due to a failed 
				 * job. The event contains the job that was updated.
				 **/
				log.info(event.toString());
				break;
			case JOB_RESCHEDULED:
				/**
				 * The job has been rescheduled.
				 **/
				log.info(event.toString());
				break;

			case JOB_CANCELED:
				/**
				 * Timer has been cancelled (e.g. user task on which it was bounded has been completed earlier than expected)
				 * A job has been canceled. The event contains the job that was canceled. Job can be canceled by API call, task 
				 * was completed and associated boundary timer was canceled, on the new process definition deployment.
				 **/
				log.info(event.toString());
				break;

			case TIMER_SCHEDULED:
				/**
				 * A Timer has been scheduled.
				 **/
				log.info(event.toString());
				break;

			case TIMER_FIRED:
				/**
				 * Timer has been fired successfully. A timer has been fired. The event contains the job that was executed?
				 **/
				log.info(event.toString());
				break;

			case ACTIVITY_STARTED:
				/**
				 * An activity is starting to execute. This event is dispatch right before an activity is executed.
				 * An activity is starting to execute
				 **/
				log.info(event.toString());
				break;

			case ACTIVITY_COMPLETED:
				/**
				 * An activity has been completed successfully. An activity is completed successfully
				 **/
				log.info(event.toString());
				break;

			case ACTIVITY_CANCELLED:
				/**
				 * An activity has been cancelled because of boundary event. An activity is going to be cancelled. There can be 
				 * three reasons for activity cancellation (MessageEventSubscriptionEntity, SignalEventSubscriptionEntity, TimerEntity).
				 **/
				log.info(event.toString());
				break;

			case ACTIVITY_SIGNALED:
				/**
				 * An activity has received a signal. Dispatched after the activity has responded to the signal.
				 * An activity received a signal
				 **/
				log.info(event.toString());
				break;

			case ACTIVITY_MESSAGE_RECEIVED:
				/**
				 * An activity has received a message event. Dispatched before the actual message has been received by the activity. 
				 * This event will be either followed by a {@link #ACTIVITY_SIGNALLED} event or
				 * {@link #ACTIVITY_COMPLETE} for the involved activity, if the message was delivered successfully.
				 * An activity received a message. Dispatched before the activity receives the message. When received, a ACTIVITY_SIGNAL 
				 * or ACTIVITY_STARTED will be dispatched for this activity, depending on the type (boundary-event or event-subprocess start-event)
				 **/
				log.info(event.toString());
				break;

			case ACTIVITY_MESSAGE_WAITING:		  
				/**
				 * A boundary, intermediate, or subprocess start message catching event has started and it is waiting for message.
				 **/
				log.info(event.toString());
				break;

			case ACTIVITY_MESSAGE_CANCELLED:
				/**
			     * An activity has received a message event. Dispatched before the actual message has been received by the activity. This event will be either followed by a {@link #ACTIVITY_SIGNALLED} event or
			     * {@link #ACTIVITY_COMPLETED} for the involved activity, if the message was delivered successfully.
			     **/
				log.info(event.toString());
				break;

			case ACTIVITY_ERROR_RECEIVED:
				/**
				 * An activity has received an error event. Dispatched before the actual error has been received by the activity. 
				 * This event will be either followed by a {@link #ACTIVITY_SIGNALLED} event or
				 * {@link #ACTIVITY_COMPLETE} for the involved activity, if the error was delivered successfully.
				 * An activity has received an error event. Dispatched before the actual error has been handled by the activity. 
				 * The event’s activityId contains a reference to the error-handling activity. This event will be either followed 
				 * by a ACTIVITY_SIGNALLED event or ACTIVITY_COMPLETE for the involved activity, if the error was delivered successfully.
				 **/
				log.info(event.toString());
				break;

//			case UNCAUGHT_BPMN_ERROR:
//				/**
//				 * When a BPMN Error was thrown, but was not caught within in the process. The process did not have any handlers 
//				 * for that specific error. The event’s activityId will be empty.
//				 **/
//				log.info(event.toString());
//				break;

			case ACTIVITY_COMPENSATE:
				/**
				 * An activity is about to be executed as a compensation for another activity. The event targets the activity that is 
				 * about to be executed for compensation. An activity is about to be compensated. The event contains the id of the 
				 * activity that is will be executed for compensation.
				 **/
				log.info(event.toString());
				break;
				
			case MULTI_INSTANCE_ACTIVITY_STARTED:
				/**
			     * A multi-instance activity is starting to execute. This event is dispatched right before an activity is executed.
			     */
				log.info(event.toString());
				break;

			case MULTI_INSTANCE_ACTIVITY_COMPLETED:
			    /**
			     * A multi-instance activity has been completed successfully.
			     */
				log.info(event.toString());
				break;

			case MULTI_INSTANCE_ACTIVITY_CANCELLED:
			    /**
			     * A multi-instance activity has been cancelled.
			     */
				log.info(event.toString());
				break;

			case VARIABLE_CREATED:
				/**
				 * A new variable has been created.. The event contains the variable name, value and related execution and task (if any).
				 **/
				log.info(event.toString());
				break;

			case VARIABLE_UPDATED:
				/**
				 * An existing variable has been updated. The event contains the variable name, updated value and related execution and task (if any).
				 **/
				log.info(event.toString());
				break;

			case VARIABLE_DELETED:
				/**
				 * An existing variable has been deleted. The event contains the variable name, last known value and related execution and task (if any).
				 **/
				log.info(event.toString());
				break;

			case TASK_ASSIGNED:
				/**
				 * A task has been assigned to a user. This is thrown alongside with an {@link #ENTITY_UPDATED} event.
				 * The event contains the task
				 **/
				log.info(event.toString());
				break;

			case TASK_CREATED:
				/**
				 * A task has been created. This is thrown when task is fully initialized (before TaskListener.EVENTNAME_CREATE). This is 
				 * dispatched after the ENTITY_CREATE event. In case the task is part of a process, this event will be fired before the task 
				 * listeners are executed.
				 **/
				log.info(event.toString());
				break;

			case TASK_COMPLETED:
				/**
				 * A task has been completed. Dispatched before the task entity is deleted ( {@link #ENTITY_DELETED}). If the task is part of a 
				 * process, this event is dispatched before the process moves on, as a result of the task completion. In that case, a 
				 * {@link #ACTIVITY_COMPLETED} will be dispatched after an event of this type for the activity corresponding to the task.
				 * In case the task is part of a process, this event will be fired before the process has moved on and will be followed by a 
				 * ACTIVITY_COMPLETE event, targeting the activity that represents the completed task.
				 **/
				log.info(event.toString());
				break;
			case TASK_OWNER_CHANGED:
				/**
				 * A task owner has been changed. This is dispatched before the ENTITY_UPDATE event.
				 **/
				log.info(event.toString());
				break;
			case TASK_PRIORITY_CHANGED:
				/**
				 * A task priority has been changed. This is dispatched before the ENTITY_UPDATE event.
				 **/
				log.info(event.toString());
				break;
			case TASK_DUEDATE_CHANGED:
				/**
				 * A task due date has been changed. This is dispatched before the ENTITY_UPDATE event.
				 **/
				log.info(event.toString());
				break;
			case TASK_NAME_CHANGED:
				/**
				 * A task name has been changed. This is dispatched before the ENTITY_UPDATE event.
				 **/
				log.info(event.toString());
				break;
				
			case PROCESS_CREATED:
				/**
			     * A process instance has been created. All basic properties have been set, but variables not yet.
			     **/
				log.info(event.toString());
				break;

			case PROCESS_STARTED:
			    /**
			     * A process instance has been started. Dispatched when starting a process instance previously created. The event
			     * PROCESS_STARTED is dispatched after the associated event ENTITY_INITIALIZED.
			     **/
				log.info(event.toString());
				break;

			case PROCESS_COMPLETED:
				/**
				 * A process has been completed. Dispatched after the last activity is ACTIVITY_COMPLETED. Process is completed when it reaches 
				 * state in which process instance does not have any transition to take.
				 **/
				log.info(event.toString());
				break;

			case PROCESS_COMPLETED_WITH_TERMINATE_END_EVENT:
				/**
			     * A process has been cancelled. Dispatched when process instance is deleted by
			     * 
			     * @see org.flowable.engine.impl.RuntimeServiceImpl#deleteProcessInstance(String, String), before DB delete.
			     **/
				FlowableEntityEventImpl processCompletedWithTerminateEndEvent = (FlowableEntityEventImpl) event;
				log.info(processCompletedWithTerminateEndEvent.toString());
				break;

			case PROCESS_CANCELLED:
				/**
				 * A process has been cancelled. Dispatched before the process instance is deleted from runtime. Process instance is cancelled by 
				 * API call RuntimeService.deleteProcessInstance
				 * @see org.activiti.engine.impl.RuntimeServiceImpl#deleteProcessInstance(String, String), before DB delete.
				 **/
				log.info(event.toString());
				break;

			case PROCESS_COMPLETED_WITH_ERROR_END_EVENT:		  
				/**
				 * A process has been completed with an error end event.
				 **/
				log.info(event.toString());
				break;
			default:
			case CUSTOM:
				/**
				 * An event type to be used by custom events. These types of events are never thrown by the engine itself, only be 
				 * an external API call to dispatch an event.
				 **/
				log.info(event.toString());
				break;
			case ACTIVITY_SIGNAL_WAITING:
				/**
			     * A boundary, intermediate, or subprocess start signal catching event has started.
			     **/
				log.info(event.toString());
				break;

			case HISTORIC_ACTIVITY_INSTANCE_CREATED:		  
				/**
				 * A event dispatched when a {@link HistoricActivityInstance} is created. 
				 * This is a specialized version of the {@link ActivitiEventType#ENTITY_CREATED} and {@link ActivitiEventType#ENTITY_INITIALIZED} 
				 * event, with the same use case as the {@link ActivitiEventType#ACTIVITY_STARTED}, but containing slightly different data.
				 * 
				 * Note this will be an {@link ActivitiEntityEvent}, where the entity is the {@link HistoricActivityInstance}.
				 *  
				 * Note that history (minimum level ACTIVITY) must be enabled to receive this event.  
				 **/
				log.info(event.toString());
				break;

			case HISTORIC_ACTIVITY_INSTANCE_ENDED:		  
				/**
				 * A event dispatched when a {@link HistoricActivityInstance} is marked as ended. 
				 * his is a specialized version of the {@link ActivitiEventType#ENTITY_UPDATED} event,
				 * with the same use case as the {@link ActivitiEventType#ACTIVITY_COMPLETED}, but containing
				 * slightly different data (e.g. the end time, the duration, etc.). 
				 *  
				 * Note that history (minimum level ACTIVITY) must be enabled to receive this event.  
				 **/
				log.info(event.toString());
				break;

			case SEQUENCEFLOW_TAKEN:
				/**
				 * Indicates the engine has taken (ie. followed) a sequence flow from a source activity to a target activity.
				 **/
				log.info(event.toString());
				break;

			case HISTORIC_PROCESS_INSTANCE_CREATED:		  
				/**
				 * A event dispatched when a {@link HistoricProcessInstance} is created. 
				 * This is a specialized version of the {@link ActivitiEventType#ENTITY_CREATED} and 
				 * {@link ActivitiEventType#ENTITY_INITIALIZED} event, with the same use case as the 
				 * {@link ActivitiEventType#PROCESS_STARTED}, but containing slightly different data 
				 * (e.g. the start time, the start user id, etc.). 
				 * 
				 * Note this will be an {@link ActivitiEntityEvent}, where the entity is the {@link HistoricProcessInstance}.
				 *  
				 * Note that history (minimum level ACTIVITY) must be enabled to receive this event.  
				 **/
				log.info(event.toString());
				break;

			case HISTORIC_PROCESS_INSTANCE_ENDED:		  
				/**
				 * A event dispatched when a {@link HistoricProcessInstance} is marked as ended. 
				 * his is a specialized version of the {@link ActivitiEventType#ENTITY_UPDATED} event,
				 * with the same use case as the {@link ActivitiEventType#PROCESS_COMPLETED}, but containing
				 * slightly different data (e.g. the end time, the duration, etc.). 
				 *  
				 * Note that history (minimum level ACTIVITY) must be enabled to receive this event.  
				 **/
				log.info(event.toString());
				break;

			case MULTI_INSTANCE_ACTIVITY_COMPLETED_WITH_CONDITION:
			    /**
			     * A multi-instance activity has met its condition and completed successfully.
			     */
				log.info(event.toString());
				break;
		}
	}

	/**
	 * Determines the behavior in case the onEvent(..) method throws an exception when an event is dispatched. 
	 * In case false is returned, the exception is ignored. When true is returned, the exception is not ignored 
	 * and bubbles up, effectively failing the current ongoing command.
	 * @see FlowableEventListener#isFailOnException()
	 **/
	@Override
	public boolean isFailOnException() {
		/**
		 * The logic in the onEvent method of this listener is not critical, exceptions can be ignored if logging fails...
		 **/
		return false;
	}

	@Override
	public String getOnTransaction() {
		return null;
	}

	/**
	 * The isFireOnTransactionLifecycleEvent() method determines whether this event listener fires immediately when the event occurs or on a transaction lifecycle 
	 * event determined by getOnTransaction() method. Supported values of the transaction life cycle event are: COMMITTED, ROLLED_BACK, COMMITTING, ROLLINGBACK.
	 **/
	@Override
	public boolean isFireOnTransactionLifecycleEvent() {
		return false;
	}
}
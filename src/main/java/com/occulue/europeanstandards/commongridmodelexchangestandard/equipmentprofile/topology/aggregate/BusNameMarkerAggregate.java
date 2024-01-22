package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * Aggregate handler for BusNameMarker as outlined for the CQRS pattern, all write responsibilities
 * related to BusNameMarker are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class BusNameMarkerAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public BusNameMarkerAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public BusNameMarkerAggregate(CreateBusNameMarkerCommand command) throws Exception {
    LOGGER.info("Handling command CreateBusNameMarkerCommand");
    CreateBusNameMarkerEvent event = new CreateBusNameMarkerEvent(command.getBusNameMarkerId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateBusNameMarkerCommand command) throws Exception {
    LOGGER.info("handling command UpdateBusNameMarkerCommand");
    UpdateBusNameMarkerEvent event =
        new UpdateBusNameMarkerEvent(
            command.getBusNameMarkerId(), command.getPriority(), command.getBusNameMarker());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteBusNameMarkerCommand command) throws Exception {
    LOGGER.info("Handling command DeleteBusNameMarkerCommand");
    apply(new DeleteBusNameMarkerEvent(command.getBusNameMarkerId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignPriorityToBusNameMarkerCommand command) throws Exception {
    LOGGER.info("Handling command AssignPriorityToBusNameMarkerCommand");

    if (priority != null
        && priority.getIntegerProxyId() == command.getAssignment().getIntegerProxyId())
      throw new ProcessingException(
          "Priority already assigned with id " + command.getAssignment().getIntegerProxyId());

    apply(
        new AssignPriorityToBusNameMarkerEvent(
            command.getBusNameMarkerId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignPriorityFromBusNameMarkerCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignPriorityFromBusNameMarkerCommand");

    if (priority == null) throw new ProcessingException("Priority already has nothing assigned.");

    apply(new UnAssignPriorityFromBusNameMarkerEvent(command.getBusNameMarkerId()));
  }

  // multiple association commands
  @CommandHandler
  public void handle(AssignBusNameMarkerToBusNameMarkerCommand command) throws Exception {
    LOGGER.info("Handling command AssignBusNameMarkerToBusNameMarkerCommand");

    if (busNameMarker.contains(command.getAddTo()))
      throw new ProcessingException(
          "BusNameMarker already contains an entity with id "
              + command.getAddTo().getBusNameMarkerId());

    apply(
        new AssignBusNameMarkerToBusNameMarkerEvent(
            command.getBusNameMarkerId(), command.getAddTo()));
  }

  @CommandHandler
  public void handle(RemoveBusNameMarkerFromBusNameMarkerCommand command) throws Exception {
    LOGGER.info("Handling command RemoveBusNameMarkerFromBusNameMarkerCommand");

    if (!busNameMarker.contains(command.getRemoveFrom()))
      throw new ProcessingException(
          "BusNameMarker does not contain an entity with id "
              + command.getRemoveFrom().getBusNameMarkerId());

    apply(
        new RemoveBusNameMarkerFromBusNameMarkerEvent(
            command.getBusNameMarkerId(), command.getRemoveFrom()));
  }

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateBusNameMarkerEvent event) {
    LOGGER.info("Event sourcing CreateBusNameMarkerEvent");
    this.busNameMarkerId = event.getBusNameMarkerId();
  }

  @EventSourcingHandler
  void on(UpdateBusNameMarkerEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.priority = event.getPriority();
    this.busNameMarker = event.getBusNameMarker();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignPriorityToBusNameMarkerEvent event) {
    LOGGER.info("Event sourcing AssignPriorityToBusNameMarkerEvent");
    this.priority = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignPriorityFromBusNameMarkerEvent event) {
    LOGGER.info("Event sourcing UnAssignPriorityFromBusNameMarkerEvent");
    this.priority = null;
  }

  // multiple associations
  @EventSourcingHandler
  void on(AssignBusNameMarkerToBusNameMarkerEvent event) {
    LOGGER.info("Event sourcing AssignBusNameMarkerToBusNameMarkerEvent");
    this.busNameMarker.add(event.getAddTo());
  }

  @EventSourcingHandler
  void on(RemoveBusNameMarkerFromBusNameMarkerEvent event) {
    LOGGER.info("Event sourcing RemoveBusNameMarkerFromBusNameMarkerEvent");
    this.busNameMarker.remove(event.getRemoveFrom());
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID busNameMarkerId;

  private IntegerProxy priority = null;
  private Set<BusNameMarker> busNameMarker = new HashSet<>();

  private static final Logger LOGGER = Logger.getLogger(BusNameMarkerAggregate.class.getName());
}

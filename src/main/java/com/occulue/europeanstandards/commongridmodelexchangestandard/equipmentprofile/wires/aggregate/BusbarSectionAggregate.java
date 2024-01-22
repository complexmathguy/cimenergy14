package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.aggregate;

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
 * Aggregate handler for BusbarSection as outlined for the CQRS pattern, all write responsibilities
 * related to BusbarSection are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class BusbarSectionAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public BusbarSectionAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public BusbarSectionAggregate(CreateBusbarSectionCommand command) throws Exception {
    LOGGER.info("Handling command CreateBusbarSectionCommand");
    CreateBusbarSectionEvent event = new CreateBusbarSectionEvent(command.getBusbarSectionId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateBusbarSectionCommand command) throws Exception {
    LOGGER.info("handling command UpdateBusbarSectionCommand");
    UpdateBusbarSectionEvent event =
        new UpdateBusbarSectionEvent(command.getBusbarSectionId(), command.getIpMax());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteBusbarSectionCommand command) throws Exception {
    LOGGER.info("Handling command DeleteBusbarSectionCommand");
    apply(new DeleteBusbarSectionEvent(command.getBusbarSectionId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignIpMaxToBusbarSectionCommand command) throws Exception {
    LOGGER.info("Handling command AssignIpMaxToBusbarSectionCommand");

    if (ipMax != null && ipMax.getCurrentFlowId() == command.getAssignment().getCurrentFlowId())
      throw new ProcessingException(
          "IpMax already assigned with id " + command.getAssignment().getCurrentFlowId());

    apply(
        new AssignIpMaxToBusbarSectionEvent(command.getBusbarSectionId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignIpMaxFromBusbarSectionCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignIpMaxFromBusbarSectionCommand");

    if (ipMax == null) throw new ProcessingException("IpMax already has nothing assigned.");

    apply(new UnAssignIpMaxFromBusbarSectionEvent(command.getBusbarSectionId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateBusbarSectionEvent event) {
    LOGGER.info("Event sourcing CreateBusbarSectionEvent");
    this.busbarSectionId = event.getBusbarSectionId();
  }

  @EventSourcingHandler
  void on(UpdateBusbarSectionEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.ipMax = event.getIpMax();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignIpMaxToBusbarSectionEvent event) {
    LOGGER.info("Event sourcing AssignIpMaxToBusbarSectionEvent");
    this.ipMax = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignIpMaxFromBusbarSectionEvent event) {
    LOGGER.info("Event sourcing UnAssignIpMaxFromBusbarSectionEvent");
    this.ipMax = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID busbarSectionId;

  private CurrentFlow ipMax = null;

  private static final Logger LOGGER = Logger.getLogger(BusbarSectionAggregate.class.getName());
}

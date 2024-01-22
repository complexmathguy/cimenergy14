package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.operationallimits.aggregate;

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
 * Aggregate handler for VoltageLimit as outlined for the CQRS pattern, all write responsibilities
 * related to VoltageLimit are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class VoltageLimitAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public VoltageLimitAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public VoltageLimitAggregate(CreateVoltageLimitCommand command) throws Exception {
    LOGGER.info("Handling command CreateVoltageLimitCommand");
    CreateVoltageLimitEvent event = new CreateVoltageLimitEvent(command.getVoltageLimitId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateVoltageLimitCommand command) throws Exception {
    LOGGER.info("handling command UpdateVoltageLimitCommand");
    UpdateVoltageLimitEvent event =
        new UpdateVoltageLimitEvent(command.getVoltageLimitId(), command.getValue());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteVoltageLimitCommand command) throws Exception {
    LOGGER.info("Handling command DeleteVoltageLimitCommand");
    apply(new DeleteVoltageLimitEvent(command.getVoltageLimitId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignValueToVoltageLimitCommand command) throws Exception {
    LOGGER.info("Handling command AssignValueToVoltageLimitCommand");

    if (value != null && value.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "Value already assigned with id " + command.getAssignment().getVoltageId());

    apply(new AssignValueToVoltageLimitEvent(command.getVoltageLimitId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignValueFromVoltageLimitCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignValueFromVoltageLimitCommand");

    if (value == null) throw new ProcessingException("Value already has nothing assigned.");

    apply(new UnAssignValueFromVoltageLimitEvent(command.getVoltageLimitId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateVoltageLimitEvent event) {
    LOGGER.info("Event sourcing CreateVoltageLimitEvent");
    this.voltageLimitId = event.getVoltageLimitId();
  }

  @EventSourcingHandler
  void on(UpdateVoltageLimitEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.value = event.getValue();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignValueToVoltageLimitEvent event) {
    LOGGER.info("Event sourcing AssignValueToVoltageLimitEvent");
    this.value = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignValueFromVoltageLimitEvent event) {
    LOGGER.info("Event sourcing UnAssignValueFromVoltageLimitEvent");
    this.value = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID voltageLimitId;

  private Voltage value = null;

  private static final Logger LOGGER = Logger.getLogger(VoltageLimitAggregate.class.getName());
}

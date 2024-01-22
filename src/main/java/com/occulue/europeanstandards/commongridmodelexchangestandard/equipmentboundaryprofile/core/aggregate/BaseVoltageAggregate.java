package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.aggregate;

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
 * Aggregate handler for BaseVoltage as outlined for the CQRS pattern, all write responsibilities
 * related to BaseVoltage are handled here.
 *
 * @author your_name_here
 */
@Aggregate
public class BaseVoltageAggregate {

  // -----------------------------------------
  // Axon requires an empty constructor
  // -----------------------------------------
  public BaseVoltageAggregate() {}

  // ----------------------------------------------
  // intrinsic command handlers
  // ----------------------------------------------
  @CommandHandler
  public BaseVoltageAggregate(CreateBaseVoltageCommand command) throws Exception {
    LOGGER.info("Handling command CreateBaseVoltageCommand");
    CreateBaseVoltageEvent event = new CreateBaseVoltageEvent(command.getBaseVoltageId());

    apply(event);
  }

  @CommandHandler
  public void handle(UpdateBaseVoltageCommand command) throws Exception {
    LOGGER.info("handling command UpdateBaseVoltageCommand");
    UpdateBaseVoltageEvent event =
        new UpdateBaseVoltageEvent(command.getBaseVoltageId(), command.getNominalVoltage());

    apply(event);
  }

  @CommandHandler
  public void handle(DeleteBaseVoltageCommand command) throws Exception {
    LOGGER.info("Handling command DeleteBaseVoltageCommand");
    apply(new DeleteBaseVoltageEvent(command.getBaseVoltageId()));
  }

  // ----------------------------------------------
  // association command handlers
  // ----------------------------------------------

  // single association commands
  @CommandHandler
  public void handle(AssignNominalVoltageToBaseVoltageCommand command) throws Exception {
    LOGGER.info("Handling command AssignNominalVoltageToBaseVoltageCommand");

    if (nominalVoltage != null
        && nominalVoltage.getVoltageId() == command.getAssignment().getVoltageId())
      throw new ProcessingException(
          "NominalVoltage already assigned with id " + command.getAssignment().getVoltageId());

    apply(
        new AssignNominalVoltageToBaseVoltageEvent(
            command.getBaseVoltageId(), command.getAssignment()));
  }

  @CommandHandler
  public void handle(UnAssignNominalVoltageFromBaseVoltageCommand command) throws Exception {
    LOGGER.info("Handlign command UnAssignNominalVoltageFromBaseVoltageCommand");

    if (nominalVoltage == null)
      throw new ProcessingException("NominalVoltage already has nothing assigned.");

    apply(new UnAssignNominalVoltageFromBaseVoltageEvent(command.getBaseVoltageId()));
  }

  // multiple association commands

  // ----------------------------------------------
  // intrinsic event source handlers
  // ----------------------------------------------
  @EventSourcingHandler
  void on(CreateBaseVoltageEvent event) {
    LOGGER.info("Event sourcing CreateBaseVoltageEvent");
    this.baseVoltageId = event.getBaseVoltageId();
  }

  @EventSourcingHandler
  void on(UpdateBaseVoltageEvent event) {
    LOGGER.info("Event sourcing classObject.getUpdateEventAlias()}");
    this.nominalVoltage = event.getNominalVoltage();
  }

  // ----------------------------------------------
  // association event source handlers
  // ----------------------------------------------
  // single associations
  @EventSourcingHandler
  void on(AssignNominalVoltageToBaseVoltageEvent event) {
    LOGGER.info("Event sourcing AssignNominalVoltageToBaseVoltageEvent");
    this.nominalVoltage = event.getAssignment();
  }

  @EventSourcingHandler
  void on(UnAssignNominalVoltageFromBaseVoltageEvent event) {
    LOGGER.info("Event sourcing UnAssignNominalVoltageFromBaseVoltageEvent");
    this.nominalVoltage = null;
  }

  // ------------------------------------------
  // attributes
  // ------------------------------------------

  @AggregateIdentifier private UUID baseVoltageId;

  private Voltage nominalVoltage = null;

  private static final Logger LOGGER = Logger.getLogger(BaseVoltageAggregate.class.getName());
}
